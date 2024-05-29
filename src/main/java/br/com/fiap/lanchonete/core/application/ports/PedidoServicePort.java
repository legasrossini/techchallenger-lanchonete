package br.com.fiap.lanchonete.core.application.ports;

import br.com.fiap.lanchonete.core.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.core.domain.dtos.PedidoResponseDto;

import java.util.List;

public interface PedidoServicePort {
    PedidoResponseDto save(PedidoDto produtoDto);
    List<PedidoDto> findAll();
    List<PedidoResponseDto> findAllComProdutos();

}
