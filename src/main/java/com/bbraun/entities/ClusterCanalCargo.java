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
@Table(name = "persona_cargo", schema = "public")
@Where(clause = "activo = true")
public class ClusterCanalCargo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@JoinColumn(name = "id_cluster", referencedColumnName = "id")
	@ManyToOne
	private PaCluster cluster;
	
	@JoinColumn(name = "id_canal", referencedColumnName = "id")
	@ManyToOne
	private PaCanal canal;
	
	@JoinColumn(name = "id_persona_vendedor", referencedColumnName = "id")
	@ManyToOne
	private PersonaCargo personaCargo;
	
	@JoinColumn(name = "id_grupo_producto", referencedColumnName = "id")
	@ManyToOne
	private GrupoProducto grupoProducto;
	
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
