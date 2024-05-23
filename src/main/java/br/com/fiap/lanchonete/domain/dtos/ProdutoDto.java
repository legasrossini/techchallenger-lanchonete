package br.com.fiap.lanchonete.domain.dtos;

import java.math.BigDecimal;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Builder.Default
    private boolean ativo = true;

    @JsonIgnore
    public boolean isLanche(){
        return Optional.ofNullable(categoria).map(CategoriaDto::getId).orElse(-1).equals(ID_CATEGORIA_LANCHE);
    }

    @JsonIgnore
    public boolean isAcompanhamento(){
        return Optional.ofNullable(categoria).map(CategoriaDto::getId).orElse(-1).equals(ID_CATEGORIA_ACOMPANHAMENTO);
    }

    @JsonIgnore
    public boolean isBebida(){
        return Optional.ofNullable(categoria).map(CategoriaDto::getId).orElse(-1).equals(ID_CATEGORIA_BEBIDA);
    }

    @JsonIgnore
    public boolean isSobremesa(){
        return Optional.ofNullable(categoria).map(CategoriaDto::getId).orElse(-1).equals(ID_CATEGORIA_SOBREMESA);
    }
}