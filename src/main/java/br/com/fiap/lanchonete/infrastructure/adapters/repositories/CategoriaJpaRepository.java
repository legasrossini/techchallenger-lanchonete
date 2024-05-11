package br.com.fiap.lanchonete.infrastructure.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.lanchonete.infrastructure.adapters.entity.CategoriaEntity;

public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Integer>{
}
