package br.com.fiap.lanchonete.infrastructure.adapters.repositories;

import br.com.fiap.lanchonete.infrastructure.adapters.entity.ProdutoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, String> {
    @Query("SELECT p FROM ProdutoEntity p WHERE p.idProduto = :idProduto")
    Optional<ProdutoEntity> findByIdProduto(String idProduto);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProdutoEntity p WHERE p.idProduto = :idProduto")
    void deleteByIdProduto(String idProduto);

}