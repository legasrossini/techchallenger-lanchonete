package br.com.fiap.lanchonete.infrastructure.adapters.entity;

import jakarta.persistence.*;

import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaEntity categoria;

    @Column(nullable = false)
    private boolean ativo = true;
}