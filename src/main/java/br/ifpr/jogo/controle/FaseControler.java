package br.ifpr.jogo.controle;

import br.ifpr.jogo.modelo.ElementoGrafico;
import br.ifpr.jogo.modelo.Inimigo;
import br.ifpr.jogo.modelo.Dino;
import br.ifpr.jogo.modelo.Personagem;
import br.ifpr.jogo.modelo.Tiro;
import br.ifpr.jogo.modelo.SuperTiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public abstract class FaseControler extends JPanel implements ActionListener, KeyListener {

    public FaseControler() {
        setFocusable(true); // + define o foco inicial do jogo
        setDoubleBuffered(true); // + Otimização computacional
        addKeyListener(this);
    }

    public abstract void inicializaElementosGraficosAdicionais();

    public abstract void inicializaInimigos();

    public abstract void verficarColisoes();

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
