package br.com.fiap.lanchonete.application.adapters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lanchonete.domain.adapters.services.ClienteServiceImpl;
import br.com.fiap.lanchonete.domain.dtos.ClienteDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/lanchonete/v1/clientes")
@Tag(name = "Clientes", description = "Clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @GetMapping(value = "/{cpfCliente}", produces = {"application/json"})
    @Operation(description = "Consulta o cliente por CPF")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = ClienteDto.class)))
    @ApiResponse(responseCode = "404", description = "Não encontrado")
    public ResponseEntity<ClienteDto> getClienteByCpf(@PathVariable String cpfCliente) {
        ClienteDto clienteDTO = clienteServiceImpl.findByCpfCliente(cpfCliente);
        if (clienteDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
    @Operation(description = "Cadastra um novo cliente")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = ClienteDto.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    public ResponseEntity<ClienteDto> createCliente(@Valid @RequestBody ClienteDto clienteDTO) {
        ClienteDto savedClienteDTO = clienteServiceImpl.save(clienteDTO);
        return ResponseEntity.ok(savedClienteDTO);
    }

}