package br.com.fiap.lanchonete.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private String cpfCliente;
    private String nomeCliente;
    private String emailCliente;
}