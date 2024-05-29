package br.com.fiap.lanchonete.core.domain.dtos;

public class ClienteDto {
    private String cpf;
    private String nome;
    private String email;
        public ClienteDto() {
    }

    public ClienteDto(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }
    public static Builder builder() {
        return new Builder();
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder {
        private String cpf;
        private String nome;
        private String email;
        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public ClienteDto build() {
            return new ClienteDto(cpf, nome, email);
        }
    }
}