package br.com.fiap.lanchonete.infrastructure.adapters.repositories;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.domain.ports.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.ClienteEntity;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.PedidoEntity;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.PedidoProdutoEntity;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.ProdutoEntity;
import br.com.fiap.lanchonete.infrastructure.enums.StatusPedido;

@Repository
public class PedidoRepositoryImp implements PedidoRepositoryPort {

    @Autowired
    private PedidoJpaRepository pedidoJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PedidoDto save(PedidoDto pedidoDto) {
        //PedidoEntity pedidoEntity = modelMapper.map(pedidoDto, PedidoEntity.class);
        
        ClienteEntity clienteEntity = ClienteEntity.builder()
                                            .cpf(pedidoDto.getCpfCliente())
                                            .build();

        PedidoEntity pedidoEntity = PedidoEntity.builder()
                                            .id(UUID.randomUUID())
                                            .cliente(clienteEntity)
                                            .dataHora(LocalDateTime.now())
                                            .status(StatusPedido.RECEBIDO)
                                            .valor(pedidoDto.getValor())
                                            .build();

        PedidoEntity savedEntity = pedidoJpaRepository.save(pedidoEntity);

        List<PedidoProdutoEntity> listaPedidoProduto = new ArrayList<>();

        Optional.ofNullable(pedidoDto.getProdutos()).orElse(Collections.emptyList()).forEach(p ->{
            if (p.possuiLanche()){
                listaPedidoProduto.add(
                                        PedidoProdutoEntity.builder()
                                                    .comboNum(p.getComboNum())
                                                    .pedido(pedidoEntity)
                                                    .preco(p.getLanche().getPreco())
                                                    .produto(ProdutoEntity.builder().id(p.getLanche().getId()).build())
                                                    .build()
                                    );
                
            }

            if (p.possuiAcompanhamento()){
                listaPedidoProduto.add(
                                        PedidoProdutoEntity.builder()
                                                    .comboNum(p.getComboNum())
                                                    .pedido(pedidoEntity)
                                                    .preco(p.getAcompanhamento().getPreco())
                                                    .produto(ProdutoEntity.builder().id(p.getAcompanhamento().getId()).build())
                                                    .build()
                                    );
            }

            if (p.possuiBebida()){
                listaPedidoProduto.add(
                                        PedidoProdutoEntity.builder()
                                                    .comboNum(p.getComboNum())
                                                    .pedido(pedidoEntity)
                                                    .preco(p.getBebida().getPreco())
                                                    .produto(ProdutoEntity.builder().id(p.getBebida().getId()).build())
                                                    .build()
                                    );
            }

            if (p.possuiSobremesa()){
                listaPedidoProduto.add(
                                        PedidoProdutoEntity.builder()
                                                    .comboNum(p.getComboNum())
                                                    .pedido(pedidoEntity)
                                                    .preco(p.getSobremesa().getPreco())
                                                    .produto(ProdutoEntity.builder().id(p.getSobremesa().getId()).build())
                                                    .build()
                                    );
            }
        });


        savedEntity.setProdutos(listaPedidoProduto);

        savedEntity = pedidoJpaRepository.save(savedEntity);
        
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