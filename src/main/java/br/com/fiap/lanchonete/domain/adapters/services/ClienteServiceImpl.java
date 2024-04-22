package br.com.fiap.lanchonete.domain.adapters.services;

import br.com.fiap.lanchonete.domain.dtos.ClienteDto;
import br.com.fiap.lanchonete.domain.ports.interfaces.ClienteServicePort;
import br.com.fiap.lanchonete.domain.ports.repositories.ClienteRepositoryPort;
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