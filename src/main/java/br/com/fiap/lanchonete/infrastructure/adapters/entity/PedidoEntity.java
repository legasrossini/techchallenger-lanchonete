package br.com.fiap.lanchonete.infrastructure.adapters.entity;

import br.com.fiap.lanchonete.infrastructure.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cpf_cliente")
    private ClienteEntity cliente;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Column(name = "valor")
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
    private List<PedidoProdutoEntity> produtos;

}
