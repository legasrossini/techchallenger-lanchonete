package br.com.fiap.lanchonete.infrastructure.adapters.repositories;

import br.com.fiap.lanchonete.domain.dtos.ProdutoDto;
import br.com.fiap.lanchonete.domain.ports.repositories.ProdutoRepositoryPort;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.ProdutoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepositoryImp implements ProdutoRepositoryPort {

    @Autowired
    private ProdutoJpaRepository produtoJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProdutoDto save(ProdutoDto produtoDto) {
        ProdutoEntity produtoEntity = modelMapper.map(produtoDto, ProdutoEntity.class);
        ProdutoEntity savedEntity = produtoJpaRepository.save(produtoEntity);
        return modelMapper.map(savedEntity, ProdutoDto.class);
    }

    @Override
    public Optional<ProdutoDto> findByIdProduto(String idProduto) {
        return Optional.ofNullable(produtoJpaRepository.findById(idProduto)
                .map(entity -> modelMapper.map(entity, ProdutoDto.class))
                .orElse(null));
    }

    @Override
    public List<ProdutoDto> findAll() {
        return produtoJpaRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, ProdutoDto.class))
                .toList();
    }

    @Override
    public void deleteByIdProduto(String idProduto) {
        produtoJpaRepository.deleteByIdProduto(idProduto);
    }

}
