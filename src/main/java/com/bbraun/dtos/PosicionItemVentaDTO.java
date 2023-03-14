package com.bbraun.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PosicionItemVentaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer posicion;
	
	private Float cantidadNetoRecaudo;
	
	private BigDecimal valorNetoRecaudo;
	
	private Float cantidadNetoVenta;
	
	private BigDecimal valorNetoVenta;
	
	private FacturaDTO factura;
	
	private ProductoDTO producto;
	
	private GrupoProductoSbaDTO grupoProductoSba;
	
	private DatosDestinoDTO datosDestino;
	
	private ClusterCanalCargoDTO clusterCanal;

	private String usuarioCreacion;

	private Date fechaCreacion;

	private String usuarioModifica;

	private Date fechaModifica;

	private Boolean activo;
}
