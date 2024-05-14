package br.com.fiap.lanchonete.infrastructure.enums;

import lombok.Getter;

@Getter
public enum StatusPedido {
    RECEBIDO,
    EM_PREPARACAO,
    PRONTO,
    FINALIZADO;
}
