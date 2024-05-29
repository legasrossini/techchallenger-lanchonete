package br.com.fiap.lanchonete.core.domain.dtos;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ComboDto {

    @Schema(accessMode = AccessMode.READ_ONLY)
    private int comboNum;
    private ProdutoCheckoutDto lanche;
    private ProdutoCheckoutDto acompanhamento;
    private ProdutoCheckoutDto bebida;
    private ProdutoCheckoutDto sobremesa;

    public ComboDto() {}

    /**
     * 
     * @param comboNum
     * @param lanche
     * @param acompanhamento
     * @param bebida
     * @param sobremesa
     */
    public ComboDto(int comboNum, ProdutoCheckoutDto lanche, ProdutoCheckoutDto acompanhamento,
            ProdutoCheckoutDto bebida, ProdutoCheckoutDto sobremesa) {
        this.comboNum = comboNum;
        this.lanche = lanche;
        this.acompanhamento = acompanhamento;
        this.bebida = bebida;
        this.sobremesa = sobremesa;
    }

    @JsonIgnore
    public boolean possuiLanche(){
        return Optional.ofNullable(lanche).map(ProdutoCheckoutDto::getId).isPresent();
    }

    @JsonIgnore
    public boolean possuiAcompanhamento(){
        return Optional.ofNullable(acompanhamento).map(ProdutoCheckoutDto::getId).isPresent();
    }

    @JsonIgnore
    public boolean possuiBebida(){
        return Optional.ofNullable(bebida).map(ProdutoCheckoutDto::getId).isPresent();
    }

    @JsonIgnore
    public boolean possuiSobremesa(){
        return Optional.ofNullable(sobremesa).map(ProdutoCheckoutDto::getId).isPresent();
    }

    public int getComboNum() {
        return comboNum;
    }

    public void setComboNum(int comboNum) {
        this.comboNum = comboNum;
    }

    public ProdutoCheckoutDto getLanche() {
        return lanche;
    }

    public void setLanche(ProdutoCheckoutDto lanche) {
        this.lanche = lanche;
    }

    public ProdutoCheckoutDto getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(ProdutoCheckoutDto acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public ProdutoCheckoutDto getBebida() {
        return bebida;
    }

    public void setBebida(ProdutoCheckoutDto bebida) {
        this.bebida = bebida;
    }

    public ProdutoCheckoutDto getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(ProdutoCheckoutDto sobremesa) {
        this.sobremesa = sobremesa;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int comboNum;
        private ProdutoCheckoutDto lanche;
        private ProdutoCheckoutDto acompanhamento;
        private ProdutoCheckoutDto bebida;
        private ProdutoCheckoutDto sobremesa;

        // Setter methods for all fields

        public Builder comboNum(int comboNum) {
            this.comboNum = comboNum;
            return this;
        }

        public Builder lanche(ProdutoCheckoutDto lanche) {
            this.lanche = lanche;
            return this;
        }

        public Builder acompanhamento(ProdutoCheckoutDto acompanhamento) {
            this.acompanhamento = acompanhamento;
            return this;
        }

        public Builder bebida(ProdutoCheckoutDto bebida) {
            this.bebida = bebida;
            return this;
        }

        public Builder sobremesa(ProdutoCheckoutDto sobremesa) {
            this.sobremesa = sobremesa;
            return this;
        }

        // Build method to create an instance of ComboDto
        public ComboDto build() {
            return new ComboDto(comboNum, lanche, acompanhamento, bebida, sobremesa);
        }
    }

    

}
