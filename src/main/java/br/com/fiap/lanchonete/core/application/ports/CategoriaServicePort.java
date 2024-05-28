package br.com.fiap.lanchonete.core.application.ports;

import java.util.List;

import br.com.fiap.lanchonete.core.domain.dtos.CategoriaDto;

public interface CategoriaServicePort {

    List<CategoriaDto> findAll();

}
