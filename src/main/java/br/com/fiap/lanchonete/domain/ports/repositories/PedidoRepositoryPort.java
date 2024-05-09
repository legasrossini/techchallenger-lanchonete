package br.com.fiap.lanchonete.domain.ports.repositories;

import br.com.fiap.lanchonete.domain.dtos.PedidoDto;

import java.util.List;

public interface PedidoRepositoryPort {
    PedidoDto save(PedidoDto pedidoDto); // Create and Update
    List<PedidoDto> findAll(); // Read All
}
