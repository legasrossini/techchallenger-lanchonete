package br.com.fiap.lanchonete.domain.ports.interfaces;

import br.com.fiap.lanchonete.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.PedidoEntity;

import java.util.List;

public interface PedidoServicePort {
    List<PedidoDto> findAll ();
    PedidoDto save (PedidoDto pedidoDto);
}
