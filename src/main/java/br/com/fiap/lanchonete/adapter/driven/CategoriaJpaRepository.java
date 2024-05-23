package br.com.fiap.lanchonete.adapter.driven;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.lanchonete.adapter.driven.entity.CategoriaEntity;

public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Integer>{
}
