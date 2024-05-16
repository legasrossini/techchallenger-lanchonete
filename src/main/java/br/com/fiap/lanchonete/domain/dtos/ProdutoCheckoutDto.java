package br.com.fiap.lanchonete.domain.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private BigDecimal preco;

}
