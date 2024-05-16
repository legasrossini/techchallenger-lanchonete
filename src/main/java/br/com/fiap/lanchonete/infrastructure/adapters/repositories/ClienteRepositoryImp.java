package br.com.fiap.lanchonete.infrastructure.adapters.repositories;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.domain.dtos.ClienteDto;
import br.com.fiap.lanchonete.domain.ports.repositories.ClienteRepositoryPort;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.ClienteEntity;

@Repository
public class ClienteRepositoryImp implements ClienteRepositoryPort {

    @Autowired
    private ClienteJpaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteDto findByCpfCliente(String cpfCliente) {
        return repository.findById(cpfCliente)
                .map(entity -> modelMapper.map(entity, ClienteDto.class))
                .orElse(null);
    }

    @Override
    public ClienteDto save(ClienteDto clienteDto) {
        ClienteEntity entity = modelMapper.map(clienteDto, ClienteEntity.class);
        ClienteEntity savedEntity = repository.save(entity);
        return modelMapper.map(savedEntity, ClienteDto.class);
    }

}
