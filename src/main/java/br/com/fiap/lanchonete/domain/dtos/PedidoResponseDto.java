package br.com.fiap.lanchonete.domain.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDto {

    private ClienteDto cliente;
    private BigDecimal valor;
    @Builder.Default
    private List<ProdutoDto> produtos = new ArrayList<>();
}
