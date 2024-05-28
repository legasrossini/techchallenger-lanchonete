package br.com.fiap.lanchonete.core.domain.repositories;

import java.util.List;
import java.util.Optional;

import br.com.fiap.lanchonete.core.domain.dtos.ProdutoDto;
import br.com.fiap.lanchonete.adapter.driven.entity.CategoriaEntity;

public interface ProdutoRepositoryPort {
    ProdutoDto save(ProdutoDto produtoDto); // Create and Update

    Optional<ProdutoDto> findByIdProduto(String idProduto); // Read

    List<ProdutoDto> findAll(); // Read All

    List<ProdutoDto> findAllByAtivoTrue(); // Read all ativo = true

    void deleteByIdProduto(String idProduto);

    List<ProdutoDto> findAllByAtivoTrueAndCategoria(CategoriaEntity categoria);
}