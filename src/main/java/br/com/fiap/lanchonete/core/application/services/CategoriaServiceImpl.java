package br.com.fiap.lanchonete.core.application.services;

import java.util.List;

import br.com.fiap.lanchonete.core.domain.dtos.CategoriaDto;
import br.com.fiap.lanchonete.core.application.ports.CategoriaServicePort;
import br.com.fiap.lanchonete.core.domain.repositories.CategoriaRepositoryPort;

public class CategoriaServiceImpl implements CategoriaServicePort{

    private CategoriaRepositoryPort categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepositoryPort categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<CategoriaDto> findAll() {
        return categoriaRepository.findAll();
    }

}