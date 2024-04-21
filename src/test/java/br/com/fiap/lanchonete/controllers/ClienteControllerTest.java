package br.com.fiap.lanchonete.controllers;

import br.com.fiap.lanchonete.domain.adapters.services.ClienteServiceImp;
import br.com.fiap.lanchonete.domain.dtos.ClienteDto;
import br.com.fiap.lanchonete.domain.ports.repositories.ClienteRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@RestController
@RequestMapping("/lanchonete/v1/clientes")
public class ClienteControllerTest {

    @Mock
    private ClienteRepositoryPort clienteRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ClienteServiceImp clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByCpfSuccess() {
        String cpf = "12345678900";
        ClienteDto mockClienteDto = new ClienteDto();
        when(clienteRepository.findByCpf(cpf)).thenReturn(mockClienteDto);

        ClienteDto result = clienteService.findByCpf(cpf);

        assertNotNull(result);
        verify(clienteRepository, times(1)).findByCpf(cpf);
    }

    @Test
    void saveSuccess() {
        ClienteDto clienteDto = new ClienteDto();
        when(clienteRepository.save(clienteDto)).thenReturn(clienteDto);

        ClienteDto savedClienteDto = clienteService.save(clienteDto);

        assertNotNull(savedClienteDto);
        verify(clienteRepository, times(1)).save(clienteDto);
    }

}