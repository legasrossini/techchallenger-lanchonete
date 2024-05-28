package br.com.fiap.lanchonete.core.application.services;

import br.com.fiap.lanchonete.core.domain.dtos.ProdutoDto;
import br.com.fiap.lanchonete.core.application.ports.ProdutoServicePort;
import br.com.fiap.lanchonete.core.domain.repositories.ProdutoRepositoryPort;
import br.com.fiap.lanchonete.adapter.driven.entity.CategoriaEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoServicePort {
    @Autowired
    private ProdutoRepositoryPort produtoRepository;

    @Override
    public ProdutoDto save(ProdutoDto produtoDto) {
        produtoDto.setId(UUID.randomUUID().toString());
        return produtoRepository.save(produtoDto);
    }

    @Override
    public Optional<ProdutoDto> findByIdProduto(String idProduto) {
        return produtoRepository.findByIdProduto(idProduto);
    }

    @Override
    public List<ProdutoDto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public List<ProdutoDto> findAllByAtivoTrue() {
        return produtoRepository.findAllByAtivoTrue();
    }

    @Override
    public List<ProdutoDto> findByCategoria(Integer idCategoria) {
        return produtoRepository.findAllByAtivoTrueAndCategoria(
                CategoriaEntity.builder().id(Optional.ofNullable(idCategoria).orElse(0)).build());
    }

    @Override
    public void deleteByIdProduto(String idProduto) {
        produtoRepository.deleteByIdProduto(idProduto);
    }

    @Override
    public ProdutoDto saveOrUpdate(ProdutoDto produtoDto) {
        // Verifica se o produto já existe
        Optional<ProdutoDto> existingProduto = produtoRepository.findByIdProduto(produtoDto.getId());
        if (existingProduto.isPresent()) {
            // Atualiza o produto existente
            ProdutoDto updatedProduto = existingProduto.get();
            updatedProduto.setNome(produtoDto.getNome());
            updatedProduto.setDescricao(produtoDto.getDescricao());
            updatedProduto.setPreco(produtoDto.getPreco());
            updatedProduto.setCategoria(produtoDto.getCategoria());
            return produtoRepository.save(updatedProduto);
        } else {
            // Salva um novo produto
            return produtoRepository.save(produtoDto);
        }
    }
}