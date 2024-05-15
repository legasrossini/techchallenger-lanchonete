package br.com.fiap.lanchonete.domain.dtos;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
    private String cpfCliente;
    private BigDecimal valor;
    private List<ComboDto> produtos;
}
