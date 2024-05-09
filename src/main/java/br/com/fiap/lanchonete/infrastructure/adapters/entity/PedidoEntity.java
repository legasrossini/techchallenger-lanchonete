package br.com.fiap.lanchonete.infrastructure.adapters.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "pedido")
public class PedidoEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

//    @Column(name = "data_hora_pedido", nullable = false)
//    private Date dataHoraPedido;
//
//    @ManyToOne
//    @JoinColumn(name = "cliente")
    @Column(name = "cliente")
    private ClienteEntity cliente;
//
//    @Column(name = "items", nullable = false)
//    private List<Integer> items;
}
