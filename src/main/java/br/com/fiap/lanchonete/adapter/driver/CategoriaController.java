package br.com.fiap.lanchonete.adapter.driver;


import br.com.fiap.lanchonete.core.application.ports.CategoriaServicePort;
import br.com.fiap.lanchonete.core.application.services.CategoriaServiceImpl;
import br.com.fiap.lanchonete.core.domain.dtos.CategoriaDto;
import br.com.fiap.lanchonete.core.domain.repositories.CategoriaRepositoryPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lanchonete/v1/categorias")
@Tag(name = "Categorias", description = "Categorias de produtos")
public class CategoriaController {

    private final CategoriaServicePort categoriaService;

    public CategoriaController(CategoriaRepositoryPort categoriaRepository) {
        this.categoriaService = new CategoriaServiceImpl(categoriaRepository);
    }

    @GetMapping
    @Operation(description = "Lista todas as categorias disponíveis")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = CategoriaDto.class)))
    public ResponseEntity<List<CategoriaDto>> getAllCategorias() {
        var categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

}
