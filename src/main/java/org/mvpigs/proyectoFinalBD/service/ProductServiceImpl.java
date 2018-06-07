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
    private final Product product;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductConverter productConverter,
                              Product product) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
        this.product = product;
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> productList = (List<Product>) productRepository.findAll();

        return productList.stream()
                .map(product -> productConverter.toApiModel(product, ProductDto.class)
                ).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto> findOne(Long id) {
        Product product = productRepository.findOne(id);
        if (product == null) {
            return Optional.empty();
        }
        return Optional.of(productConverter.toApiModel(product, ProductDto.class));
    }

    @Override
    public void delete(ProductDto productDto) throws Exception {
        try {
            Product product = productRepository.findOne(productDto.getId());
            if (product != null) {
                productRepository.delete(product);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

    @Override
    public ProductDto update(ProductDto productDto) throws Exception{
        Product product = productRepository.findOne(productDto.getId());
        try {
            if (product != null) {
                BeanUtils.copyProperties(productDto, product);
                product = productRepository.save(product);
                return productConverter.toApiModel(product, ProductDto.class);
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