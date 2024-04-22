package br.com.fiap.lanchonete.domain.ports.interfaces;

import br.com.fiap.lanchonete.domain.dtos.ClienteDto;

public interface ClienteServicePort {
    ClienteDto findByCpfCliente (String cpfCliente);
    ClienteDto save(ClienteDto clienteDTO);
}
