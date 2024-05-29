package br.com.fiap.lanchonete.core.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.lanchonete.core.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDto {

    private String id;
    private ClienteDto cliente;
    private BigDecimal valor;
    private LocalDateTime dataHora;
    private StatusPedido status;
    @Builder.Default
    private List<PedidoProdutoDto> produtos = new ArrayList<>();
}
