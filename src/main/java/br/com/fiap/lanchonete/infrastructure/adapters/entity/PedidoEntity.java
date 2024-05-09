package br.com.fiap.lanchonete.infrastructure.adapters.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "pedido")
public class PedidoEntity {
    @Id
    @Column(name = "id_pedido", nullable = false)
    private UUID idPedido;

    @Column(name = "cliente")
    private String cliente;
}
