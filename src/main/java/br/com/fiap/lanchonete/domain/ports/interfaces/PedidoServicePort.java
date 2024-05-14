package br.com.fiap.lanchonete.domain.ports.interfaces;

import br.com.fiap.lanchonete.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.domain.dtos.ProdutoDto;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.PedidoEntity;

import java.util.List;
import java.util.Optional;

public interface PedidoServicePort {
    PedidoDto save(PedidoDto produtoDto);
    List<PedidoDto> findAll();

}
