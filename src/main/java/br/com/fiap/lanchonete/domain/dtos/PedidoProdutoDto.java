package br.com.fiap.lanchonete.domain.dtos;

import java.math.BigDecimal;

import br.com.fiap.lanchonete.infrastructure.adapters.entity.PedidoEntity;
import br.com.fiap.lanchonete.infrastructure.adapters.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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


