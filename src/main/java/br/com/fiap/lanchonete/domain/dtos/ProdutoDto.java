package br.com.fiap.lanchonete.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    @Schema(accessMode = AccessMode.READ_ONLY)
    private String idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private Double precoProduto;
    private CategoriaDto categoria;
}