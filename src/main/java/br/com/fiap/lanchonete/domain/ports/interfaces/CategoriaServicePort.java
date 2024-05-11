package br.com.fiap.lanchonete.domain.ports.interfaces;

import java.util.List;

import br.com.fiap.lanchonete.domain.dtos.CategoriaDto;

public interface CategoriaServicePort {

    List<CategoriaDto> findAll();

}
