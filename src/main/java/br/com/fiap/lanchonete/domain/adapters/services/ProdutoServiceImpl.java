package br.com.fiap.lanchonete.domain.adapters.services;

import br.com.fiap.lanchonete.domain.dtos.ProdutoDto;
import br.com.fiap.lanchonete.domain.ports.interfaces.ProdutoServicePort;
import br.com.fiap.lanchonete.domain.ports.repositories.ProdutoRepositoryPort;
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
        produtoDto.setIdProduto(UUID.randomUUID().toString());
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
    public void deleteByIdProduto(String idProduto) {
        produtoRepository.deleteByIdProduto(idProduto);
    }

    @Override
    public ProdutoDto saveOrUpdate(ProdutoDto produtoDto) {
        // Verifica se o produto já existe
        Optional<ProdutoDto> existingProduto = produtoRepository.findByIdProduto(produtoDto.getIdProduto());
        if (existingProduto.isPresent()) {
            // Atualiza o produto existente
            ProdutoDto updatedProduto = existingProduto.get();
            updatedProduto.setNomeProduto(produtoDto.getNomeProduto());
            updatedProduto.setDescricaoProduto(produtoDto.getDescricaoProduto());
            updatedProduto.setPrecoProduto(produtoDto.getPrecoProduto());
            updatedProduto.setCategoria(produtoDto.getCategoria());
            return produtoRepository.save(updatedProduto);
        } else {
            // Salva um novo produto
            return produtoRepository.save(produtoDto);
        }
    }
}