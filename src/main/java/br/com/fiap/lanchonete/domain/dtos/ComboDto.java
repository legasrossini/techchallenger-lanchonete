package br.com.fiap.lanchonete.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComboDto {

    private String lanche;
    private String acompanhamento;
    private String bebida;
    private String sobremesa;

}
