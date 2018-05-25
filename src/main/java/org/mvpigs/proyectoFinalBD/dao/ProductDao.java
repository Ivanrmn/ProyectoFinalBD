package org.mvpigs.proyectoFinalBD.dao;

import org.mvpigs.proyectoFinalBD.model.ProductDto;

import java.util.List;

public interface ProductDao {

    void insert(ProductDto productDto);

    void update(ProductDto productDto);

    void delete(ProductDto productDto);

    String getProduct(Long id);

    List<ProductDto> list();

}
