package br.com.fiap.lanchonete.core.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ClienteDto {
    private String cpf;
    private String nome;
    private String email;

    // Constructor without parameters
    public ClienteDto() {
    }

    // Constructor with all parameters
    public ClienteDto(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public static Builder builder() {
        return new Builder();
    }

    // Getters and Setters
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

    // Builder class
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