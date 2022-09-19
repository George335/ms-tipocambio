package com.yjmg.tipocambio.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yjmg.tipocambio.models.TipCambio;

@Repository
public interface ITipoCambioRepo extends JpaRepository<TipCambio, Integer> {

	@Query(
			  value = "SELECT * FROM tipo_cambio tc WHERE tc.pais_origen = ?1 and tc.pais_destino = ?2", 
			  nativeQuery = true)
			TipCambio obtener(String codEmp, String codBarco);
	
}
