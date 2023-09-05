package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;

public class Tiro extends ElementoGrafico {
    private static int velocidade = 2;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        super.setPosicaoEmX(posicaoPersonagemEmX - 35);
        super.setPosicaoEmY(posicaoPersonagemEmY - 35);
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon("Recursos\\osso.png");
        this.setImagem(carregando.getImage());
        this.setLarguraImagem(getImagem().getWidth(null));
        this.setAlturaImagem(getImagem().getHeight(null));
    }

    @Override
    public void atualizar() {
        super.setPosicaoEmX(getPosicaoEmX() + velocidade);
    }
}