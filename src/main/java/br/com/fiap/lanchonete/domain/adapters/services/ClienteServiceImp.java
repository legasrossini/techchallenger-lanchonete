package br.com.fiap.lanchonete.domain.adapters.services;

import br.com.fiap.lanchonete.domain.dtos.ClienteDto;
import br.com.fiap.lanchonete.domain.ports.interfaces.ClienteServicePort;
import br.com.fiap.lanchonete.domain.ports.repositories.ClienteRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImp implements ClienteServicePort {

    private final ClienteRepositoryPort clienteRepository;
    final ModelMapper modelMapper;

    @Autowired
    public ClienteServiceImp(ClienteRepositoryPort clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClienteDto findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    @Override
    public ClienteDto save(ClienteDto clienteDto) { return clienteRepository.save(clienteDto); }
}