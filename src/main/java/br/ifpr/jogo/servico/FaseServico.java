package br.ifpr.jogo.servico;

import br.ifpr.jogo.modelo.Fase;
import br.ifpr.jogo.dao.FaseDao;
import br.ifpr.jogo.dao.FaseDaoImpl;

import java.util.List;

public class FaseServico {
    private static FaseDao dao = new FaseDaoImpl();

    public static List<Fase> buscarTodos() {
        return dao.buscarTodos();
    }

    public static Fase buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public void inserir(Fase fase) {
        dao.inserir(fase);
    }

    public static void atualizar(Fase fase) {
        dao.atualizar(fase);
    }

    public static void excluir(Fase fase) {
        dao.excluir(fase);
    }

}