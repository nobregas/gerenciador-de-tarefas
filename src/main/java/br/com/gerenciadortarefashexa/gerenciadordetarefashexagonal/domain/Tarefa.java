package br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain;

import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.dtos.TarefaResponseDto;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.dtos.TarefaRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
    private long id;
    private String titulo;
    private String descricao;

    public Tarefa(TarefaRequestDto tarefaDto) {
        this.titulo = tarefaDto.titulo();
        this.descricao = tarefaDto.descricao();
    }

    public TarefaResponseDto toTarefaDto() {
        return new TarefaResponseDto(this.id, this.titulo, this.descricao);
    }
}
