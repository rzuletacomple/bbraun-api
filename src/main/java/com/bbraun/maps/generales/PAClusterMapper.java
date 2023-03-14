package com.bbraun.maps.generales;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bbraun.dtos.GenericoDTO;
import com.bbraun.entities.PaCluster;

@Mapper
public interface PAClusterMapper {
	
	PAClusterMapper INSTANCE = Mappers.getMapper(PAClusterMapper.class);
	
	GenericoDTO entityToDto(PaCluster entity);

	@InheritInverseConfiguration
	PaCluster dtoToEntity(GenericoDTO dto);
	
	List<GenericoDTO> beanListToDtoList(List<PaCluster> lista);
}
