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

@RestController
@RequestMapping("/lanchonete/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;

    @PostMapping
    public ResponseEntity<ProdutoDto> createProduto(@RequestBody ProdutoDto produtoDto) {
        ProdutoDto savedProduto = produtoServiceImpl.save(produtoDto);
        return ResponseEntity.ok(savedProduto);
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<ProdutoDto> getProdutoById(@PathVariable String idProduto) {
        return produtoServiceImpl.findByIdProduto(idProduto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<ProdutoDto>> getProdutosByCategoria(@PathVariable Integer idCategoria) {
        return ResponseEntity.ok(produtoServiceImpl.findByCategoria(idCategoria));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> getAllProdutos() {
        List<ProdutoDto> produtos = produtoServiceImpl.findAllByAtivoTrue();
        return ResponseEntity.ok(produtos);
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<Void> deleteProdutoById(@PathVariable String idProduto) {
        if (produtoServiceImpl.findByIdProduto(idProduto).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        produtoServiceImpl.deleteByIdProduto(idProduto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<ProdutoDto> updateProduto(@PathVariable String idProduto, @RequestBody ProdutoDto produtoDto) {
        produtoDto.setIdProduto(idProduto);
        ProdutoDto updatedProduto = produtoServiceImpl.saveOrUpdate(produtoDto);
        return ResponseEntity.ok(updatedProduto);
    }
}