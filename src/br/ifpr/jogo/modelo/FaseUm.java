package br.ifpr.jogo.modelo;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Timer;

public class FaseUm extends Fase {

    public FaseUm() {
        super();
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\jogo2d\\Jogo2d\\Recursos\\fundo2.jpg");
        this.imagemFundo = carregando.getImage();

        this.personagem = new Personagem();
        this.personagem.carregar();

        this.inicializaInimigos();
        addKeyListener(this);
        timer = new Timer(delay, this);
        timer.start();
        
    }

    @Override
    public void verificarColisoes() {
        Rectangle formaPersonagem = this.personagem.getRectangle();
        for (int i = 0; i < this.inimigos.size(); i++) {
            
            Inimigo inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();

            if (formaInimigo.intersects(formaPersonagem)) {
                this.personagem.setEhVisivel(false);
                inimigo.setEhVisivel(false);
                emJogo  = false;
            }
            ArrayList<Tiro> tiros = this.personagem.getTiros();

            for (int j = 0; j < tiros.size(); j++) {
                Tiro tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();
                if (formaInimigo.intersects(formaTiro)) {
                    inimigo.setEhVisivel(false);
                    tiro.setEhVisivel(false);
                }
            }

            ArrayList<SuperTiro> stiros = this.personagem.getSuperTiro();
            for (int j = 0; j < stiros.size(); j++) {
                SuperTiro stiro = stiros.get(j);
                Rectangle formaTiro = stiro.getRectangle();
                if (formaInimigo.intersects(formaTiro)) {
                    inimigo.setEhVisivel(false);
                    stiro.setEhVisivel(false);
                }
         
               
            } 
        }  
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;
        if (emJogo) {
            graficos.drawImage(this.imagemFundo, 0, 0, null);
            graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosicaoEmX(),
                    this.personagem.getPosicaoEmY(), null);
            ArrayList<Tiro> tiros = personagem.getTiros();
            ArrayList<SuperTiro> stiros = this.personagem.getSuperTiro();
            for (Tiro tiro : tiros) {

                tiro.carregar();

                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
            }
            
            for (SuperTiro stiro : stiros) {

                stiro.carregar();

                graficos.drawImage(stiro.getImagem(), stiro.getPosicaoEmX(), stiro.getPosicaoEmY(), this);
            }
            for (Inimigo inimigo : inimigos) {

                inimigo.carregar();
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
            }

        } else {
            ImageIcon fimDeJogo = new ImageIcon("recursos\\fimdejogo.png");
            graficos.drawImage(fimDeJogo.getImage(), 0, 0, null);
            
        }
        this.verificarColisoes();
        g.dispose();
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
        ArrayList<Tiro> tiros = personagem.getTiros();
        
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.get(i);
            if (tiro.getPosicaoEmX() > larg_janela)

                tiros.remove(i);
            else

                tiro.atualizar();
        }
        ArrayList<SuperTiro> stiros = personagem.getSuperTiro();
        for (int i = 0; i < stiros.size(); i++) {
            SuperTiro stiro = stiros.get(i);
            if (stiro.getPosicaoEmX() > larg_janela)

                stiros.remove(i);
            else

                stiro.atualizar();
        }
        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo inimigo = inimigos.get(i);
            if (inimigo.getPosicaoEmX() < 0)

                inimigos.remove(i);
            else

                inimigo.atualizar();
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            personagem.atirar();
        else if (e.getKeyCode() == KeyEvent.VK_V)
            personagem.sAtirar();
        else
            personagem.mover(e);
    }

}