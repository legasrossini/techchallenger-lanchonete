package br.com.fiap.lanchonete.core.domain.repositories;

import br.com.fiap.lanchonete.core.domain.dtos.ClienteDto;

public interface ClienteRepositoryPort {
    ClienteDto findByCpfCliente(String cpfCliente);
    ClienteDto save(ClienteDto clienteDTO);
}
