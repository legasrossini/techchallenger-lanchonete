package br.com.fiap.lanchonete.core.domain.repositories;

import java.util.List;

import br.com.fiap.lanchonete.core.domain.dtos.CategoriaDto;

public interface CategoriaRepositoryPort {

    List<CategoriaDto> findAll();

}