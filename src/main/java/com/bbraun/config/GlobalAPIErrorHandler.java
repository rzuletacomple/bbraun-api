package com.bbraun.config;

import com.bbraun.dtos.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * @author dchavarro & r
 * @version 1.0
 *
 *          Clase que funciona como un parche el cual puede manejar posibles excepciones cuando se ejecuta un 
 *          servicio.
 *
 */

@RequiredArgsConstructor
@ControllerAdvice
@Slf4j
public class GlobalAPIErrorHandler extends ResponseEntityExceptionHandler {

	/**
	 * Método que valida estas posibles excepciones {MethodArgumentTypeMismatchException.class, 
	 * JsonProcessingException.class}
	 */
	@ExceptionHandler(value = { MethodArgumentTypeMismatchException.class, JsonProcessingException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ResponseDTO> errorPeticion(RuntimeException ex) {
		log.error("{}", ex);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseDTO.builder().objectResponse(ex.getMessage()).statusCode(HttpStatus.BAD_REQUEST.value())
						.message("La petición no puede ser entendida por el servidor debido a errores de sintaxis")
						.build());
	}

	/**
	 * Método que valida estas posibles excepciones {NoSuchElementException.class}
	 */
	@ExceptionHandler(value = { NoSuchElementException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ResponseDTO> errorNoEncontrado(RuntimeException ex) {
		log.error("{}", ex);
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseDTO.builder().objectResponse(ex.getMessage()).statusCode(HttpStatus.NOT_FOUND.value())
						.message("El recurso solicitado no pudo ser encontrado").build());
	}

	/**
	 * Método que valida estas posibles excepciones {Exception.class, IOException.class }
	 */
	@ExceptionHandler({ Exception.class, IOException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ResponseDTO> internalError(Exception ex) {
		log.error("{}", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ResponseDTO.builder().objectResponse(ex.getMessage())
						.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.message("Se presentó una condición inesperada que impidió completar la petición").build());
	}

	/**
	 * Método que valida estas posibles excepciones {HttpStatus.BAD_REQUEST}
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error("{}", ex);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseDTO.builder().objectResponse(ex.getMessage()).statusCode(HttpStatus.BAD_REQUEST.value())
						.message("La petición no puede ser entendida por el servidor debido a errores de sintaxis")
						.build());
	}

	/**
	 * Método que valida estas posibles excepciones {ServiceException.class}
	 */
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ResponseDTO> servicerError(ServiceException ex) {
		log.error("{}", ex);
		return ResponseEntity.status(ex.getStatus()).body(ResponseDTO.builder().statusCode(ex.getStatus())
				.objectResponse(ex.getInfo()).message(ex.getMessage()).build());
	}

}