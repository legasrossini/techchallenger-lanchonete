package br.com.fiap.lanchonete.adapter.driven;

import br.com.fiap.lanchonete.adapter.driven.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, String> {
}
