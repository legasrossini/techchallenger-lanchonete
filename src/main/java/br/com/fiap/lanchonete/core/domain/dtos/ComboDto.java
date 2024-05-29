package br.com.fiap.lanchonete.core.domain.dtos;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComboDto {

    @Schema(accessMode = AccessMode.READ_ONLY)
    private int comboNum;
    private ProdutoCheckoutDto lanche;
    private ProdutoCheckoutDto acompanhamento;
    private ProdutoCheckoutDto bebida;
    private ProdutoCheckoutDto sobremesa;

    @JsonIgnore
    public boolean possuiLanche(){
        return Optional.ofNullable(lanche).map(ProdutoCheckoutDto::getId).isPresent();
    }

    @JsonIgnore
    public boolean possuiAcompanhamento(){
        return Optional.ofNullable(acompanhamento).map(ProdutoCheckoutDto::getId).isPresent();
    }

    @JsonIgnore
    public boolean possuiBebida(){
        return Optional.ofNullable(bebida).map(ProdutoCheckoutDto::getId).isPresent();
    }

    @JsonIgnore
    public boolean possuiSobremesa(){
        return Optional.ofNullable(sobremesa).map(ProdutoCheckoutDto::getId).isPresent();
    }

}
