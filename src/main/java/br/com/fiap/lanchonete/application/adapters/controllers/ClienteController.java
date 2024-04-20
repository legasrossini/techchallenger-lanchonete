package br.com.fiap.lanchonete.application.adapters.controllers;

import br.com.fiap.lanchonete.domain.dtos.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lanchonete/v1/clientes")
public class ClienteController {

    Cliente teste = new Cliente("222", "teste", "teste");

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> getClienteByCpf(@PathVariable String cpf) {
        //Cliente cliente = clienteService.findByCpf(cpf);

        return ResponseEntity.ok(teste);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        //Cliente savedCliente = clienteService.save(cliente);

        return ResponseEntity.ok(teste);
    }
}