package br.ifpr.jogo.modelo;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

@Entity
@Table(name = "tb_personagem")
public class Personagem extends ElementoGrafico {

    @Column(name = "deslocamento_em_x")
    int deslocamentoX;

    @Column(name = "deslocamento_em_y")
    private int deslocamentoY;

    @Column(name = "pontuacao")
    private int pontuacao;

    @Column(nullable = false, name = " vidas")
    private int vidas = 5;

    @OneToOne(cascade = CascadeType.ALL)
    @Transient
    private Fase fase;

    @OneToMany(mappedBy = "personagem")
    private List<Tiro> tiros;

    @OneToMany(mappedBy = "personagem")
    private List<SuperTiro> stiros;

    @Transient
    private static final int larg_personagem = 126;

    @Transient
    private static final int alt_personagem = 227;

    @Transient
    private static final int deslocamento = 3;

    @Transient
    private static final int posicaoIx = 100;

    @Transient
    private static final int posicaoIy = 100;

    @Transient
    private int posicaoAnteriorX;

    @Transient
    private int posicaoAnteriorY;

    public Personagem() {
        this.setPosicaoEmX(posicaoIx);
        this.setPosicaoEmY(posicaoIy);
        this.tiros = new ArrayList<Tiro>();
        this.stiros = new ArrayList<SuperTiro>();
    }

    @Override
    public void carregar() {

        ImageIcon carregando = new ImageIcon(getClass().getResource("/personagem.png"));
        this.setImagem(carregando.getImage());
        this.setLarguraImagem(getImagem().getWidth(null));
        this.setAlturaImagem(getImagem().getHeight(null));
    }

    public void mover(KeyEvent tecla) {
        this.posicaoAnteriorX = this.deslocamentoX;
        this.posicaoAnteriorY = this.deslocamentoY;

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

    @Override
    public void atualizar() {
        int posicaoXAtual = this.getPosicaoEmX() + this.getDeslocamentoX();
        int posicaoYAtual = this.getPosicaoEmY() + this.getDeslocamentoY();

        if (posicaoXAtual < 0) {
            posicaoXAtual = 0;

        } else if (posicaoYAtual + getAlturaImagem() + 227 > 730) { // 4730 é a altura da imagem - a parte que
                                                                    // representa
                                                                    // o solo
            posicaoYAtual = 730 - 227 - getAlturaImagem();

        }

        if (posicaoYAtual < 0) {
            posicaoYAtual = 0;

            System.out.println(posicaoYAtual + " \n ");
        } else if (posicaoXAtual + getLarguraImagem() + 126 > 1120) {
            posicaoXAtual = 1120 - 126 - getLarguraImagem();
        }

        super.setPosicaoEmX(posicaoXAtual);
        super.setPosicaoEmY(posicaoYAtual);

    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
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

    public List<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(List<Tiro> tiros) {
        this.tiros = tiros;
    }

    public List<SuperTiro> getStiros() {
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

    public boolean intersects(int largura_janela, int altura_janela) {
        return false;
    }

}
