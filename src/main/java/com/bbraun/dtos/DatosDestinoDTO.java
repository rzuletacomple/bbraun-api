package com.bbraun.dtos;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DatosDestinoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String tipoCliente;
	
	private ClienteDTO cliente;
	
	private SedeClienteDTO sedeCliente;

	private String usuarioCreacion;

	private Date fechaCreacion;

	private String usuarioModifica;

	private Date fechaModifica;

	private Boolean activo;
}
