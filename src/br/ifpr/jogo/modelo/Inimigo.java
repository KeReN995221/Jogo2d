package br.ifpr.jogo.modelo;


import javax.swing.ImageIcon;

public class Inimigo extends ElementoGrafico {
   
    private static int velocidade = 2;

    public Inimigo(int xAleatorio, int yAleatorio) {
        super.setPosicaoEmX(xAleatorio);
        super.setPosicaoEmY(yAleatorio);
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\inimigo.png");
        this.setImagem(carregando.getImage()); 
        super.setLarguraImagem(super.getImagem().getWidth(null));
        super.setAlturaImagem (super.getImagem().getHeight(null));
    }

    public void atualizar() {
        super.setPosicaoEmX(getPosicaoEmX() - velocidade);
    }  
}