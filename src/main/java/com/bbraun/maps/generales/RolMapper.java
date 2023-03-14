package com.bbraun.maps.generales;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bbraun.dtos.RolDto;
import com.bbraun.entities.Rol;


/**
 * @author dchavarro & r
 * @version 1.0
 * 
 *          Clase Mapper de tipo (Rol) que permite mapear los datos un objeto de tipo 
 *          (RolDTO) a uno de tipo (Rol) o viceversa.
 *          
 *          Esto ayuda a mantener el código limpio y mantenible, ya que separa las 
 *          preocupaciones de las diferentes capas de la aplicación.
 * 
 */

@Mapper
public interface RolMapper {
	RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

	RolDto entityToDto(Rol entity);

	@InheritInverseConfiguration
	Rol dtoToEntity(RolDto dto);
	
	List<RolDto> beanListToDtoList(List<Rol> lista);
}
