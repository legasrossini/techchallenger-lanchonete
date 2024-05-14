package br.com.fiap.lanchonete.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
    private UUID idPedido;
    private Date dataHoraPedido;
    private String cliente;
    private List<Integer> items;
}
