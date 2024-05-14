package br.com.fiap.lanchonete.infrastructure.adapters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categoria")
public class CategoriaEntity {
    @Id
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nome_categoria", nullable = false)
    private String nomeCategoria;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<ProdutoEntity> produtos;
}