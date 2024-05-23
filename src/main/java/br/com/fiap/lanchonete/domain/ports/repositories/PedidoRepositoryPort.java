package br.com.fiap.lanchonete.domain.ports.repositories;

import br.com.fiap.lanchonete.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.domain.dtos.PedidoResponseDto;

import java.util.List;

public interface PedidoRepositoryPort {
    PedidoResponseDto save(PedidoDto pedidoDto); // Create and Update
    List<PedidoDto> findAll(); // Read All
    List<PedidoResponseDto> findAllComProdutos(); // le todos, trazendo os produtos
}
