package com.yjmg.tipocambio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yjmg.tipocambio.models.UsuarioAcceso;

public interface IUsuarioRepo extends JpaRepository<UsuarioAcceso, Integer>{

	@Query(value = "select * from usuario_acceso where nombre_usuario=:IN_USUARIO", nativeQuery = true)
	UsuarioAcceso obtenerUsuario(@Param("IN_USUARIO") String usuario);
}
