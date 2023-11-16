package br.ifpr.jogo.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
    @JoinColumn(name = "fase_id")
    private Fase fase;

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

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

}