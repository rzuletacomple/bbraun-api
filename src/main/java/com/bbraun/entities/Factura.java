package com.bbraun.entities;

import java.io.Serializable;
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
@Table(name = "factura", schema = "public")
@Where(clause = "activo = true")
public class Factura implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Basic(optional = false)
	@Column(name = "numero_factura")
	private String numero;
	
	@Basic(optional = true)
	@Column(name = "fecha_factura")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Basic(optional = false)
	@Column(name = "domestic_export")
	private String domesticExport;
	
	@Basic(optional = false)
	@Column(name = "distribucion")
	private String distribucion;
	
	@Basic(optional = true)
	@Column(name = "fecha_final")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinal;
	
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	@ManyToOne
	private Cliente cliente;
	
	@JoinColumn(name = "id_tipo_factura", referencedColumnName = "id")
	@ManyToOne
	private PaTipoFactura tipoFactura;
	
	@JoinColumn(name = "id_tipo_movimiento", referencedColumnName = "id")
	@ManyToOne
	private PaTipoMovimientoFactura tipoMovimiento;
	
	@JoinColumn(name = "id_presupuesto_anual", referencedColumnName = "id")
	@ManyToOne
	private PaPresupuestoAnual presupuestoAnual;

	@Basic(optional = true)
	@Column(name = "usuario_creacion", insertable = true, updatable = false)
	private String usuarioCreacion;

	@Basic(optional = true)
	@Column(name = "fecha_creacion",  insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date fechaCreacion;

	@Basic(optional = true)
	@Column(name = "usuario_modificacion",  updatable = true,insertable = false)
	private String usuarioModifica;

	@Basic(optional = true)
	@Column(name = "fecha_modificacion" ,  updatable = true,insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date fechaModifica;

	@Basic(optional = true)
	@Column(name = "activo", insertable = true, updatable = false)
	private Boolean activo;
}
