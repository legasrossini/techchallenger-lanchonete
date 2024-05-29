package br.com.fiap.lanchonete.core.domain.dtos;

import java.math.BigDecimal;

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
    private String pedido;
    private ProdutoDto produto;
    private BigDecimal preco;
    private Integer comboNum;
}


