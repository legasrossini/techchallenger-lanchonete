package br.com.fiap.lanchonete.application.adapters.controllers;

import br.com.fiap.lanchonete.domain.adapters.services.PedidoServiceImpl;
import br.com.fiap.lanchonete.domain.dtos.PedidoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lanchonete/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoServiceImpl;
    @PostMapping
    public ResponseEntity<PedidoDto> createPedidos(@RequestBody PedidoDto pedidoDto) {
        PedidoDto savedPedido = pedidoServiceImpl.save(pedidoDto);
        return ResponseEntity.ok(savedPedido);
    }
    @GetMapping
    public ResponseEntity<List<PedidoDto>> getAllPedidos() {
        List<PedidoDto> pedidos = pedidoServiceImpl.findAll();
        return ResponseEntity.ok(pedidos);
    }

}
