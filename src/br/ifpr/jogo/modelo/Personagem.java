package br.ifpr.jogo.modelo;
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util. ArrayList;
public class Personagem {

    private int posicaoX;
    private int posicaoY;
    private int deslocamentoX;
    private int deslocamentoY;

    private Image imagem;
    private int larguraImagem;
    private int alturaImagem;

    private ArrayList<Tiro> tiros;

    private static final int deslocamento = 3;
    private static final int posicaoIx= 100;
    private static final int posicaoIy = 100;

    public Personagem() {
        this.posicaoX = posicaoIx;
        this.posicaoY = posicaoIy;
        this.tiros = new ArrayList<Tiro>();
    }

   public void mover(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_UP:
                this.deslocamentoY = -deslocamento;
                break;
            case KeyEvent.VK_W:
                this.deslocamentoY = -deslocamento;
                break;
            case KeyEvent.VK_DOWN:
                this.deslocamentoY = deslocamento;
                break;
            case KeyEvent.VK_S:
                this.deslocamentoY = deslocamento;
                break;
            case KeyEvent.VK_LEFT:
                this.deslocamentoX = -deslocamento;
                break;
            case KeyEvent.VK_D:
                this.deslocamentoX = -deslocamento;
                break;
            case KeyEvent.VK_RIGHT:
                this.deslocamentoX = deslocamento;
                break;
            case KeyEvent.VK_A:
                this.deslocamentoX = deslocamento;
                break;

            
        }
    }

    public void atirar() {
        int frenteDaNave = this.posicaoX + this.larguraImagem;
        int meioDaNave = this.posicaoY + (this.larguraImagem / 2);
        Tiro tiro = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiro);
    }

    public void parar (KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_UP:
                deslocamentoY = 0;
                break;
            case KeyEvent.VK_A:
                deslocamentoX = 0;
                break;
            case KeyEvent.VK_W:
                deslocamentoY = 0;
                break;
            case KeyEvent.VK_S:
                deslocamentoY = 0;
                break;
            case KeyEvent.VK_D:
                deslocamentoX = 0;
                break;
            case KeyEvent.VK_DOWN:
                deslocamentoY = 0;
                break;
            case KeyEvent.VK_LEFT:
                deslocamentoX = 0;
                break;
            case KeyEvent.VK_RIGHT:
                deslocamentoX = 0;
                break;
            default:
                break;
        }
    }

    

    public void atualizar() {
        this.posicaoX = this.posicaoX + this.deslocamentoX;
        this.posicaoY = this.posicaoY + this.deslocamentoY;
    }

    public void carregar() {

        ImageIcon carregando = new ImageIcon("recursos\\personagem.png");
        this.imagem = carregando.getImage();
        this.larguraImagem = this.imagem.getWidth(null);
        this.alturaImagem = this.imagem.getHeight(null);
    }
    
    public static int getDeslocamento() {
        return deslocamento;
    }

    
    
    

    public int getPosicaoX() {
        return this.posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return this.posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public int getDeslocamentoX() {
        return this.deslocamentoX;
    }

    public void setDeslocamentoX(int deslocamentoX) {
        this.deslocamentoX = deslocamentoX;
    }

    public int getDeslocamentoY() {
        return this.deslocamentoY;
    }

    public void setDeslocamentoY(int deslocamentoY) {
        this.deslocamentoY = deslocamentoY;
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
}