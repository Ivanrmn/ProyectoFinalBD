//package org.mvpigs.proyectoFinalBD.controller;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.mvpigs.proyectoFinalBD.model.TiendaDto;
//import org.mvpigs.proyectoFinalBD.service.TiendaService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping(value = TiendaController.MAPPING)
//public class TiendaController {
//
//    public static final String MAPPING = "/store";
//
//    public static final String TIENDA_MAPPING = "/{id}";
//
//    private final TiendaService tiendaService;
//
//    public TiendaController(TiendaService tiendaService) {
//        this.tiendaService = tiendaService;
//    }
//
//    @ApiOperation(value = "Get tienda")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Get tienda Ok", response = TiendaDto[].class),
//            @ApiResponse(code = 401, message = ApiConstants.UNAUTHORIZED, response = ApiError.class),
//            @ApiResponse(code = 403, message = ApiConstants.FORBIDDEN, response = ApiError.class),
//            @ApiResponse(code = 404, message = ApiConstants.NOT_FOUND, response = ApiError.class),
//            @ApiResponse(code = 500, message = ApiConstants.INTERNAL_SERVER_ERROR_MESSAGE, response = ApiError.class) })
//    @GetMapping(value = TIENDA_MAPPING, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(value = HttpStatus.OK)
//    public Optional<TiendaDto> getTienda(@PathVariable Long id) {
//        return Optional.ofNullable(tiendaService.findOne(id));
//    }
//
//    @ApiOperation(value = "Update tienda")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Update a tienda Ok", response = TiendaDto[].class),
//            @ApiResponse(code = 400, message = ApiConstants.BAD_REQUEST_MESSAGE, response = ApiValidationError.class),
//            @ApiResponse(code = 401, message = ApiConstants.UNAUTHORIZED, response = ApiError.class),
//            @ApiResponse(code = 403, message = ApiConstants.FORBIDDEN, response = ApiError.class),
//            @ApiResponse(code = 500, message = ApiConstants.INTERNAL_SERVER_ERROR_MESSAGE, response = ApiError.class) })
//    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(value = HttpStatus.OK)
//    public TiendaDto update(@RequestBody TiendaDto tiendaDto)
//            throws Exception {
//        return tiendaService.update(tiendaDto);
//    }
//
//    @ApiOperation(value = "Delete tienda")
//    @ApiResponses(value = {
//            @ApiResponse(code = 204, message = "Delete a tienda Ok", response = TiendaDto[].class),
//            @ApiResponse(code = 401, message = ApiConstants.UNAUTHORIZED, response = ApiError.class),
//            @ApiResponse(code = 403, message = ApiConstants.FORBIDDEN, response = ApiError.class),
//            @ApiResponse(code = 500, message = ApiConstants.INTERNAL_SERVER_ERROR_MESSAGE, response = ApiError.class) })
//    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public TiendaDto delete(@RequestBody TiendaDto tiendaDto)
//            throws Exception {
//        tiendaService.delete(tiendaDto);
//        return null;
//    }
//
//    @ApiOperation(value = "Add a tienda")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Add a tienda Ok", response = TiendaDto[].class),
//            @ApiResponse(code = 400, message = ApiConstants.BAD_REQUEST_MESSAGE, response = ApiValidationError.class),
//            @ApiResponse(code = 401, message = ApiConstants.UNAUTHORIZED, response = ApiError.class),
//            @ApiResponse(code = 403, message = ApiConstants.FORBIDDEN, response = ApiError.class),
//            @ApiResponse(code = 500, message = ApiConstants.INTERNAL_SERVER_ERROR_MESSAGE, response = ApiError.class) })
//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public TiendaDto insert(@RequestBody TiendaDto tiendaDto) {
//        return tiendaService.insert(tiendaDto);
//    }
//
//    @ApiOperation(value = "Get all tiendas")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Get all tiendas Ok", response = TiendaDto[].class),
//            @ApiResponse(code = 401, message = ApiConstants.UNAUTHORIZED, response = ApiError.class),
//            @ApiResponse(code = 403, message = ApiConstants.FORBIDDEN, response = ApiError.class),
//            @ApiResponse(code = 500, message = ApiConstants.INTERNAL_SERVER_ERROR_MESSAGE, response = ApiError.class) })
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<TiendaDto> findAll(
//            @RequestHeader(value = ApiConstants.MOCK_RESPONSE_HEADER, required = false) boolean mockResponse)
//            throws Exception {
//        return tiendaService.findAll();
//    }
//}
