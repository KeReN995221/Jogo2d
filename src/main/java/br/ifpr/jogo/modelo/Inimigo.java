package br.ifpr.jogo.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

@Entity
@Table(name = "tb_inimigo")
public class Inimigo extends ElementoGrafico {

    @Transient
    private static int velocidade = 2;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_fase")
    private FaseUm fase_um;

    public FaseUm getFaseUm() {
        return fase_um;
    }

    public void setFaseUm(FaseUm fase_um) {
        this.fase_um = fase_um;
    }

    public Inimigo(int xAleatorio, int yAleatorio) {
        super.setPosicaoEmX(xAleatorio);
        super.setPosicaoEmY(yAleatorio);

    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/inimigo.png"));
        this.setImagem(carregando.getImage());
        this.setLarguraImagem(getImagem().getWidth(null));
        this.setAlturaImagem(getImagem().getHeight(null));
    }

    public void atualizar() {

        super.setPosicaoEmX(getPosicaoEmX() - velocidade);
    }

}