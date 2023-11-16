package br.ifpr.jogo.dao;

import java.util.List;

import br.ifpr.jogo.modelo.FaseUm;

public interface FaseDao {

    public List<FaseUm> buscarTodos();

    public FaseUm buscarPorId(Integer id);

    public void inserir(FaseUm faseUm);

    public void atualizar(FaseUm faseUm);

    public void excluir(FaseUm faseUm);
}