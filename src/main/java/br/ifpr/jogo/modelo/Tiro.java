package br.ifpr.jogo.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

@Entity
@Table(name = "tb_tiro")
public class Tiro extends ElementoGrafico {

    @Transient
    private static int velocidade = 2;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personagem_id")
    private Personagem personagem;

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        super.setPosicaoEmX(posicaoPersonagemEmX - 35);
        super.setPosicaoEmY(posicaoPersonagemEmY - 35);
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/osso.png"));
        this.setImagem(carregando.getImage());
        this.setLarguraImagem(getImagem().getWidth(null));
        this.setAlturaImagem(getImagem().getHeight(null));
    }

    @Override
    public void atualizar() {
        super.setPosicaoEmX(getPosicaoEmX() + velocidade);
    }

}