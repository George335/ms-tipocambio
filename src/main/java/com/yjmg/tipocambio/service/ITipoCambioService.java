package com.yjmg.tipocambio.service;

import com.yjmg.tipocambio.models.TipoCambio;

import dtos.AuditResponse;
import dtos.InputActualizarValorTCDTO;
import dtos.InputTipoCambioDTO;
import dtos.OuputTipoCambioDTO;

public interface ITipoCambioService extends ICrud<TipoCambio, Integer> {
	
	OuputTipoCambioDTO convertirTipoCambio(InputTipoCambioDTO content);
	AuditResponse actualizarValorTC(InputActualizarValorTCDTO content);
}
