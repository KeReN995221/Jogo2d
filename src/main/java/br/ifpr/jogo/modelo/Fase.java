package br.ifpr.jogo.modelo;

import java.awt.Graphics2D;
// Fase = controller
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.swing.JPanel;
import javax.swing.Timer;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Fase extends JPanel implements ActionListener, KeyListener {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fase")
    private int idFase;

    @Column(name = "em_jogo")
    protected boolean emJogo = true;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personagem_id")
    protected Personagem personagem;

    @Transient
    public static final int delay = 5;

    @Transient
    public static final int larg_janela = 2500;

    // quando nao quero salvar o elemento
    @Transient
    public static final int qtdInimigos = 40;

    @Transient
    protected static final int qtd_dinos = 10;

    @Transient
    protected Timer timer;

    @Transient
    protected Image imagemFundo;

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
        graficos.drawString(textoPontuacao, 20, 570);
    }

    public void desenhaVidas(Graphics2D graficos) {
        String textoVidas = "VIDAS: " + personagem.getVidas();

        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoVidas, 300, 570);

    }

    /*
     * @Override
     * public void keyTyped(KeyEvent e) {
     * }
     * 
     * 
     * 
     * @Override
     * public abstract void keyReleased(KeyEvent e);
     *
     * 
     * @Override
     * public abstract void actionPerformed(ActionEvent e);
     */

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

}