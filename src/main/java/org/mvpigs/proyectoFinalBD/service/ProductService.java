package org.mvpigs.proyectoFinalBD.service;

import org.mvpigs.proyectoFinalBD.model.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> findAll();

    Optional<ProductDto> findOne(Long id);

    void delete(ProductDto productDto) throws Exception;

    ProductDto update(ProductDto productDto) throws Exception;

    ProductDto insert(ProductDto productDto);
}

