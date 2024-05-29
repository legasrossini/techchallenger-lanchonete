package br.com.fiap.lanchonete.core.application.services;

import br.com.fiap.lanchonete.core.application.ports.CategoriaServicePort;
import br.com.fiap.lanchonete.core.domain.dtos.CategoriaDto;
import br.com.fiap.lanchonete.core.domain.repositories.CategoriaRepositoryPort;

import java.util.List;

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