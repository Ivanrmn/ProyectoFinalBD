package org.mvpigs.proyectoFinalBD.service;

import org.mvpigs.proyectoFinalBD.model.TiendaDto;

import java.util.List;

public interface TiendaService {
    List<TiendaDto> findAll();

    TiendaDto findOne(Long id);

    void delete(TiendaDto tiendaDto) throws Exception;

    TiendaDto update(TiendaDto tiendaDto) throws Exception;

    TiendaDto insert(TiendaDto tiendaDto);
}
