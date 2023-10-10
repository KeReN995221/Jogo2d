package br.ifpr.jogo.modelo;

import java.awt.event.KeyEvent;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;
import java.util.ArrayList;

@Entity
@Table(name = "tb_personagem")
public class Personagem extends ElementoGrafico {

   

    @Column(name = "deslocamento_em_x")
    private int deslocamentoX;

    @Column(name = "deslocamento_em_y")
    private int deslocamentoY;

    @Column(name = "pontuacao")
    private int pontuacao;

    private int vidas = 5; 
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fk_tiro")
    private ArrayList<Tiro> tiros;
    private ArrayList<SuperTiro> stiros;
    private static final int deslocamento = 3;
    private static final int posicaoIx = 100;
    private static final int posicaoIy = 100;
    
    public Personagem() {
        this.setPosicaoEmX(posicaoIx);
        this.setPosicaoEmY(posicaoIy);
        this.tiros = new ArrayList<Tiro>();
        this.stiros = new ArrayList<SuperTiro>();
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
            this.deslocamentoX = deslocamento;
            break;
            case KeyEvent.VK_RIGHT:
            this.deslocamentoX = deslocamento;
            break;
            case KeyEvent.VK_A:
            this.deslocamentoX = -deslocamento;
            break;

            default:
            break;

    

        }
    }
    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void parar(KeyEvent tecla) {
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
        super.setPosicaoEmX(super.getPosicaoEmX() + this.deslocamentoX);
        super.setPosicaoEmY(super.getPosicaoEmY() + this.deslocamentoY);
    }

    public void atirar() {
        int frenteDaNave = super.getPosicaoEmX() + super.getLarguraImagem();
        int meioDaNave = super.getPosicaoEmY() + (super.getLarguraImagem() / 2);
        Tiro tiro = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiro);
    }

    public void sAtirar() {
        int frenteDaNave = super.getPosicaoEmX() + super.getLarguraImagem();
        int meioDaNave = super.getPosicaoEmY() + (super.getLarguraImagem() / 2);
        SuperTiro stiro = new SuperTiro(frenteDaNave, meioDaNave);
        this.stiros.add(stiro);
    }

    public void carregar() {

        ImageIcon carregando = new ImageIcon (getClass().getResource("/personagem.png"));
        this.setImagem(carregando.getImage());
        this.setLarguraImagem(getImagem().getWidth(null));
        this.setAlturaImagem(getImagem().getHeight(null));
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

    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }

    public ArrayList<SuperTiro> getStiros() {
        return this.stiros;
    }

    public void setStiros(ArrayList<SuperTiro> stiros) {
        this.stiros = stiros;
    }

    /**
     * @return int return the vidas
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * @param vidas the vidas to set
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }



}
    