package br.com.fiap.lanchonete.core.application.ports;

import br.com.fiap.lanchonete.core.domain.dtos.ClienteDto;

public interface ClienteServicePort {
    ClienteDto findByCpfCliente (String cpfCliente);
    ClienteDto save(ClienteDto clienteDTO);
}
