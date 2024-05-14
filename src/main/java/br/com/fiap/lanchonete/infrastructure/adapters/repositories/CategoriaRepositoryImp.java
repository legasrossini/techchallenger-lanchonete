package br.com.fiap.lanchonete.infrastructure.adapters.repositories;

import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.lanchonete.domain.dtos.CategoriaDto;
import br.com.fiap.lanchonete.domain.ports.repositories.CategoriaRepositoryPort;

@Component
public class CategoriaRepositoryImp implements CategoriaRepositoryPort {

    @Autowired
    private CategoriaJpaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoriaDto> findAll() {
        return repository.findAll()
                    .stream()
                    .map(entity -> modelMapper.map(entity, CategoriaDto.class))
                    .sorted(Comparator.comparingInt(CategoriaDto::getId))
                    .toList();
    }

}
