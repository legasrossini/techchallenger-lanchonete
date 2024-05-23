package br.com.fiap.lanchonete.core.application.ports;

import java.util.List;

import br.com.fiap.lanchonete.core.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.core.domain.dtos.PedidoResponseDto;

public interface PedidoServicePort {
    PedidoResponseDto save(PedidoDto produtoDto);
    List<PedidoDto> findAll();
    List<PedidoResponseDto> findAllComProdutos();

}
