package br.com.fiap.lanchonete.core.domain.dtos;

import java.math.BigDecimal;
import java.util.List;

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
public class PedidoDto {
    
    private String cpfCliente;
    
    @Schema(accessMode = AccessMode.READ_ONLY)
    private BigDecimal valor;
    
    private List<ComboDto> produtos;
}
