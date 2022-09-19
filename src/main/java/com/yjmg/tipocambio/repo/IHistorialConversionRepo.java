package com.yjmg.tipocambio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yjmg.tipocambio.models.HistorialConversion;
import com.yjmg.tipocambio.models.UsuarioAcceso;

public interface IHistorialConversionRepo extends JpaRepository<HistorialConversion, Integer> {

	@Query(
			  value = "SELECT * FROM usuario_acceso ua WHERE ua.nombreUsuario = ?1", 
			  nativeQuery = true)
	UsuarioAcceso obtenerUsuarioAcceso(String nombreUsuario);
	
}
