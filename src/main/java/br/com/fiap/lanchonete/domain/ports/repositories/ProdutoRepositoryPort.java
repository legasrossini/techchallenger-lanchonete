package br.com.fiap.lanchonete.domain.ports.repositories;

import br.com.fiap.lanchonete.domain.dtos.ProdutoDto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepositoryPort {
    ProdutoDto save(ProdutoDto produtoDto); // Create and Update
    Optional<ProdutoDto> findByIdProduto(String idProduto); // Read
    List<ProdutoDto> findAll(); // Read All

    void deleteByIdProduto(String idProduto);
}