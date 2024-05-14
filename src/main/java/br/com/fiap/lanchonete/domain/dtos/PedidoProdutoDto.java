package br.com.fiap.lanchonete.domain.dtos;

import br.com.fiap.lanchonete.infrastructure.adapters.entity.PedidoEntity;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.ProdutoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoProdutoDto {

    private Integer id;
    private PedidoEntity pedido;
    private ProdutoEntity produto;
    private BigDecimal preco;
    private Integer comboNum;
}


