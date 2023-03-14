package com.bbraun.maps.generales;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.bbraun.dtos.UsuarioDto;
import com.bbraun.entities.Usuario;


/**
 * @author dchavarro & r
 * @version 1.0
 * 
 *          Clase Mapper de tipo (Usuario) que permite mapear los datos un objeto de tipo 
 *          (UsuarioDTO) a uno de tipo (Usuario) o viceversa.
 *          
 *          Esto ayuda a mantener el código limpio y mantenible, ya que separa las 
 *          preocupaciones de las diferentes capas de la aplicación.
 * 
 */

@Mapper
public interface UsuarioMapper {
	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

	@Mapping(target = "password", ignore = true)
	@Mapping(target = "usuarioCreacion", ignore = true)
	@Mapping(target = "fechaCreacion", ignore = true)
	@Mapping(target = "usuarioModifica", ignore = true)
	@Mapping(target = "fechaModifica", ignore = true)
	@Mapping(target = "activo", ignore = true)
	UsuarioDto entityToDto(Usuario entity);

	@InheritInverseConfiguration
	Usuario dtoToEntity(UsuarioDto dto);
}

