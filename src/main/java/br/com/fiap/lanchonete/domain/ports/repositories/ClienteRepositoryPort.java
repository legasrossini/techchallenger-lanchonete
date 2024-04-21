package br.com.fiap.lanchonete.domain.ports.repositories;

import br.com.fiap.lanchonete.domain.dtos.ClienteDto;

public interface ClienteRepositoryPort {
    ClienteDto findByCpf(String cpf);
    ClienteDto save(ClienteDto clienteDTO);
}
