package br.ifpr.jogo.modelo;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Tiro extends ElementoGrafico{

    private static int velocidade = 2;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {

        super.setPosicaoEmX (posicaoPersonagemEmX - 125);
        super.setPosicaoEmY (posicaoPersonagemEmY);
    }
     public void carregar() {
        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\jogo2d\\Jogo2d\\Recursos\\osso.png");
        this.setImagem( carregando.getImage());
        super.setLarguraImagem(getImagem().getWidth(null));
        super.setAlturaImagem(getImagem().getHeight(null));

    }

    public void atualizar() {
        super.setPosicaoEmX(getPosicaoEmX() + velocidade);
    }
    

    

}


