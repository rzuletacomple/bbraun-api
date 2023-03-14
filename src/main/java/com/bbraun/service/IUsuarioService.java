package com.bbraun.service;

import org.springframework.http.ResponseEntity;

import com.bbraun.dtos.ResponseDTO;
import com.bbraun.dtos.UsuarioDto;

/**
 * @author dchavarro & r
 * @version 1.0
 * 
 *          Esta interfaz es la capa intermedia entre la capa de presentación y la capa
 *          de acceso a datos. Esta oculta los detalles de implementación de la capa de 
 *          acceso a datos.          
 * 
 */

public interface IUsuarioService {
	
	public ResponseEntity<ResponseDTO> auntenticar(final UsuarioDto usuario);
	
}
