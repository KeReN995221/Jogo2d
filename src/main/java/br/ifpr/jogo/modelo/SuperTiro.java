package br.ifpr.jogo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

@Entity
@Table(name = "tb_super_tiro")
public class SuperTiro extends ElementoGrafico {

    @Transient
    private static int velocidade = 2;

    @ManyToOne
    @JoinColumn(name = "fk_personagem")
    private Personagem personagem;

    public SuperTiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        super.setPosicaoEmX(posicaoPersonagemEmX - 35);
        super.setPosicaoEmY(posicaoPersonagemEmY - 50);
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/arma.png"));
        this.setImagem(carregando.getImage());
        this.setLarguraImagem(getImagem().getWidth(null));
        this.setAlturaImagem(getImagem().getHeight(null));
    }

    @Override
    public void atualizar() {
        super.setPosicaoEmX(getPosicaoEmX() + velocidade);
    }
    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
 
    
}
