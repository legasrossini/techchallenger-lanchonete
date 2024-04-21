package br.com.fiap.lanchonete.domain.ports.interfaces;

import br.com.fiap.lanchonete.domain.dtos.ClienteDto;

public interface ClienteServicePort {
    ClienteDto findByCpf(String cpf);
    ClienteDto save(ClienteDto clienteDTO);
}
