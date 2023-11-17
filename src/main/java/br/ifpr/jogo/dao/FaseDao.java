package br.ifpr.jogo.dao;

import java.util.List;

import br.ifpr.jogo.modelo.Fase;

public interface FaseDao {

    public List<Fase> buscarTodos();

    public Fase buscarPorId(Integer id);

    public void inserir(Fase fase);

    public void atualizar(Fase fase);

    public void excluir(Fase fase);
}