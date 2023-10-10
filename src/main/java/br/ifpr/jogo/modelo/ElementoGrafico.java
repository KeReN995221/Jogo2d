package br.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
@Entity
@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)
public abstract class ElementoGrafico {

    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    @Column(name =  "id_elemento_grafico")
    private Integer id_elemento_grafico; 

    

    @Column(name = "posicao_em_x")
    private int posicaoEmX;
    
    @Column(name = "posicao_em_y")
    private int posicaoEmY;

    @Column (name =  "largura_imagem")
    private int larguraImagem;

    @Column (name =  "altura_imagem")
    private int alturaImagem;

    @Transient
    private Image imagem;

   
    private boolean ehVisivel = true;

    public Rectangle getRectangle() {

        return new Rectangle(posicaoEmX, posicaoEmY, larguraImagem, alturaImagem);
    }

    public abstract void carregar();

    public abstract void atualizar();

    public Integer getId_elemento_grafico() {
        return id_elemento_grafico;
    }

    public void setId_elemento_grafico(Integer id_elemento_grafico) {
        this.id_elemento_grafico = id_elemento_grafico;
    }


    public int getPosicaoEmX() {
        return this.posicaoEmX;
    }

    public void setPosicaoEmX(int posicaoEmX) {
        this.posicaoEmX = posicaoEmX;
    }

    public int getPosicaoEmY() {
        return this.posicaoEmY;
    }

    public void setPosicaoEmY(int posicaoEmY) {
        this.posicaoEmY = posicaoEmY;
    }

    public Image getImagem() {
        return this.imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public int getLarguraImagem() {
        return this.larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImagem() {
        return this.alturaImagem;
    }

    public void setAlturaImagem(int alturaImagem) {
        this.alturaImagem = alturaImagem;
    }

    public boolean isEhVisivel() {
        return this.ehVisivel;
    }

    public boolean getEhVisivel() {
        return this.ehVisivel;
    }

    public void setEhVisivel(boolean ehVisivel) {
        this.ehVisivel = ehVisivel;
    }
}