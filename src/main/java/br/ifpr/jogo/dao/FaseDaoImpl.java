package br.ifpr.jogo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.ifpr.jogo.conexao.HibernateUtil;
import br.ifpr.jogo.modelo.FaseUm;

public class FaseDaoImpl implements FaseDao {

    private Session session;

    public FaseDaoImpl() {

        this.session = HibernateUtil.getSession();
    }

    @Override
    public List<FaseUm> buscarTodos() {

        Query<FaseUm> query = this.session.createQuery("FROM FaseUm", FaseUm.class);
        List<FaseUm> faseUms = query.getResultList();
        return faseUms;
    }

    @Override
    public FaseUm buscarPorId(Integer id) {

        return this.session.find(FaseUm.class, id);
    }

    @Override
    public void inserir(FaseUm faseUm) {

        try {
            session.beginTransaction();
            session.persist(faseUm);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(FaseUm faseUm) {

        try {
            session.beginTransaction();
            session.merge(faseUm);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void excluir(FaseUm faseUm) {

        try {
            session.beginTransaction();
            session.remove(faseUm);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}