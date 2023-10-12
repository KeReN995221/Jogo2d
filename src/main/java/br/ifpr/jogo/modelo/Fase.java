package br.ifpr.jogo.modelo;
// Fase = controller
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.swing.JPanel;
import javax.swing.Timer;

@Entity
@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)
public abstract class Fase extends JPanel implements ActionListener, KeyListener {
    
    
    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    @Column(name = "id_fase")
    private int id_fase;

    @Transient
    protected Image imagemFundo;

    @OneToOne(mappedBy = "personagem")
    protected Personagem personagem;


    @OneToMany(mappedBy = "inimigo")
    protected List<Inimigo> inimigos;
   
    @Transient // quando nao quero salvar o elemento
    protected Timer timer;

    @Column(name =  "em_jogo")
    protected boolean emJogo = true;

    @Column(name = "delay")
    public static final int delay = 5;

    @Column(name = "largura_janela")
    public static final int larg_janela = 2500;

    public static final int qtdInimigos = 40;

    protected static final int qtd_dinos = 10;
    protected ArrayList<Dino> dinos;

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

    public void desenhaVidas(Graphics2D graficos){
        String textoVidas = "VIDAS: " + personagem.getVidas();

        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoVidas, 20, 70);

    }

     public int getId_fase() {
        return id_fase;
    }

    public void setId_fase(int id_fase) {
        this.id_fase = id_fase;
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