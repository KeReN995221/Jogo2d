package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import br.ifpr.jogo.controle.FaseControler;
import br.ifpr.jogo.servico.FaseServico;

@Entity
@Table(name = "tb_fase_um")
public class FaseUm extends Fase {

    @Transient
    private static final int pontoInimigo = 10;

    @OneToMany(mappedBy = "fase_um")
    protected List<Dino> dinos;

    @OneToMany(mappedBy = "fase_um")
    protected List<Inimigo> inimigos;

    @Transient
    FaseControler faseControler = new FaseControler();

    public FaseUm() {
        super();
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon carregando = new ImageIcon(getClass().getResource("/fundo2.jpg"));
        this.imagemFundo = carregando.getImage();

        this.personagem = new Personagem();
        this.personagem.carregar();

        this.inicializaElementosGraficosAdicionais();
        this.inicializaInimigos();

        addKeyListener(null);

        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void inicializaInimigos() {
        inimigos = faseControler.inicializaInimigos(qtdInimigos);

        /*
         * inimigos = new ArrayList<Inimigo>();
         * for (int i = 0; i < qtdInimigos; i++) {
         * int x = (int) (Math.random() * 8000 + 1024);
         * int y = (int) (Math.random() * 650 + 30);
         * Inimigo inimigo = new Inimigo(x, y);
         * inimigos.add(inimigo);
         * }
         */
    }

    @Override
    public void verficarColisoes() {

        // Rectangle formaPersonagem = this.personagem.getRectangle();
        for (int i = 0; i < this.inimigos.size(); i++) {

            Inimigo inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();

            emJogo = faseControler.verficarColisoesPersonagem(inimigo, personagem, emJogo); // chamando o métod da fase
                                                                                            // controle

            List<Tiro> tiros = this.personagem.getTiros();
            for (int j = 0; j < tiros.size(); j++) {
                Tiro tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();
                if (formaTiro.intersects(formaInimigo)) {
                    int pontuacaoAtual = this.personagem.getPontuacao();
                    this.personagem.setPontuacao(pontoInimigo + pontuacaoAtual);

                    inimigo.setEhVisivel(false);
                    tiro.setEhVisivel(false);
                }
            }
            List<SuperTiro> stiros = this.personagem.getStiros();
            for (int k = 0; k < stiros.size(); k++) {
                SuperTiro stiro = stiros.get(k);
                Rectangle formaSuperTiro = stiro.getRectangle();
                if (formaSuperTiro.intersects(formaInimigo)) {
                    int pontuacaoAtual = this.personagem.getPontuacao();
                    this.personagem.setPontuacao(pontoInimigo + pontuacaoAtual);

                    inimigo.setEhVisivel(false);
                    stiro.setEhVisivel(false);
                }
            }
        }
    }

    @Override
    public void inicializaElementosGraficosAdicionais() {
        this.dinos = new ArrayList<Dino>();
        for (int i = 0; i < qtd_dinos; i++) {
            int x = (int) (Math.random() * 1000);
            int y = (int) (Math.random() * 618);
            Dino dino = new Dino(x, y);
            this.dinos.add(dino);
        }
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;
        if (emJogo) {
            graficos.drawImage(this.imagemFundo, 0, 0, null);
            for (Dino dino : dinos) {
                // Desenhar o dino na nossa tela.
                graficos.drawImage(dino.getImagem(), dino.getPosicaoEmX(), dino.getPosicaoEmY(), this);

            }

            graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosicaoEmX(),
                    this.personagem.getPosicaoEmY(), null);

            List<Tiro> tiros = personagem.getTiros();

            for (Tiro tiro : tiros) {

                tiro.carregar();

                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
            }

            List<SuperTiro> stiros = personagem.getStiros();

            for (SuperTiro stiro : stiros) {

                stiro.carregar();

                graficos.drawImage(stiro.getImagem(), stiro.getPosicaoEmX(), stiro.getPosicaoEmY(), this);
            }

            for (Inimigo inimigo : inimigos) {

                inimigo.carregar();
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
            }

            super.desenhaPontuacao(graficos);
            super.desenhaVidas(graficos);

        } else {
            ImageIcon fimDeJogo = new ImageIcon(getClass().getResource("/fimdejogo.png"));
            graficos.drawImage(fimDeJogo.getImage(), 0, 0, null);
            // chamar o inserir do fase dao aqui
            // FaseServico faseServico = faseServico.inserir();

        }

        verficarColisoes();
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        personagem.parar(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        personagem.atualizar();
        for (Dino dino : this.dinos) {
            dino.atualizar();
        }
        List<Tiro> tiros = personagem.getTiros();
        for (int i = 0; i < tiros.size(); i++) {

            Tiro tiro = tiros.get(i);

            if (tiro.getPosicaoEmX() > larg_janela || !tiro.isEhVisivel())

                tiros.remove(tiro);
            else

                tiro.atualizar();
        }

        List<SuperTiro> stiros = personagem.getStiros();
        for (int i = 0; i < stiros.size(); i++) {

            SuperTiro stiro = stiros.get(i);

            if (stiro.getPosicaoEmX() > larg_janela || !stiro.isEhVisivel())

                stiros.remove(stiro);
            else

                stiro.atualizar();
        }
        for (int i = 0; i < inimigos.size(); i++) {

            Inimigo inimigo = inimigos.get(i);

            if (inimigo.getPosicaoEmX() < 0 || !inimigo.isEhVisivel())

                inimigos.remove(inimigo);
            else

                inimigo.atualizar();
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int teclado = e.getKeyCode();
        // int novaPosicaoX = personagem.getPosicaoEmX();
        // int novaPosicaoY = personagem.getPosicaoEmY();
        if (teclado == KeyEvent.VK_SPACE)
            personagem.atirar();
        else if (teclado == KeyEvent.VK_Q)
            personagem.sAtirar();

        else if (teclado == KeyEvent.VK_ENTER)
            FaseServico.inserir(this);

        else if (teclado == KeyEvent.VK_F) {
            timer.stop();
            String idJogo = JOptionPane.showInputDialog("Informe o Id (número do jogo que você queira carregar: )");
            if (idJogo != null && !idJogo.isEmpty()) {
                timer.start();
                int id = Integer.parseInt(idJogo); // converte string para inteiro
                FaseServico.buscarPorId(id);
                personagem.carregar();
                personagem.setVidas(5);
                emJogo = true;
            }
        }

        else
            personagem.mover(e);

    }
}