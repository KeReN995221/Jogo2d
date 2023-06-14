package br.ifpr.jogo.modelo;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Fase extends JPanel {

    private Image imagemFundo;
    private Personagem personagem;

    public Fase() {

        ImageIcon carregando = new ImageIcon("recursos\\fundo.jpg");
        this.imagemFundo = carregando.getImage();

        this.personagem = new Personagem();
        this.personagem.carregar();
    }

    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;

        graficos.drawImage(this.imagemFundo, 0, 0, null);
        graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosicaoX(), this.personagem.getPosicaoY(),
                null);

        g.dispose();
    }
}