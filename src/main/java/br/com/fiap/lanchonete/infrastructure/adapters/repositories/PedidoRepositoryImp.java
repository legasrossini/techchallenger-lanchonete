package br.com.fiap.lanchonete.infrastructure.adapters.repositories;

import br.com.fiap.lanchonete.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.domain.ports.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.PedidoEntity;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.PedidoProdutoEntity;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.ProdutoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepositoryImp implements PedidoRepositoryPort {

    @Autowired
    private PedidoJpaRepository pedidoJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PedidoDto save(PedidoDto pedidoDto) {
        PedidoEntity pedidoEntity = modelMapper.map(pedidoDto, PedidoEntity.class);
        pedidoDto.getProdutos().forEach(p->{
            //pedidoEntity.getProdutos().add(PedidoProdutoEntity.builder().id() )
            var lanche = p.getLanche();
            var sobremesa = p.getSobremesa();
            var bebida = p.getBebida();
            var acompanhamento = p.getAcompanhamento();
        });
        PedidoEntity savedEntity = pedidoJpaRepository.save(pedidoEntity);
        return modelMapper.map(savedEntity, PedidoDto.class);
    }

    @Override
    public List<PedidoDto> findAll() {
        return pedidoJpaRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, PedidoDto.class))
                .toList();
    }
}
