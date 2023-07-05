package br.ifpr.jogo.modelo;
import br.ifpr.jogo.modelo.ElementoGrafico;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Inimigo extends ElementoGrafico {
   
    private static int velocidade = 2;

    public Inimigo(int xAleatorio, int yAleatorio) {
        super.posicaoEmX = xAleatorio;
        super.posicaoEmY = yAleatorio;
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\inimigo.png");
        super.imagem = carregando.getImage();
        super.alturaImagem = super.imagem.getWidth(null);
        super.larguraImagem = super.imagem.getHeight(null);
    }

    public void atualizar() {
        super.posicaoEmX = super.posicaoEmX - velocidade;
    }

   
}