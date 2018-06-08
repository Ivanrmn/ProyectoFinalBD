package org.mvpigs.proyectoFinalBD.controller;

import org.mvpigs.proyectoFinalBD.model.Product;
import org.mvpigs.proyectoFinalBD.model.ProductDto;
import org.mvpigs.proyectoFinalBD.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = ProductController.MAPPING)
public class ProductController {

    public static final String MAPPING = "/product";

    public static final String PRODUCT_MAPPING = "/{id}";

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "Get product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get product Ok", response = ProductDto[].class),
            @ApiResponse(code = 401, message = ApiConstants.UNAUTHORIZED, response = ApiError.class),
            @ApiResponse(code = 403, message = ApiConstants.FORBIDDEN, response = ApiError.class),
            @ApiResponse(code = 404, message = ApiConstants.NOT_FOUND, response = ApiError.class),
            @ApiResponse(code = 500, message = ApiConstants.INTERNAL_SERVER_ERROR_MESSAGE, response = ApiError.class) })
    @GetMapping(value = PRODUCT_MAPPING, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<ProductDto> getProduct(@PathVariable Long id) {
        return Optional.ofNullable(productService.findOne(id));
    }

    @ApiOperation(value = "Update product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update a product Ok", response = ProductDto[].class),
            @ApiResponse(code = 400, message = ApiConstants.BAD_REQUEST_MESSAGE, response = ApiValidationError.class),
            @ApiResponse(code = 401, message = ApiConstants.UNAUTHORIZED, response = ApiError.class),
            @ApiResponse(code = 403, message = ApiConstants.FORBIDDEN, response = ApiError.class),
            @ApiResponse(code = 500, message = ApiConstants.INTERNAL_SERVER_ERROR_MESSAGE, response = ApiError.class) })
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ProductDto update(@RequestBody ProductDto productDto)
            throws Exception {
        return productService.update(productDto);
    }

    @ApiOperation(value = "Delete product")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Delete a product Ok", response = ProductDto[].class),
            @ApiResponse(code = 401, message = ApiConstants.UNAUTHORIZED, response = ApiError.class),
            @ApiResponse(code = 403, message = ApiConstants.FORBIDDEN, response = ApiError.class),
            @ApiResponse(code = 500, message = ApiConstants.INTERNAL_SERVER_ERROR_MESSAGE, response = ApiError.class) })
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ProductDto delete(@RequestBody ProductDto productDto)
            throws Exception {
        productService.delete(productDto);
        return null;
    }

    @ApiOperation(value = "Add a product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Add a product Ok", response = ProductDto[].class),
            @ApiResponse(code = 400, message = ApiConstants.BAD_REQUEST_MESSAGE, response = ApiValidationError.class),
            @ApiResponse(code = 401, message = ApiConstants.UNAUTHORIZED, response = ApiError.class),
            @ApiResponse(code = 403, message = ApiConstants.FORBIDDEN, response = ApiError.class),
            @ApiResponse(code = 500, message = ApiConstants.INTERNAL_SERVER_ERROR_MESSAGE, response = ApiError.class) })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ProductDto insert(@RequestBody ProductDto productDto) {
        return productService.insert(productDto);
    }

    @ApiOperation(value = "Get all products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get all products Ok", response = Product[].class),
            @ApiResponse(code = 401, message = ApiConstants.UNAUTHORIZED, response = ApiError.class),
            @ApiResponse(code = 403, message = ApiConstants.FORBIDDEN, response = ApiError.class),
            @ApiResponse(code = 500, message = ApiConstants.INTERNAL_SERVER_ERROR_MESSAGE, response = ApiError.class) })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ProductDto> findAll(
            @RequestHeader(value = ApiConstants.MOCK_RESPONSE_HEADER, required = false) boolean mockResponse)
            throws Exception {
        return productService.findAll();
    }
}
