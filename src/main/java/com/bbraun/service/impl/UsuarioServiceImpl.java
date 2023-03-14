package com.bbraun.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bbraun.dtos.ResponseDTO;
import com.bbraun.dtos.UsuarioDto;
import com.bbraun.entities.Rol;
import com.bbraun.entities.Usuario;
import com.bbraun.maps.generales.RolMapper;
import com.bbraun.maps.generales.UsuarioMapper;
import com.bbraun.repositories.RolRepository;
import com.bbraun.repositories.UsuarioRepository;
import com.bbraun.service.IUsuarioService;
import com.bbraun.utils.Constantes;
import com.bbraun.utils.EncriptarDesancriptar;
import com.bbraun.utils.Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dchavarro & r
 * @version 1.0
 * 
 *          Clase que implementa la interfaz de la lógica de negocio.
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements IUsuarioService{
	
	/**
	 * Inyección de la instancias que seran usadas en esta clase.
	 */
	private final EncriptarDesancriptar serviceEncriptacion;
	private final UsuarioRepository usuarioRepository;
	private final RolRepository rolRepository;
	
	
	/**
	 * Método que permite validar un objeto de tipo (Usuario).
	 */
	public ResponseEntity<ResponseDTO> auntenticar(UsuarioDto usuario) {
		log.info("Inicio metodo autenticar");
		ResponseDTO response = new ResponseDTO();
		if(Objects.nonNull(usuario) && Objects.nonNull(usuario.getNombre()) && Objects.nonNull(usuario.getPassword())
				&& usuario.getNombre().length()>0 && usuario.getPassword().length() >0) {
			Optional<Usuario> responseUsuario = this.usuarioRepository.findByNombreAndPassword(usuario.getNombre(),this.serviceEncriptacion.encriptar( usuario.getPassword()));
			if(responseUsuario.isPresent()) {
				log.info("responseUsuario encontrado");
				List<Rol> lstRol =this.rolRepository.findRolPorUsuario(responseUsuario.get().getId());
				UsuarioDto usuarioResponse = UsuarioMapper.INSTANCE.entityToDto(responseUsuario.get());
				usuarioResponse.setLstRol(RolMapper.INSTANCE.beanListToDtoList(lstRol));
				
				response = Utils.mapearRespuesta(Constantes.AUTENTACION_EXITOSA, HttpStatus.OK.value(), usuarioResponse);
			}else {
				response = Utils.mapearRespuesta(Constantes.POR_FAVOR_VERIFICAR_DATOS_INCORRECTO, HttpStatus.BAD_REQUEST.value());
			}
		}else {
			response = Utils.mapearRespuesta(Constantes.MENSAJE_VALIDACION_DATOS, HttpStatus.BAD_REQUEST.value());
		}
		log.info("Fin metodo autenticar");
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}


}
