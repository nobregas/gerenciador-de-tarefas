package br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.application.adapters.controllers;

import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.dtos.TarefaResponseDto;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.dtos.TarefaRequestDto;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.ports.interfaces.TarefaServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarefas")
@RequiredArgsConstructor
public class TarefaController {
    private final TarefaServicePort tarefaServicePort;

    @PostMapping
    public ResponseEntity<TarefaResponseDto> criarTarefa(@RequestBody TarefaRequestDto tarefaDto) {
        TarefaResponseDto tarefa = tarefaServicePort.criarTarefa(tarefaDto);
        return new ResponseEntity<>(tarefa, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDto>> listarTarefas() {
        List<TarefaResponseDto> tarefaDtos = tarefaServicePort.buscarTarefas();
        return ResponseEntity.ok(tarefaDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDto> obterTarefaPorId(@PathVariable long id) {
        TarefaResponseDto tarefaDto = tarefaServicePort.obterTarefaPorId(id);
        return ResponseEntity.ok(tarefaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefaPorId(@PathVariable long id) {
        tarefaServicePort.deletarTarefaPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDto> atualizarTarefaPorId(
            @PathVariable long id, @RequestBody TarefaRequestDto tarefaDto
    ) {
        TarefaResponseDto tarefa = tarefaServicePort.atualizarTarefaPorId(id, tarefaDto);
        return ResponseEntity.ok(tarefa);
    }
}
