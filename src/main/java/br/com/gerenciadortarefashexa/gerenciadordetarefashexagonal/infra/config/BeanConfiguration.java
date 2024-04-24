package br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.infra.config;

import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.adapters.services.TarefaServiceImpl;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.ports.interfaces.TarefaServicePort;
import br.com.gerenciadortarefashexa.gerenciadordetarefashexagonal.domain.ports.repositories.TarefaRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    TarefaServicePort tarefaService(TarefaRepositoryPort tarefaRepositoryPort) {
        return new TarefaServiceImpl(tarefaRepositoryPort);
    }

}
