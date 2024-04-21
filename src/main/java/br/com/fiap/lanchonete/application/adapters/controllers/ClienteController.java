package br.com.fiap.lanchonete.application.adapters.controllers;

import br.com.fiap.lanchonete.domain.adapters.services.ClienteServiceImp;
import br.com.fiap.lanchonete.domain.dtos.ClienteDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lanchonete/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImp clienteService;

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDto> getClienteByCpf(@PathVariable String cpf) {
        ClienteDto clienteDTO = clienteService.findByCpf(cpf);
        if (clienteDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> createCliente(@Valid @RequestBody ClienteDto clienteDTO) {
        ClienteDto savedClienteDTO = clienteService.save(clienteDTO);
        return ResponseEntity.ok(savedClienteDTO);
    }

}