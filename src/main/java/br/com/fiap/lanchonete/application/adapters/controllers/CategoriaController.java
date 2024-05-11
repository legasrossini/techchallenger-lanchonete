package br.com.fiap.lanchonete.application.adapters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lanchonete.domain.dtos.CategoriaDto;
import br.com.fiap.lanchonete.domain.ports.interfaces.CategoriaServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/lanchonete/v1/categorias")
@Tag(name = "Categorias", description = "Categorias de produtos")
public class CategoriaController {

    @Autowired
    private CategoriaServicePort categoriaService;

    @GetMapping
    @Operation(description = "Lista todas as categorias disponíveis")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = CategoriaDto.class)))
    public ResponseEntity<List<CategoriaDto>> getAllCategorias() {
        var categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

}
