package com.bbraun.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author dchavarro & r
 * @version 1.0
 * 
 *          Clase Entity de tipo (UsuarioRolPK) que representa un registro de
 *          la BD. Cada instancia de esta entidad representa un registro de la
 *          BD. Cada atributo representa una columna de la BD. Los métodos de
 *          esta clase se usan para manipular los datos. (Anotación @Data)
 * 
 *          Implementa la interfaz (Serializable) la cual permite convertir un
 *          objeto (instancia) en ceros y uno, para de esta manera pueda ser
 *          transportado, almacenado y reconstruido en otra plataforma o
 *          sistema.
 * 
 */

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
@Where(clause = "activo = true")
public class UsuarioRolPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "id_rol", nullable = false)
    private Integer idRol;
    
}
