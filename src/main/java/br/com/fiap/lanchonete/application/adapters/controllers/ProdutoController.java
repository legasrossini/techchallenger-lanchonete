package br.com.fiap.lanchonete.application.adapters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lanchonete.domain.adapters.services.ProdutoServiceImpl;
import br.com.fiap.lanchonete.domain.dtos.ProdutoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/lanchonete/v1/produtos")
@Tag(name = "Produtos", description = "Produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;

    @PostMapping
    @Operation(description = "Cadastra um novo produto")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = ProdutoDto.class)))
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    public ResponseEntity<ProdutoDto> createProduto(@RequestBody ProdutoDto produtoDto) {
        ProdutoDto savedProduto = produtoServiceImpl.save(produtoDto);
        return ResponseEntity.ok(savedProduto);
    }

    @GetMapping("/{idProduto}")
    @Operation(description = "Consulta um produto por ID, trazendo o registro mesmo que esteja inativo")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = ProdutoDto.class)))
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<ProdutoDto> getProdutoById(@PathVariable String idProduto) {
        return produtoServiceImpl.findByIdProduto(idProduto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{idCategoria}")
    @Operation(description = "Lista todos os produtos ativos por categoria. Para visualizar as categorias disponíveis, consulte o endpoint /categorias")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = ProdutoDto.class)))
    public ResponseEntity<List<ProdutoDto>> getProdutosByCategoria(@PathVariable Integer idCategoria) {
        return ResponseEntity.ok(produtoServiceImpl.findByCategoria(idCategoria));
    }

    @GetMapping
    @Operation(description = "Lista todos os produtos ativos")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = ProdutoDto.class)))
    public ResponseEntity<List<ProdutoDto>> getAllProdutos() {
        List<ProdutoDto> produtos = produtoServiceImpl.findAllByAtivoTrue();
        return ResponseEntity.ok(produtos);
    }

    @DeleteMapping("/{idProduto}")
    @Operation(description = "Efetua a exclusão (lógica) de um produto por ID")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ResponseEntity<Void> deleteProdutoById(@PathVariable String idProduto) {
        if (produtoServiceImpl.findByIdProduto(idProduto).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        produtoServiceImpl.deleteByIdProduto(idProduto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idProduto}")
    @Operation(description = "Cadastra ou atualiza um produto. Se o ID for localizado, atualiza, caso contrário cria um novo")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    public ResponseEntity<ProdutoDto> updateProduto(@PathVariable String idProduto, @RequestBody ProdutoDto produtoDto) {
        produtoDto.setId(idProduto);
        ProdutoDto updatedProduto = produtoServiceImpl.saveOrUpdate(produtoDto);
        return ResponseEntity.ok(updatedProduto);
    }
}