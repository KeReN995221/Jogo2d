package br.ifpr.jogo.principal;

import javax.swing.JFrame;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import br.ifpr.jogo.conexao.HibernateUtil;
import br.ifpr.jogo.modelo.FaseUm;

public class Principal extends JFrame {
    public Principal() {
        FaseUm fase = new FaseUm();
        super.add(fase);
        
        super.setVisible(true);
        this.setSize(1000, 618);
        this.setTitle("Meu Jogo");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
       
        Session sessao = HibernateUtil.getSession();
        Principal principal = new Principal();

    }
}
