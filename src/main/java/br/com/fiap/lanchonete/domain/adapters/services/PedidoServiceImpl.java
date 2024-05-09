package br.com.fiap.lanchonete.domain.adapters.services;

import br.com.fiap.lanchonete.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.domain.ports.interfaces.PedidoServicePort;
import br.com.fiap.lanchonete.domain.ports.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.PedidoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoServicePort {

    @Autowired
    private PedidoRepositoryPort pedidoRepositoryPort;

    @Override
    public List<PedidoDto> findAll() {
        return pedidoRepositoryPort.findAll();
    }

    @Override
    public PedidoDto save(PedidoDto pedidoDto) {
        return pedidoRepositoryPort.save(pedidoDto);
    }
}
