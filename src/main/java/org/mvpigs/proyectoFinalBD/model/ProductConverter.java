package org.mvpigs.proyectoFinalBD.model;

import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductDto toApiModel(Product product, Class<ProductDto> productDtoClass) {
        ProductDto result = new ProductDto();
        result.setId(product.getId());
        result.setName((product.getName()));
        result.setDescription(product.getDescription());
        result.setPrice(product.getPrice());
        return result;
    }

    public Product toDomainModel(ProductDto productDto, Class<Product> productClass) {
        Product result = new Product();
        result.setId(productDto.getId());
        result.setName(productClass.getName());
        result.setDescription(productDto.getDescription());
        result.setPrice(productDto.getPrice());
        return result;

    }
}
