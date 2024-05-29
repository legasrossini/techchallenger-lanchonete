package br.com.fiap.lanchonete.core.domain.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProdutoCheckoutDto {

    private String id;
    
    @JsonIgnore
    private BigDecimal preco;

    /**
     * 
     * @param id
     * @param preco
     */
    public ProdutoCheckoutDto(String id, BigDecimal preco) {
        this.id = id;
        this.preco = preco;
    }

    public ProdutoCheckoutDto() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private BigDecimal preco;

        // Setter methods for all fields

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder preco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        // Build method to create an instance of ProdutoCheckoutDto
        public ProdutoCheckoutDto build() {
            return new ProdutoCheckoutDto(id, preco);
        }
    }

    

    

}
