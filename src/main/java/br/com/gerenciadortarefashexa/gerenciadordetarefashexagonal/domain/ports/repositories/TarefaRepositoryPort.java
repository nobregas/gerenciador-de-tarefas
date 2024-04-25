package br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.ports.repositories;

import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.Tarefa;

import java.util.List;

public interface TarefaRepositoryPort {
    List<Tarefa> obterTodos();

    Tarefa obterPorId(long id);

    Tarefa salvar(Tarefa tarefa);

    void deletarPorId(long id);

    Tarefa atualizarPorId(long id, Tarefa tarefa);
}
