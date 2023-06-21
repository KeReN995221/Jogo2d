package br.ifpr.jogo.modelo;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    public Fase() {
        setFocusable(true);           
        setDoubleBuffered(true);

        ImageIcon carregando = new ImageIcon("recursos\\pixelArt.png");
        this.imagemFundo = carregando.getImage();

        this.personagem = new Personagem();
        this.personagem.carregar();

        addKeyListener((KeyListener) this);
        timer = new Timer(delay, (ActionListener) this);    
        timer.start();   
    }

    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;

        graficos.drawImage(this.imagemFundo, 0, 0, null);
        graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosicaoX(), this.personagem.getPosicaoY(),
                null);

        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        personagem.parar(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        personagem.atualizar();
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