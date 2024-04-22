package br.com.fiap.lanchonete.infrastructure.adapters.entity;


import jakarta.persistence.*;

import lombok.Data;

import java.math.BigDecimal;


@Data
@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @Column(name = "id_produto")
    private String idProduto;

    @Column(name = "nome_produto", nullable = false)
    private String nomeProduto;

    @Column(name = "descricao_produto")
    private String descricaoProduto;

    @Column(name = "preco_produto", nullable = false)
    private BigDecimal precoProduto;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaEntity categoria;
}