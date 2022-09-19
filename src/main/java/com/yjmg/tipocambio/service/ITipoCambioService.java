package com.yjmg.tipocambio.service;

import com.yjmg.tipocambio.models.TipCambio;

import dtos.InputConversionMonedasDTO;
import dtos.InputTipoCambioDTO;
import dtos.OuputConversionDTO;
import dtos.OuputTipCambioDTO;

public interface ITipoCambioService extends ICrud<TipCambio, Integer> {
	
	//OuputTipoCambioDTO convertirTipoCambio(InputTipoCambioDTO content);
	//AuditResponse actualizarValorTC(InputActualizarValorTCDTO content);
//	String convertir(double valorDolar, String pais, double cantidadMoneda);

	OuputTipCambioDTO obtener(InputTipoCambioDTO content);
}
