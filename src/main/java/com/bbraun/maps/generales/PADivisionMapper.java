package com.bbraun.maps.generales;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bbraun.dtos.GenericoDTO;
import com.bbraun.entities.PaDivisionComercial;

@Mapper
public interface PADivisionMapper {
	
	PADivisionMapper INSTANCE = Mappers.getMapper(PADivisionMapper.class);
	
	GenericoDTO entityToDto(PaDivisionComercial entity);

	@InheritInverseConfiguration
	PaDivisionComercial dtoToEntity(GenericoDTO dto);
	
	List<GenericoDTO> beanListToDtoList(List<PaDivisionComercial> lista);
}
