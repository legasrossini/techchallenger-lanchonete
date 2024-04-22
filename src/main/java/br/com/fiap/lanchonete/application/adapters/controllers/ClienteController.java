package br.com.fiap.lanchonete.application.adapters.controllers;

import br.com.fiap.lanchonete.domain.adapters.services.ClienteServiceImpl;
import br.com.fiap.lanchonete.domain.dtos.ClienteDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lanchonete/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @GetMapping("/{cpfCliente}")
    public ResponseEntity<ClienteDto> getClienteByCpf(@PathVariable String cpfCliente) {
        ClienteDto clienteDTO = clienteServiceImpl.findByCpfCliente(cpfCliente);
        if (clienteDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> createCliente(@Valid @RequestBody ClienteDto clienteDTO) {
        ClienteDto savedClienteDTO = clienteServiceImpl.save(clienteDTO);
        return ResponseEntity.ok(savedClienteDTO);
    }

}