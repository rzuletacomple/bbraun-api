package com.bbraun.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posicion_item_venta", schema = "public")
@Where(clause = "activo = true")
public class PosicionItemVenta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Basic(optional = false)
	@Column(name = "posicion_item_venta")
	private Integer posicion;
	
	@Basic(optional = false)
	@Column(name = "cantidad_neto_recaudo")
	private Float cantidadNetoRecaudo;
	
	@Basic(optional = false)
	@Column(name = "valor_neto_recaudo")
	private BigDecimal valorNetoRecaudo;
	
	@Basic(optional = false)
	@Column(name = "cantidad_neto_venta")
	private Float cantidadNetoVenta;
	
	@Basic(optional = false)
	@Column(name = "valor_neto_venta")
	private BigDecimal valorNetoVenta;
	
	@JoinColumn(name = "id_factura", referencedColumnName = "id")
	@ManyToOne
	private Factura factura;
	
	@JoinColumn(name = "id_producto", referencedColumnName = "id")
	@ManyToOne
	private Producto producto;
	
	@JoinColumn(name = "id_grupo_producto_sba", referencedColumnName = "id")
	@ManyToOne
	private GrupoProductoSba grupoProductoSba;
	
	@JoinColumn(name = "id_datos_destino", referencedColumnName = "id")
	@ManyToOne
	private DatosDestino datosDestino;
	
	@JoinColumn(name = "id_cluster_final", referencedColumnName = "id")
	@ManyToOne
	private ClusterCanalCargo clusterCanal;

	@Basic(optional = true)
	@Column(name = "usuario_creacion", insertable = true, updatable = false)
	private String usuarioCreacion;

	@Basic(optional = true)
	@Column(name = "fecha_creacion",  insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date fechaCreacion;

	@Basic(optional = true)
	@Column(name = "usuario_modifica",  updatable = true,insertable = false)
	private String usuarioModifica;

	@Basic(optional = true)
	@Column(name = "fecha_modifica" ,  updatable = true,insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date fechaModifica;

	@Basic(optional = true)
	@Column(name = "activo", insertable = true, updatable = false)
	private Boolean activo;
}
