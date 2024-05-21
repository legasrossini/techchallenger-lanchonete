package br.com.fiap.lanchonete.application.adapters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lanchonete.domain.adapters.services.PedidoServiceImpl;
import br.com.fiap.lanchonete.domain.dtos.PedidoDto;
import br.com.fiap.lanchonete.domain.dtos.PedidoResponseDto;
import br.com.fiap.lanchonete.infrastructure.exceptions.RegraNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/lanchonete/v1/pedidos")
@Tag(name = "Pedidos", description = "Pedidos de clientes")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoServiceImpl;

    @PostMapping
    @Operation(description = "Gera o pedido do cliente")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = PedidoDto.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    public ResponseEntity<?> createPedidos(@RequestBody PedidoDto pedidoDto) {
        try{
            PedidoResponseDto savedPedido = pedidoServiceImpl.save(pedidoDto);
            return ResponseEntity.ok(savedPedido);
        }catch(RegraNegocioException rne){
            return ResponseEntity.badRequest().body(rne.getMessage());
        }
    }
    @GetMapping
    @Operation(description = "Lista todos os pedidos")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = PedidoResponseDto.class)))
    public ResponseEntity<List<PedidoResponseDto>> getAllPedidos() {
        List<PedidoResponseDto> pedidos = pedidoServiceImpl.findAllComProdutos();
        return ResponseEntity.ok(pedidos);
    }

}
