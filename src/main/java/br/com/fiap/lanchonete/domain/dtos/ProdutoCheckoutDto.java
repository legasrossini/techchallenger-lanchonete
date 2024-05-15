package br.com.fiap.lanchonete.domain.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoCheckoutDto {

    private String id;
    private BigDecimal preco;

}
