package br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.adapters.services;

import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.Tarefa;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.dtos.TarefaResponseDto;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.dtos.TarefaRequestDto;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.ports.interfaces.TarefaServicePort;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.ports.repositories.TarefaRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TarefaServiceImpl implements TarefaServicePort {

    private final TarefaRepositoryPort tarefaRepository;

    @Override
    public List<TarefaResponseDto> buscarTarefas() {
        List<Tarefa> tarefas = tarefaRepository.obterTodos();
        List<TarefaResponseDto> tarefaDtos = tarefas.stream()
                .map(Tarefa::toTarefaDto)
                .collect(Collectors.toList());

        return tarefaDtos;
    }

    @Override
    public TarefaResponseDto criarTarefa(TarefaRequestDto tarefaDto) {
        Tarefa tarefa = new Tarefa(tarefaDto);
        return tarefaRepository.salvar(tarefa).toTarefaDto();
    }

    @Override
    public TarefaResponseDto obterTarefaPorId(long id) {
        Tarefa tarefa = tarefaRepository.obterPorId(id);
        return tarefa.toTarefaDto();
    }

    @Override
    public void deletarTarefaPorId(long id) {
        tarefaRepository.deletarPorId(id);
    }

    @Override
    public TarefaResponseDto atualizarTarefaPorId(long id, TarefaRequestDto tarefaDto) {
        Tarefa tarefa = new Tarefa(tarefaDto);
        return tarefaRepository.atualizarPorId(id, tarefa).toTarefaDto();
    }
}
