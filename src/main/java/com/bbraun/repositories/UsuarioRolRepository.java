package com.bbraun.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bbraun.entities.UsuarioRol;
import com.bbraun.entities.UsuarioRolPK;

/**
 * @author dchavarro & r
 * @version 1.0
 * 
 *          Interfaz que permite interactuar con una base de datos gracias a los metodos que esta posee.
 *          
 *          Esta interfaz ya tiene por defecto los métodos mas comunes a la hora de intercambiar datos con una BD,
 *          esto gracias a que extiende de la interfaz JpaRepository.
 *          
 *          Esta interfaz tambien posee metodos que permiten intercambiar datos de una manera especifica.
 *          
 * 
 */

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, UsuarioRolPK>{
	
	List<UsuarioRol> findByUsuarioRol_IdUsuario(Integer idUsuario);
	
}
