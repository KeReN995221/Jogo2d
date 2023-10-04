package br.ifpr.jogo.conexao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil { // CLASSE SINGLETON QUE FAZ A CONEÇÃO COM O BANCO DE DADOS 
    private static SessionFactory SESSION_FACTORY;
    static {
        try {
            // Criação da SessionFactory a partir do hibernate.cfg.xml
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Criação Inicial da SessionFactory falhou! " + ex); // O USO DO err SERVE PARA APRESENTAR NA TELA COM UMA COR DIFERENTE
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return SESSION_FACTORY.openSession();
    }

    public static void encerraSession() {
        SESSION_FACTORY.close();
    }
}
