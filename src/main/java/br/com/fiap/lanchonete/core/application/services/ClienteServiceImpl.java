package br.com.fiap.lanchonete.core.application.services;

import br.com.fiap.lanchonete.core.domain.dtos.ClienteDto;
import br.com.fiap.lanchonete.core.application.ports.ClienteServicePort;
import br.com.fiap.lanchonete.core.domain.repositories.ClienteRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteServicePort {

    @Autowired
    private ClienteRepositoryPort clienteRepository;

    @Override
    public ClienteDto findByCpfCliente(String cpfCliente) {
        return clienteRepository.findByCpfCliente(cpfCliente);
    }

    @Override
    public ClienteDto save(ClienteDto clienteDto) { return clienteRepository.save(clienteDto); }
}