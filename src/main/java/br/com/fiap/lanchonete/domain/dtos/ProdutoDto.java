package br.com.fiap.lanchonete.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private static final Integer ID_CATEGORIA_LANCHE = 1;
    private static final Integer ID_CATEGORIA_ACOMPANHAMENTO = 2;
    private static final Integer ID_CATEGORIA_BEBIDA = 3;
    private static final Integer ID_CATEGORIA_SOBREMESA = 4;

    @Schema(accessMode = AccessMode.READ_ONLY)
    private String id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private CategoriaDto categoria;
    @Schema(accessMode = AccessMode.READ_ONLY)
    private boolean ativo;

    public boolean isLanche(){
        return Optional.ofNullable(categoria).map(CategoriaDto::getId).orElse(-1).equals(ID_CATEGORIA_LANCHE);
    }

    public boolean isAcompanhamento(){
        return Optional.ofNullable(categoria).map(CategoriaDto::getId).orElse(-1).equals(ID_CATEGORIA_ACOMPANHAMENTO);
    }

    public boolean isBebida(){
        return Optional.ofNullable(categoria).map(CategoriaDto::getId).orElse(-1).equals(ID_CATEGORIA_BEBIDA);
    }

    public boolean isSobremesa(){
        return Optional.ofNullable(categoria).map(CategoriaDto::getId).orElse(-1).equals(ID_CATEGORIA_SOBREMESA);
    }
}