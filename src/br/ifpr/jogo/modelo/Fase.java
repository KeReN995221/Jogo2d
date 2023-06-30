package br.ifpr.jogo.modelo;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener, KeyListener {

    private Image imagemFundo;
    private Personagem personagem;
    private static final int delay = 5;
    private Timer timer;
    private static final int larg_janela = 2500;
    private ArrayList<Inimigo> inimigos;
    private static final int qtdInimigos = 40;
    public Fase() {
        setFocusable(true);           
        setDoubleBuffered(true);

        ImageIcon carregando = new ImageIcon("recursos\\fundo.png");
        this.imagemFundo = carregando.getImage();

        this.personagem = new Personagem();
        this.personagem.carregar();
            
        this.inicializaInimigos();
        addKeyListener((KeyListener) this);
        timer = new Timer(delay, (ActionListener) this);    
        timer.start();   
    }

    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;

        graficos.drawImage(this.imagemFundo, 0, 0, null);
        graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosicaoX(), this.personagem.getPosicaoY(),null);
        ArrayList<Tiro> tiros = personagem.getTiros();

        for (Tiro tiro : tiros) {
            
            tiro.carregar();
            
            graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
        }

         for (Inimigo inimigo : inimigos) {
            
            inimigo.carregar();
            
            graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
        }

        g.dispose();
    }

    public void inicializaInimigos(){
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
        
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
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
        
            if (tiros.get(i).getPosicaoEmX() > larg_janela)
                
                tiros.remove(i);
            else
                
                tiros.get(i).atualizar();
            }
            for (int i = 0; i < inimigos.size(); i++) {
            
                if (inimigos.get(i).getPosicaoEmX() < 0)
                    
                    inimigos.remove(i);
                else
                    
                    inimigos.get(i).atualizar();
            }
            repaint();
        }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            personagem.atirar();
        else
            personagem.mover(e);
    }


}