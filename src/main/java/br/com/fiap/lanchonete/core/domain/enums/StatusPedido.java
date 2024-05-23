package br.com.fiap.lanchonete.core.domain.enums;

import lombok.Getter;

@Getter
public enum StatusPedido {
    RECEBIDO,
    EM_PREPARACAO,
    PRONTO,
    FINALIZADO;
}
