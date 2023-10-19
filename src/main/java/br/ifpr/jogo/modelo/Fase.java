package br.ifpr.jogo.modelo;

import java.awt.Graphics2D;
// Fase = controller
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.JPanel;
import javax.swing.Timer;

@Entity
@Table(name = "tb_fase")
public abstract class Fase extends JPanel implements ActionListener, KeyListener {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fase")
    private int idFase;

    @Transient
    protected Image imagemFundo;

    @Transient
    protected Personagem personagem;

    @Transient //@OneToMany(mappedBy = "inimigo")
    protected List<Inimigo> inimigos;
    /*
     * public List<Inimigo> getInimigos() {
     * return inimigos;
     * }
     * 
     * public void setInimigos(List<Inimigo> inimigos) {
     * this.inimigos = inimigos;
     * }
     */

    @Transient // quando nao quero salvar o elemento
    protected Timer timer;

    @Column(name = "em_jogo")
    protected boolean emJogo = true;

    @Column(name = "delay")
    public static final int delay = 5;

    @Column(name = "largura_janela")
    public static final int larg_janela = 2500;

    @Transient
    public static final int qtdInimigos = 40;

    @Transient protected static final int qtd_dinos = 10;
    @Transient
    protected List<Dino> dinos;

    public Fase() {
        setFocusable(true); // + define o foco inicial do jogo
        setDoubleBuffered(true); // + Otimização computacional
        addKeyListener(this);
    }

    public abstract void inicializaElementosGraficosAdicionais();

    public abstract void inicializaInimigos();

    public abstract void verficarColisoes();

    public void desenhaPontuacao(Graphics2D graficos) {
        String textoPontuacao = "PONTOS: " + personagem.getPontuacao();
        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoPontuacao, 20, 25);
    }

    public void desenhaVidas(Graphics2D graficos) {
        String textoVidas = "VIDAS: " + personagem.getVidas();

        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoVidas, 20, 70);

    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public abstract void keyPressed(KeyEvent e);

    @Override
    public abstract void keyReleased(KeyEvent e);

    @Override
    public abstract void actionPerformed(ActionEvent e);
}