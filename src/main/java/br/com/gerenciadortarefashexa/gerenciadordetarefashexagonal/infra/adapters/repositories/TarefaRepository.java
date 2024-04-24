package br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.infra.adapters.repositories;

import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.Tarefa;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.ports.repositories.TarefaRepositoryPort;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.infra.adapters.entities.TarefaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TarefaRepository implements TarefaRepositoryPort {

    private final SpringTarefaRepository springTarefaRepository;

    @Override
    public List<Tarefa> obterTodos() {
        List<TarefaEntity> tarefaEntities = springTarefaRepository.findAll();
        return tarefaEntities.stream()
                .map(TarefaEntity::toTarefa)
                .collect(Collectors.toList());
    }

    @Override
    public Tarefa obterPorId(long id) {
        TarefaEntity tarefaEntity = springTarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        return tarefaEntity.toTarefa();
    }

    @Override
    public Tarefa salvar(Tarefa tarefa) {
        TarefaEntity tarefaEntity = new TarefaEntity();
        tarefaEntity.atualizar(tarefa);

        return springTarefaRepository.save(tarefaEntity).toTarefa();
    }
}
