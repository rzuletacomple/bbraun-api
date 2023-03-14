package com.bbraun.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bbraun.entities.Rol;


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
public interface RolRepository extends JpaRepository<Rol, Integer>{
	
	@Query(value = "SELECT R.id, R.nombre, R.codigo, R.usuario_creacion, R.fecha_creacion, R.usuario_modificacion, R.fecha_modificacion, R.activo FROM seguridad.usuario_rol UR INNER JOIN seguridad.rol R ON UR.id_rol =R.id where UR.id_usuario = ?1", nativeQuery = true)
	List<Rol> findRolPorUsuario(Integer id_usuario);
	
}
