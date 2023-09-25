package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;

public class SuperTiro extends ElementoGrafico {
    private static int velocidade = 2;

    public SuperTiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        super.setPosicaoEmX(posicaoPersonagemEmX - 35);
        super.setPosicaoEmY(posicaoPersonagemEmY - 50);
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon (getClass().getResource("/arma.png"));
        this.setImagem(carregando.getImage());
        this.setLarguraImagem(getImagem().getWidth(null));
        this.setAlturaImagem(getImagem().getHeight(null));
    }

    @Override
    public void atualizar() {
        super.setPosicaoEmX(getPosicaoEmX() + velocidade);
    }
}
