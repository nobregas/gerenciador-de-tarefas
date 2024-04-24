package br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.ports.interfaces;

import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.dtos.TarefaResponseDto;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.dtos.TarefaRequestDto;

import java.util.List;

public interface TarefaServicePort {
    List<TarefaResponseDto> buscarTarefas();

    TarefaResponseDto criarTarefa(TarefaRequestDto tarefaDto);
    TarefaResponseDto obterTarefaPorId(long id);

    void deletarTarefaPorId(long id);
}
