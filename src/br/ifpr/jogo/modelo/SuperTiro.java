package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;

public class SuperTiro extends ElementoGrafico {
    private static int velocidade = 2;

    public SuperTiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        super.setPosicaoEmX(posicaoPersonagemEmX +20);
        super.setPosicaoEmY(posicaoPersonagemEmY +10);
    }
    @Override
     public void carregar() {
        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\jogo2d\\Jogo2d\\Recursos\\arma.png");
        super.setImagem(carregando.getImage());
        super.setLarguraImagem(super.getImagem().getWidth(null));
        super.setAlturaImagem (super.getImagem().getHeight(null));
    }
    @Override
    public void atualizar() {
        super.setPosicaoEmX(getPosicaoEmX() + velocidade); 
    }


}
