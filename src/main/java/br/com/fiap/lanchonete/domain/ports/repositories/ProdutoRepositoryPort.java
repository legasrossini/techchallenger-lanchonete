package br.com.fiap.lanchonete.domain.ports.repositories;

import java.util.List;
import java.util.Optional;

import br.com.fiap.lanchonete.domain.dtos.ProdutoDto;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.CategoriaEntity;

public interface ProdutoRepositoryPort {
    ProdutoDto save(ProdutoDto produtoDto); // Create and Update

    Optional<ProdutoDto> findByIdProduto(String idProduto); // Read

    List<ProdutoDto> findAll(); // Read All

    List<ProdutoDto> findAllByAtivoTrue(); // Read all ativo = true

    void deleteByIdProduto(String idProduto);

    List<ProdutoDto> findAllByAtivoTrueAndCategoria(CategoriaEntity categoria);
}