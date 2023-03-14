package com.bbraun.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bbraun.dtos.ResponseDTO;
import com.bbraun.service.impl.ParametricasServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/parametricas")
@Tag(name = "Parametricas - Controller", description = "Controller encargado de obtener todas las listas parametricas.")
@CrossOrigin(origins = "http://localhost:4200/", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequiredArgsConstructor
public class ParametricasController {
	
	
	private final ParametricasServiceImpl serviceParametricas;
	
	@Operation(summary = "Operación que permite consultar las regiones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se ha obtenido satisfactoriamente",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no puede ser entendida por el servidor debido a errores de sintaxis, el cliente no debe repetirla no sin antes hacer modificaciones",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presento una condición inesperada que impidió completar la petición",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
	@GetMapping("/regiones")
	public ResponseEntity<ResponseDTO> obtenerRegiones(){
		return this.serviceParametricas.obtenerRegiones();
	}
	
	@Operation(summary = "Operación que permite consultar las categorias cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se ha obtenido satisfactoriamente",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no puede ser entendida por el servidor debido a errores de sintaxis, el cliente no debe repetirla no sin antes hacer modificaciones",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presento una condición inesperada que impidió completar la petición",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
	@GetMapping("/categorias")
	public ResponseEntity<ResponseDTO> obtenerCategorias(){
		return this.serviceParametricas.obtenerCategorias();
	}
	
	@Operation(summary = "Operación que permite consultar los clusteres")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se ha obtenido satisfactoriamente",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no puede ser entendida por el servidor debido a errores de sintaxis, el cliente no debe repetirla no sin antes hacer modificaciones",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presento una condición inesperada que impidió completar la petición",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
	@GetMapping("/clusteres")
	public ResponseEntity<ResponseDTO> obtenerClusteres(){
		return this.serviceParametricas.obtenerClusteres();
	}
	
	@Operation(summary = "Operación que permite consultar las divisiones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se ha obtenido satisfactoriamente",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no puede ser entendida por el servidor debido a errores de sintaxis, el cliente no debe repetirla no sin antes hacer modificaciones",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presento una condición inesperada que impidió completar la petición",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
	@GetMapping("/divisiones")
	public ResponseEntity<ResponseDTO> obtenerDivisiones(){
		return this.serviceParametricas.obtenerDivisiones();
	}
	
}
