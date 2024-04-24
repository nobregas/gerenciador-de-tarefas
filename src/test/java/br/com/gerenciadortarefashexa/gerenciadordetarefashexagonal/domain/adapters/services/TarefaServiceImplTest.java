package br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.adapters.services;

import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.Tarefa;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.dtos.TarefaResponseDto;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.infra.adapters.repositories.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TarefaServiceImplTest {

    @Mock
    private TarefaRepository tarefaRepositoryPort;

    @InjectMocks
    private TarefaServiceImpl tarefaServicePort;

    @Test
    public void testBuscarTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        tarefas.add(new Tarefa(1L, "Tarefa 1", "Desc T-1"));
        tarefas.add(new Tarefa(2L, "Tarefa 2", "Desc T-2"));

        Mockito.when(tarefaRepositoryPort.obterTodos())
                .thenReturn(tarefas);

        List<TarefaResponseDto> tarefaDtos = tarefaServicePort.buscarTarefas();

        assertNotNull(tarefaDtos);
        assertEquals(2, tarefaDtos.size());

        for (int i = 0; i < tarefaDtos.size(); i++) {
            TarefaResponseDto tarefaDto = tarefaDtos.get(i);
            Tarefa tarefaEsperada = tarefas.get(i);

            assertEquals(tarefaEsperada.getId(), tarefaDto.id());
            assertEquals(tarefaEsperada.getTitulo(), tarefaDto.titulo());
            assertEquals(tarefaEsperada.getDescricao(), tarefaDto.descricao());
        }
    }

}