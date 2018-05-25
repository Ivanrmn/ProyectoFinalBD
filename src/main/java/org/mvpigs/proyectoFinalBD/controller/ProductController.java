package org.mvpigs.proyectoFinalBD.controller;

import org.mvpigs.proyectoFinalBD.model.ProductDto;
import org.mvpigs.proyectoFinalBD.service.ProductService;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping(value = ProductController.MAPPING)
    public class ProductController {

        public static final String MAPPING = "/product";

        public static final String PRODUCT_MAPPING = "/{id}";

        private final ProductService productService;

        public ProductController(ProductService productService) {
            this.productService = productService;
        }

        @GetMapping(value = PRODUCT_MAPPING)
        public ProductDto getProduct(@PathVariable Long id)
                throws Exception {
            return productService.findOne(id);
        }

        @PutMapping
        public ProductDto update(@RequestBody ProductDto productDto)
                throws Exception {
            return productService.update(productDto);
        }

        @DeleteMapping
        public ProductDto delete(@RequestBody ProductDto productDto)
                throws Exception {
            productService.delete(productDto);
            return null;
        }

        @PostMapping
        public ProductDto insert(@RequestBody ProductDto productDto)
                throws Exception {
            return productService.insert(productDto);
        }
    }
}
