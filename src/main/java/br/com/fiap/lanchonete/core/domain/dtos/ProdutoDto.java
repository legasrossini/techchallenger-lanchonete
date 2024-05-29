package br.com.fiap.lanchonete.core.domain.dtos;

import java.math.BigDecimal;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;

public class ProdutoDto {

    private static final Integer ID_CATEGORIA_LANCHE = 1;
    private static final Integer ID_CATEGORIA_ACOMPANHAMENTO = 2;
    private static final Integer ID_CATEGORIA_BEBIDA = 3;
    private static final Integer ID_CATEGORIA_SOBREMESA = 4;

    @Schema(accessMode = AccessMode.READ_ONLY)
    private String id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private CategoriaDto categoria;
    @Schema(accessMode = AccessMode.READ_ONLY)
    private boolean ativo = true;

    

    public ProdutoDto(){}

    /**
     * 
     * @param id
     * @param nome
     * @param descricao
     * @param preco
     * @param categoria
     * @param ativo
     */
    public ProdutoDto(String id, String nome, String descricao, BigDecimal preco, CategoriaDto categoria,
            boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.ativo = ativo;
    }

    @JsonIgnore
    public boolean isLanche(){
        return Optional.ofNullable(categoria).map(CategoriaDto::getId).orElse(-1).equals(ID_CATEGORIA_LANCHE);
    }

    @JsonIgnore
    public boolean isAcompanhamento(){
        return Optional.ofNullable(categoria).map(CategoriaDto::getId).orElse(-1).equals(ID_CATEGORIA_ACOMPANHAMENTO);
    }

    @JsonIgnore
    public boolean isBebida(){
        return Optional.ofNullable(categoria).map(CategoriaDto::getId).orElse(-1).equals(ID_CATEGORIA_BEBIDA);
    }

    @JsonIgnore
    public boolean isSobremesa(){
        return Optional.ofNullable(categoria).map(CategoriaDto::getId).orElse(-1).equals(ID_CATEGORIA_SOBREMESA);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoria = categoria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String nome;
        private String descricao;
        private BigDecimal preco;
        private CategoriaDto categoria;
        private boolean ativo = true;

        // Setter methods for all fields

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder preco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public Builder categoria(CategoriaDto categoria) {
            this.categoria = categoria;
            return this;
        }

        public Builder ativo(boolean ativo) {
            this.ativo = ativo;
            return this;
        }

        public ProdutoDto build() {
            return new ProdutoDto(id, nome, descricao, preco, categoria, ativo);
        }
    }
}