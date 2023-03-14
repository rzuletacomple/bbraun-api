package com.bbraun.maps.generales;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bbraun.dtos.GenericoDTO;
import com.bbraun.entities.PaCategoriaCliente;

@Mapper
public interface PACategoriaMapper {
	
	PACategoriaMapper INSTANCE = Mappers.getMapper(PACategoriaMapper.class);
	
	GenericoDTO entityToDto(PaCategoriaCliente entity);

	@InheritInverseConfiguration
	PaCategoriaCliente dtoToEntity(GenericoDTO dto);
	
	List<GenericoDTO> beanListToDtoList(List<PaCategoriaCliente> lista);
}
