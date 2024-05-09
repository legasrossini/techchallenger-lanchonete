package br.com.fiap.lanchonete.infrastructure.adapters.repositories;

import br.com.fiap.lanchonete.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.domain.ports.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.PedidoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PedidoRepositoryImp implements PedidoRepositoryPort {

    @Autowired
    private PedidoJpaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PedidoDto> findAll() {
        List<PedidoEntity> listaPedido = repository.findAll();

        List<PedidoDto> pedidoDtos = modelMapper(listaPedido, List<PedidoDto>);

        return pedidoDtos;
    }

    @Override
    public PedidoDto save(PedidoDto pedidoDto) {
        PedidoEntity entity = modelMapper.map(pedidoDto, PedidoEntity.class);
        PedidoEntity savedEntity = repository.save(entity);
        return modelMapper.map(savedEntity, PedidoDto.class);
    }
}
