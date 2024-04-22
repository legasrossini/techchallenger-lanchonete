package br.com.fiap.lanchonete.domain.ports.repositories;

import br.com.fiap.lanchonete.domain.dtos.ClienteDto;

public interface ClienteRepositoryPort {
    ClienteDto findByCpfCliente(String cpfCliente);
    ClienteDto save(ClienteDto clienteDTO);
}
