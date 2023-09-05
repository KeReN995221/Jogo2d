package br.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;


public abstract class Fase extends JPanel implements ActionListener, KeyListener {
    protected Image imagemFundo;
    protected Personagem personagem;
    protected ArrayList<Inimigo> inimigos;
    protected Timer timer;
    protected boolean emJogo = true;

    public static final int delay = 5;
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