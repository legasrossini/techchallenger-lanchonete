package br.com.fiap.lanchonete.domain.domain;

import lombok.Data;

@Data
public class Cliente {
    private String cpf;
    private String nome;
    private String email;
}