package br.ifpr.jogo.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

@Entity
@Table(name = "tb_dino")
public class Dino extends ElementoGrafico {

    @Transient
    private static final int VELOCIDADE = 1;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_fase")
    private FaseUm fase_um;

    public FaseUm getFaseUm() {
        return fase_um;
    }

    public void setFaseUm(FaseUm fase_um) {
        this.fase_um = fase_um;
    }

    public Dino(int xAleatorio, int yAleatorio) {
        this.carregar();
        super.setPosicaoEmX(xAleatorio);
        super.setPosicaoEmY(yAleatorio);
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/dino.png"));
        super.setImagem(carregando.getImage());
    }

    @Override
    public void atualizar() {
        if (this.getPosicaoEmX() < 0) {
            int y = (int) (Math.random() * 618);
            super.setPosicaoEmX(1000);
            super.setPosicaoEmY(y);
        } else {
            super.setPosicaoEmX(super.getPosicaoEmX() - VELOCIDADE);
        }
    }
}