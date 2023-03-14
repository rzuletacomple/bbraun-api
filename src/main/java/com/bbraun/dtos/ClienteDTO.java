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
public class ClienteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String codigo;
	
	private String interno;
	
	private String razonSocial;
	
	private String nit;
	
	private ClusterCanalCargoDTO clusterCanal;
	
	private GenericoDTO subTipoCliente;
	
	private UbicacionDTO ubicacion;

	private String usuarioCreacion;

	private Date fechaCreacion;

	private String usuarioModifica;

	private Date fechaModifica;

	private Boolean activo;
}
