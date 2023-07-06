package br.ifpr.jogo.modelo;
import javax.swing.ImageIcon;

public class Tiro extends ElementoGrafico{
    private static int velocidade = 2;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        super.setPosicaoEmX(posicaoPersonagemEmY +20);
        super.setPosicaoEmY(posicaoPersonagemEmY +10);
    }
     public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\arma.png");
        super.setImagem(carregando.getImage());
        super.setLarguraImagem(super.getImagem().getWidth(null));
        super.setAlturaImagem (super.getImagem().getHeight(null));
    }

    public void atualizar() {
        super.setPosicaoEmX(getPosicaoEmX() + velocidade); 
    }


}