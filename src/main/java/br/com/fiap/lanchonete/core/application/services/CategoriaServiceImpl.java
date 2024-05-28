package br.com.fiap.lanchonete.core.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.core.domain.dtos.CategoriaDto;
import br.com.fiap.lanchonete.core.application.ports.CategoriaServicePort;
import br.com.fiap.lanchonete.core.domain.repositories.CategoriaRepositoryPort;

@Service
public class CategoriaServiceImpl implements CategoriaServicePort{

    @Autowired
    private CategoriaRepositoryPort categoriaRepository;

    @Override
    public List<CategoriaDto> findAll() {
        return categoriaRepository.findAll();
    }

}
