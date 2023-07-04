package br.ifpr.jogo.modelo;
import br.ifpr.jogo.modelo.ElementoGrafico;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Tiro extends ElementoGrafico{

    private static int velocidade = 2;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        super.posicaoEmX = posicaoPersonagemEmX - 125;
        super.posicaoEmY = posicaoPersonagemEmY;
    }
     public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\arma.png");
        super.imagem = carregando.getImage();
        super.alturaImagem = super.imagem.getWidth(null);
        super.larguraImagem = super.imagem.getHeight(null);
    }

    public void atualizar() {
        super.posicaoEmX = super.posicaoEmX + velocidade;
    }

    

}


