package br.com.fiap.lanchonete.domain.adapters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.domain.dtos.CategoriaDto;
import br.com.fiap.lanchonete.domain.ports.interfaces.CategoriaServicePort;
import br.com.fiap.lanchonete.domain.ports.repositories.CategoriaRepositoryPort;

@Service
public class CategoriaServiceImpl implements CategoriaServicePort{

    @Autowired
    private CategoriaRepositoryPort categoriaRepository;

    @Override
    public List<CategoriaDto> findAll() {
        return categoriaRepository.findAll();
    }

}
