package br.ifpr.jogo.servico;

import br.ifpr.jogo.modelo.FaseUm;
import br.ifpr.jogo.dao.FaseDao;
import br.ifpr.jogo.dao.FaseDaoImpl;

import java.util.List;

public class FaseServico {
    private static FaseDao dao = new FaseDaoImpl();

    public static List<FaseUm> buscarTodos() {
        return dao.buscarTodos();
    }

    public static FaseUm buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public void inserir(FaseUm faseUm) {
        dao.inserir(faseUm);
    }

    public static void atualizar(FaseUm faseUm) {
        dao.atualizar(faseUm);
    }

    public static void excluir(FaseUm faseUm) {
        dao.excluir(faseUm);
    }

}