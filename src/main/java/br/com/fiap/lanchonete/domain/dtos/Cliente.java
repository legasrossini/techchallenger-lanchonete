package br.com.fiap.lanchonete.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Cliente {
    private String cpf;
    private String nome;
    private String email;
}