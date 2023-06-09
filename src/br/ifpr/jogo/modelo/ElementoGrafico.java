package br.ifpr.jogo.modelo;
import java.awt.Image;
import java.awt.Rectangle;
public abstract  class ElementoGrafico {
    private int posicaoEmX;
    private int posicaoEmY;
    private Image imagem; 
    private int larguraImagem;
    private int alturaImagem;
    private boolean ehVisivel = true;

    public boolean isEhVisivel() {
        return ehVisivel;
    }
    public void setEhVisivel(boolean ehVisivel) {
        this.ehVisivel = ehVisivel;
    }

    public abstract void carregar();
    public abstract void atualizar ();
    public int getPosicaoEmX() {
        return this.posicaoEmX;
    }

    public Rectangle getRectangle() {
        return new Rectangle(posicaoEmX, posicaoEmY, larguraImagem, alturaImagem);
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