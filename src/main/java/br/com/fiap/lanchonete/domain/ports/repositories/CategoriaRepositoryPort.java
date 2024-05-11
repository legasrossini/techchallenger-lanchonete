package br.com.fiap.lanchonete.domain.ports.repositories;

import java.util.List;

import br.com.fiap.lanchonete.domain.dtos.CategoriaDto;

public interface CategoriaRepositoryPort {

    List<CategoriaDto> findAll();

}