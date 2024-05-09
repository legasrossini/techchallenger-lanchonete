package br.com.fiap.lanchonete.application.adapters.controllers;

import br.com.fiap.lanchonete.domain.adapters.services.PedidoServiceImpl;
import br.com.fiap.lanchonete.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.PedidoEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/lanchonete/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoServiceImpl;

    @GetMapping
    public ResponseEntity<List<PedidoDto>> getAllPedidos() {
        List<PedidoDto> pedidos = pedidoServiceImpl.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<PedidoDto> createPedido(@Valid @RequestBody PedidoDto pedidoDto) {
        PedidoDto newPedidoDto = pedidoServiceImpl.save(pedidoDto);
        return ResponseEntity.ok(newPedidoDto);
    }
}
