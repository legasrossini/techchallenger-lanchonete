package br.com.fiap.lanchonete.infrastructure.adapters.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    private String cpf;
    private String nome;
    private String email;
}