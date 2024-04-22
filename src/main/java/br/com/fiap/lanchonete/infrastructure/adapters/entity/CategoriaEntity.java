package br.com.fiap.lanchonete.infrastructure.adapters.entity;


import jakarta.persistence.*;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "categoria")
public class CategoriaEntity {
    @Id
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nome_categoria", nullable = false)
    private String nomeCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<ProdutoEntity> produtos;
}