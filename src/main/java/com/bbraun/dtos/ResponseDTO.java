package com.bbraun.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dchavarro & r
 * @version 1.0
 * 
 * Clase DTO que permite encapsular los datos de un objeto de tipo (Response).
 * Este DTO tiene varias ventajas como: 
 * Bajo acoplamiento entre las capaz de la aplicación
 * Optimización de la transferencia de datos.
 * Seguridad.
 * 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO {
	
	private Integer statusCode;
	private String message;
	private Object  objectResponse;
	
}