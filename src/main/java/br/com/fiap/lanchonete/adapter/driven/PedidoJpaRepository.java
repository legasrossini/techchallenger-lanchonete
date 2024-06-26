package br.com.fiap.lanchonete.adapter.driven;

import br.com.fiap.lanchonete.adapter.driven.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, UUID> {

    @Query("SELECT p FROM PedidoEntity p join fetch p.produtos prod order by p.dataHora")
    List<PedidoEntity> findAllComProdutos();

}
