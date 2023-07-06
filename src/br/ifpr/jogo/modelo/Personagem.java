package br.ifpr.jogo.modelo;
import br.ifpr.jogo.modelo.ElementoGrafico;
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util. ArrayList;
public class Personagem extends ElementoGrafico {
    
    private int deslocamentoX;
    private int deslocamentoY;
    private ArrayList<Tiro> tiros;
    private static final int deslocamento = 3;
    private static final int posicaoIx= 100;
    private static final int posicaoIy = 100;
    public Personagem() {
        super.setPosicaoEmX(posicaoIx);
        super.setPosicaoEmY(posicaoIy);
        super.tiros = new ArrayList<Tiro>();
        this.tiros = new ArrayList<Tiro>();
    }

   public void mover(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_UP:
                super.deslocamentoY = -deslocamento;
                this.deslocamentoY = -deslocamento;
                break;
            case KeyEvent.VK_W:
                super.deslocamentoY = -deslocamento;
                this.deslocamentoY = -deslocamento;
                break;
            case KeyEvent.VK_DOWN:
                super.deslocamentoY = deslocamento;
                this.deslocamentoY = deslocamento;
                break;
            case KeyEvent.VK_S:
                super.deslocamentoY = deslocamento;
                this.deslocamentoY = deslocamento;
                break;
            case KeyEvent.VK_LEFT:
                super.deslocamentoX = -deslocamento;
                this.deslocamentoX = -deslocamento;
                break;
            case KeyEvent.VK_D:
                super.deslocamentoX = -deslocamento;
                this.deslocamentoX = -deslocamento;
                break;
            case KeyEvent.VK_RIGHT:
                super.deslocamentoX = deslocamento;
                this.deslocamentoX = deslocamento;
                break;
            case KeyEvent.VK_A:
                super.deslocamentoX = deslocamento;
                this.deslocamentoX = deslocamento;
                break;


        }
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

    
    @Override
    public void atualizar() {
        super.setPosicaoEmX (super.getPosicaoEmX() + this.deslocamentoX);
        super.setPosicaoEmY (super.getPosicaoEmY() + this.deslocamentoY);
    }

    public void atirar() {
        int frenteDaNave = super.getPosicaoEmX() + super.getLarguraImagem();
        int meioDaNave = super.getPosicaoEmY() + (super.getLarguraImagem() / 2);
        Tiro tiro = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiro);
    }

    


    public void carregar() {

        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\jogo2d\\Jogo2d\\Recursos\\personagem.png");
        super.setImagem (carregando.getImage());
        super.setLarguraImagem(super.getImagem().getWidth(null));
        super.setAlturaImagem (super.getImagem().getHeight(null));
    }

    public static int getDeslocamento() {
        return deslocamento;
    }
    
    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }
    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
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
}