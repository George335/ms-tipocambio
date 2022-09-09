package com.yjmg.tipocambio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yjmg.tipocambio.models.TipoCambio;

@Repository
public interface ITipoCambioRepo extends JpaRepository<TipoCambio, Integer> {

}
