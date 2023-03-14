package com.bbraun.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bbraun.dtos.ResponseDTO;
import com.bbraun.maps.generales.PACategoriaMapper;
import com.bbraun.maps.generales.PAClusterMapper;
import com.bbraun.maps.generales.PADivisionMapper;
import com.bbraun.maps.generales.PARegionMapper;
import com.bbraun.repositories.PACategoriaRepository;
import com.bbraun.repositories.PAClusterRepository;
import com.bbraun.repositories.PADivisionesRepository;
import com.bbraun.repositories.PARegionRepository;
import com.bbraun.service.IParametricasService;
import com.bbraun.utils.Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParametricasServiceImpl implements IParametricasService {
	
	private final PARegionRepository regionRepository;
	
	private final PACategoriaRepository categoriaRepository;
	
	private final PAClusterRepository clusterRepository;
	
	private final PADivisionesRepository divisionRepository;
	
	public ResponseEntity<ResponseDTO> obtenerRegiones() {
		return new ResponseEntity<ResponseDTO>(Utils.mapearRespuesta(HttpStatus.OK.name(), HttpStatus.OK.value(),
				PARegionMapper.INSTANCE.beanListToDtoList(this.regionRepository.findAll())), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> obtenerClusteres() {
		return new ResponseEntity<ResponseDTO>(Utils.mapearRespuesta(HttpStatus.OK.name(), HttpStatus.OK.value(),
				PAClusterMapper.INSTANCE.beanListToDtoList(this.clusterRepository.findAll())), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> obtenerCategorias() {
		return new ResponseEntity<ResponseDTO>(Utils.mapearRespuesta(HttpStatus.OK.name(), HttpStatus.OK.value(),
				PACategoriaMapper.INSTANCE.beanListToDtoList(this.categoriaRepository.findAll())), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> obtenerDivisiones() {
		return new ResponseEntity<ResponseDTO>(Utils.mapearRespuesta(HttpStatus.OK.name(), HttpStatus.OK.value(),
				PADivisionMapper.INSTANCE.beanListToDtoList(this.divisionRepository.findAll())), HttpStatus.OK);
	}

}
