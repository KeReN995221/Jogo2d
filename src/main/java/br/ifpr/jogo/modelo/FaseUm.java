package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.swing.ImageIcon;
import javax.swing.Timer;

@Entity
@Table(name  = "tb_fase_um")
public class FaseUm extends Fase { 

    

    private static final int pontoInimigo = 10;
    
    public FaseUm() {
        super();
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon carregando = new ImageIcon (getClass().getResource("/fundo2.jpg"));
        this.imagemFundo = carregando.getImage();

        this.personagem = new Personagem();
        this.personagem.carregar();
        addKeyListener(this);

        this.inicializaElementosGraficosAdicionais();

        this.inicializaInimigos();
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void verficarColisoes() {
        Rectangle formaPersonagem = this.personagem.getRectangle();
        for (int i = 0; i < this.inimigos.size(); i++) {

            Inimigo inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();
            if (formaInimigo.intersects(formaPersonagem)) {
                int vidaNow = this.personagem.getVidas();
                this.personagem.setVidas(vidaNow -1);
                inimigo.setEhVisivel(false);

                if (this.personagem.getVidas() == 0){
                    this.personagem.setEhVisivel(false);
                    inimigo.setEhVisivel(false);
                    emJogo = false;
                }
            }
            List<Tiro> tiros = this.personagem.getTiros();
            for (int j = 0; j < tiros.size(); j++) {
                Tiro tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();
                if (formaTiro.intersects(formaInimigo)) {
                    int pontuacaoAtual = this.personagem.getPontuacao();
                    this.personagem.setPontuacao (pontoInimigo + pontuacaoAtual);
                    
                    inimigo.setEhVisivel(false);
                    tiro.setEhVisivel(false);
                }
            }
            ArrayList<SuperTiro> stiros = this.personagem.getStiros();
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
    public void inicializaInimigos() {
        inimigos = new ArrayList<Inimigo>();

        for (int i = 0; i < qtdInimigos; i++) {
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            Inimigo inimigo = new Inimigo(x, y);
            inimigos.add(inimigo);
        }
    }

    @Override
    public void inicializaElementosGraficosAdicionais() {
        super.dinos = new ArrayList<Dino>();
        for (int i = 0; i < qtd_dinos; i++) {
            int x = (int) (Math.random() * 1000);
            int y = (int) (Math.random() * 618);
            Dino dino = new Dino(x, y);
            super.dinos.add(dino);
        }
    }
    @Override
    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;
        if (emJogo) {
            graficos.drawImage(this.imagemFundo, 0, 0, null);
            for (Dino  dino : dinos) {
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

            ArrayList<SuperTiro> stiros = personagem.getStiros();

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
            ImageIcon fimDeJogo = new ImageIcon (getClass().getResource("/fimdejogo.png"));
            graficos.drawImage(fimDeJogo.getImage(), 0, 0, null);
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

        ArrayList<SuperTiro> stiros = personagem.getStiros();
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
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            personagem.atirar();
        else if (e.getKeyCode() == KeyEvent.VK_Q)
            personagem.sAtirar();
        else
            personagem.mover(e);
    }
}