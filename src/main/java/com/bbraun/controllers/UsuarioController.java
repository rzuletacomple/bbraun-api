package com.bbraun.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bbraun.dtos.ResponseDTO;
import com.bbraun.dtos.UsuarioDto;
import com.bbraun.service.impl.UsuarioServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * @author dchavarro & r
 * @version 1.0
 * 
 * Controlador que expone los servicios para trabajar con objeto(s) de tipo (Usuario). 
 */

@RestController
@RequestMapping("/v1/usuario")
@Tag(name = "Usuario - Controller", description = "Controller encargado de gestionar las operaciones del usuario.")
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequiredArgsConstructor
public class UsuarioController {
	
	
	/**
	 * Atributo que inyecta una instancia de la interfaz que contiene los métodos que seran usados en este controlador.
	 */
	private final UsuarioServiceImpl serviceUsuario;
	
	
	/**
	 * Método de tipo POST que permite validar un objeto de tipo (Usuario).
	 */
	@Operation(summary = "Operación que permite validar el usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se ha creado satisfactoriamente",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no puede ser entendida por el servidor debido a errores de sintaxis, el cliente no debe repetirla no sin antes hacer modificaciones",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Se presento una condición inesperada que impidió completar la petición",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDTO.class))}),
    })
	@PostMapping("/validar")
	public ResponseEntity<ResponseDTO> validarUsuario(@RequestBody UsuarioDto usuario){
		ResponseEntity<ResponseDTO>  response = this.serviceUsuario.auntenticar(usuario);
		return response;
	}
}
