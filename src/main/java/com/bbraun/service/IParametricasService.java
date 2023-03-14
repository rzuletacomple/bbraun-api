package com.bbraun.service;

import org.springframework.http.ResponseEntity;

import com.bbraun.dtos.ResponseDTO;

public interface IParametricasService {
	
	public ResponseEntity<ResponseDTO> obtenerRegiones();
	
	public ResponseEntity<ResponseDTO> obtenerClusteres();
	
	public ResponseEntity<ResponseDTO> obtenerCategorias();
	
	public ResponseEntity<ResponseDTO> obtenerDivisiones();
}
