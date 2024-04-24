package br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.infra.adapters.repositories;

import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.infra.adapters.entities.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringTarefaRepository extends JpaRepository<TarefaEntity, Long> {

}
