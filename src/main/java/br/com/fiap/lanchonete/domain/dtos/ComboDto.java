package br.com.fiap.lanchonete.domain.dtos;

import java.util.Optional;

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
public class ComboDto {

    @Schema(accessMode = AccessMode.READ_ONLY)
    private int comboNum;
    private ProdutoCheckoutDto lanche;
    private ProdutoCheckoutDto acompanhamento;
    private ProdutoCheckoutDto bebida;
    private ProdutoCheckoutDto sobremesa;

    public boolean possuiLanche(){
        return Optional.ofNullable(lanche).map(ProdutoCheckoutDto::getId).isPresent();
    }

    public boolean possuiAcompanhamento(){
        return Optional.ofNullable(acompanhamento).map(ProdutoCheckoutDto::getId).isPresent();
    }

    public boolean possuiBebida(){
        return Optional.ofNullable(bebida).map(ProdutoCheckoutDto::getId).isPresent();
    }

    public boolean possuiSobremesa(){
        return Optional.ofNullable(sobremesa).map(ProdutoCheckoutDto::getId).isPresent();
    }

}
