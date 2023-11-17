package br.ifpr.jogo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.ifpr.jogo.conexao.HibernateUtil;
import br.ifpr.jogo.modelo.Fase;

public class FaseDaoImpl implements FaseDao {

    private Session session;

    public FaseDaoImpl() {

        this.session = HibernateUtil.getSession();
    }

    @Override
    public List<Fase> buscarTodos() {

        Query<Fase> query = this.session.createQuery("FROM FaseUm", Fase.class);
        List<Fase> faseUms = query.getResultList();
        return faseUms;
    }

    @Override
    public Fase buscarPorId(Integer id) {

        return this.session.find(Fase.class, id);
    }

    @Override
    public void inserir(Fase fase) {

        try {
            session.beginTransaction();
            session.persist(fase);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Fase fase) {

        try {
            session.beginTransaction();
            session.merge(fase);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void excluir(Fase fase) {

        try {
            session.beginTransaction();
            session.remove(fase);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}