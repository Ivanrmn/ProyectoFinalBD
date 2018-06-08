package org.mvpigs.proyectoFinalBD.service;

import org.mvpigs.proyectoFinalBD.model.Product;
import org.mvpigs.proyectoFinalBD.model.ProductConverter;
import org.mvpigs.proyectoFinalBD.model.ProductDto;
import org.mvpigs.proyectoFinalBD.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;

    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> productList = productRepository.findAll();

        return productList.stream()
                .map(product -> productConverter.toApiModel(product, ProductDto.class)
                ).collect(Collectors.toList());
    }

    @Override
    public ProductDto findOne(Long id) {
        Product product = productRepository.getOne(id);
        if (product != null) {
            return productConverter.toApiModel(product, ProductDto.class);
        }else {
            return null;
    }
    }

    @Override
    public void delete(ProductDto productDto) throws Exception {
        try {
            Optional<Product> product = Optional.of(productRepository.getOne(productDto.getId()));
            if (product.get() != null) {
                productRepository.delete(product.get());
            }
        } catch (IllegalArgumentException e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

    @Override
    public ProductDto update(ProductDto productDto) throws Exception{
        Optional<Product> product = Optional.of(productRepository.getOne(productDto.getId()));
        try {
            if (product != null) {
                BeanUtils.copyProperties(productDto, product);
                productRepository.save(product.get());
                return productConverter.toApiModel(product.get(), ProductDto.class);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
        return null;
    }

    @Override
    public ProductDto insert(ProductDto productDto) {
        Product product = productConverter.toDomainModel(productDto, Product.class);
        product = productRepository.save(product);
        return productConverter.toApiModel(product, ProductDto.class);
    }
}