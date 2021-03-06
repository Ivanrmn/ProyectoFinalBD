package org.mvpigs.proyectoFinalBD.service;

import org.mvpigs.proyectoFinalBD.model.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findOne(Long id);

    void delete(ProductDto productDto) throws Exception;

    ProductDto update(ProductDto productDto) throws Exception;

    ProductDto insert(ProductDto productDto);
}
