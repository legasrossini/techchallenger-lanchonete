package br.com.fiap.lanchonete.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    @Schema(accessMode = AccessMode.READ_ONLY)
    private String id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private CategoriaDto categoria;
}