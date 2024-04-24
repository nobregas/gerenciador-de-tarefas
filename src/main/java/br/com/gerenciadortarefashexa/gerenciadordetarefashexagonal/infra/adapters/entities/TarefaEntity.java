package br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.infra.adapters.entities;

import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.Tarefa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarefas")
@Data
@NoArgsConstructor
public class TarefaEntity {
    @Id @GeneratedValue
    private long id;
    private String titulo;
    private String descricao;

    public Tarefa toTarefa() {
        return new Tarefa(this.id, this.titulo, this.descricao);
    }

    public void atualizar(Tarefa tarefa) {
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
    }
}
