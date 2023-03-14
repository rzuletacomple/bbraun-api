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
public class FacturaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String numero;
	
	private Date fecha;
	
	private String domesticExport;
	
	private String distribucion;
	
	private Date fechaFinal;
	
	private ClienteDTO cliente;
	
	private GenericoDTO tipoFactura;
	
	private GenericoDTO tipoMovimiento;
	
	private PaPresupuestoAnualDTO presupuestoAnual;

	private String usuarioCreacion;

	private Date fechaCreacion;

	private String usuarioModifica;

	private Date fechaModifica;

	private Boolean activo;
}
