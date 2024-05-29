package br.com.fiap.lanchonete.core.domain.dtos;


public class CategoriaDto {
    private Integer id;
    private String nome;
    public CategoriaDto() {
    }
    public CategoriaDto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public static Builder builder() {
        return new Builder();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public static class Builder {
        private Integer id;
        private String nome;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }
        public CategoriaDto build() {
            return new CategoriaDto(id, nome);
        }
    }
}