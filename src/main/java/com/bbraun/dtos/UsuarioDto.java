package com.bbraun.dtos;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dchavarro & r
 * @version 1.0
 * 
 * Clase DTO que permite encapsular los datos de un objeto de tipo (Usuario).
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
public class UsuarioDto {
	
	private Integer id;
	private String nombre;
	private String password;
	private String usuarioCreacion;
	private Date fechaCreacion;
	private String usuarioModifica;
	private Date fechaModifica;
	private Boolean activo;
	private List<RolDto> lstRol;
	private String token;
}
