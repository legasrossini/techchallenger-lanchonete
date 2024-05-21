package br.com.fiap.lanchonete.domain.ports.interfaces;

import java.util.List;

import br.com.fiap.lanchonete.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.domain.dtos.PedidoResponseDto;

public interface PedidoServicePort {
    PedidoResponseDto save(PedidoDto produtoDto);
    List<PedidoDto> findAll();
    List<PedidoResponseDto> findAllComProdutos();

}
