package br.ifpr.jogo.principal;
import javax.swing.JFrame;

public class Principal extends JFrame{
    public Principal(){
        super.setVisible(true);
        this.setSize(500, 500);
        this.setTitle("Meu Jogo");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        
        Principal principal = new Principal();

    }
}
