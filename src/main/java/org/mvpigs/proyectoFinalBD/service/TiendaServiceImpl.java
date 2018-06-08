package org.mvpigs.proyectoFinalBD.service;

import org.mvpigs.proyectoFinalBD.model.Tienda;
import org.mvpigs.proyectoFinalBD.model.TiendaConverter;
import org.mvpigs.proyectoFinalBD.model.TiendaDto;
import org.mvpigs.proyectoFinalBD.repository.TiendaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TiendaServiceImpl implements TiendaService {

    private final TiendaRepository tiendaRepository;
    private final TiendaConverter tiendaConverter;

    @Autowired
    public TiendaServiceImpl(TiendaRepository tiendaRepository, TiendaConverter tiendaConverter) {
        this.tiendaConverter = tiendaConverter;
        this.tiendaRepository = tiendaRepository;

    }

    @Override
    public List<TiendaDto> findAll() {
        List<Tienda> tiendaList = tiendaRepository.findAll();

        return tiendaList.stream()
                .map(tienda -> tiendaConverter.toApiModel(tienda, TiendaDto.class)
                ).collect(Collectors.toList());
    }

    @Override
    public TiendaDto findOne(Long id) {
        Tienda tienda = tiendaRepository.getOne(id);
        if (tienda != null) {
            return tiendaConverter.toApiModel(tienda, TiendaDto.class);
        }else {
            return null;
        }
    }

    @Override
    public void delete(TiendaDto tiendaDto) throws Exception {
        try {
            Optional<Tienda> tienda = Optional.of(tiendaRepository.getOne(tiendaDto.getId()));
            if (tienda.get() != null) {
                tiendaRepository.delete(tienda.get());
            }
        } catch (IllegalArgumentException e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

    @Override
    public TiendaDto update(TiendaDto tiendaDto) {
        Tienda tienda = tiendaRepository.getOne(tiendaDto.getId());
        if (tienda != null) {
            BeanUtils.copyProperties(tiendaDto, tienda);
            tiendaRepository.save(tienda);
            return tiendaConverter.toApiModel(tienda, TiendaDto.class);
        }
        return null;
    }

    @Override
    public TiendaDto insert(TiendaDto tiendaDto) {
        Tienda tienda = tiendaConverter.toDomainModel(tiendaDto, Tienda.class);
        tienda = tiendaRepository.save(tienda);
        return tiendaConverter.toApiModel(tienda, TiendaDto.class);
    }
}
