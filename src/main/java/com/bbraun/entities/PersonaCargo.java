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
public class PersonaCargo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Basic(optional = false)
	@Column(name = "codigo")
	private String codigo;
	
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	
	@JoinColumn(name = "id_persona", referencedColumnName = "id")
	@ManyToOne
	private Persona persona;
	
	@JoinColumn(name = "id_cargo", referencedColumnName = "id")
	@ManyToOne
	private PaCargo cargo;
	
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
