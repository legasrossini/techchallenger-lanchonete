package br.com.fiap.lanchonete.infrastructure.adapters.repositories;

import br.com.fiap.lanchonete.infrastructure.adapters.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, String> {
}
