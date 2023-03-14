package com.bbraun.maps.generales;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bbraun.dtos.GenericoDTO;
import com.bbraun.entities.PaRegion;

@Mapper
public interface PARegionMapper {
	
	PARegionMapper INSTANCE = Mappers.getMapper(PARegionMapper.class);
	
	GenericoDTO entityToDto(PaRegion entity);

	@InheritInverseConfiguration
	PaRegion dtoToEntity(GenericoDTO dto);
	
	List<GenericoDTO> beanListToDtoList(List<PaRegion> lista);
}
