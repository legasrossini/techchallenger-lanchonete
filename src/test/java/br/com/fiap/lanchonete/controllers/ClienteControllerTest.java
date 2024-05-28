package br.com.fiap.lanchonete.controllers;

import br.com.fiap.lanchonete.core.application.services.ClienteServiceImpl;
import br.com.fiap.lanchonete.core.domain.dtos.ClienteDto;
import br.com.fiap.lanchonete.core.domain.repositories.ClienteRepositoryPort;
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
    private ClienteServiceImpl clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByCpfClienteSuccess() {
        String cpfCliente = "12345678900";
        ClienteDto mockClienteDto = new ClienteDto();
        when(clienteRepository.findByCpfCliente(cpfCliente)).thenReturn(mockClienteDto);

        ClienteDto result = clienteService.findByCpfCliente(cpfCliente);

        assertNotNull(result);
        verify(clienteRepository, times(1)).findByCpfCliente(cpfCliente);
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