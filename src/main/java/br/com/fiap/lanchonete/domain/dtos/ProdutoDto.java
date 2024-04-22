package br.com.fiap.lanchonete.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private String idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private Double precoProduto;
    private CategoriaDto categoria;
}