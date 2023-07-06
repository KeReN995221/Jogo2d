package br.ifpr.jogo.modelo;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Inimigo extends ElementoGrafico {
   
    private static int velocidade = 2;

    public Inimigo(int xAleatorio, int yAleatorio) {
        super.setPosicaoEmX(xAleatorio);
        super.setPosicaoEmY(yAleatorio); 
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\jogo2d\\Jogo2d\\Recursos\\inimigo.png");
        super.setImagem (carregando.getImage());
        super.setLarguraImagem(super.getImagem().getWidth(null));
        super.setAlturaImagem (super.getImagem().getHeight(null));
    }

    public void atualizar() {
       super.setPosicaoEmX(getPosicaoEmX() - velocidade);
    }

    public Rectangle getRectangle() {
        return null;
    }

    public void setEhVisivel(boolean b) {
    }

   
}