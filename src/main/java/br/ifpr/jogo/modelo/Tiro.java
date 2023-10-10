package br.ifpr.jogo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.swing.ImageIcon;
@Entity
@Table (name = "tb_tiro")
public class Tiro extends ElementoGrafico {

    @Column (name = "velocidade_tiro")
    private static int velocidade = 2;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        super.setPosicaoEmX(posicaoPersonagemEmX - 35);
        super.setPosicaoEmY(posicaoPersonagemEmY - 35);
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon (getClass().getResource("/osso.png"));
        this.setImagem(carregando.getImage());
        this.setLarguraImagem(getImagem().getWidth(null));
        this.setAlturaImagem(getImagem().getHeight(null));
    }

    @Override
    public void atualizar() {
        super.setPosicaoEmX(getPosicaoEmX() + velocidade);
    }
}