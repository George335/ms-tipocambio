package com.yjmg.tipocambio.service;

import com.yjmg.tipocambio.models.TipCambio;

import dtos.InputConversionMonedasDTO;
import dtos.OuputConversionDTO;

public interface IConversionService extends ICrud<TipCambio, Integer> {
	OuputConversionDTO convertir(InputConversionMonedasDTO content);
}
