package br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.dtos;

public record TarefaResponseDto(
        long id,
        String titulo,
        String descricao
) {
}
