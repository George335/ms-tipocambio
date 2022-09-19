package com.yjmg.tipocambio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.yjmg.tipocambio.models.HistorialConversion;
import com.yjmg.tipocambio.models.TipCambio;
import com.yjmg.tipocambio.models.UsuarioAcceso;
import com.yjmg.tipocambio.repo.IHistorialConversionRepo;
import com.yjmg.tipocambio.repo.ITipoCambioRepo;
import com.yjmg.tipocambio.service.IConversionService;

import dtos.InputConversionMonedasDTO;
import dtos.OuputConversionDTO;

//@Service(value = "conversionService")
@Service
public class ConversionImpl implements IConversionService {

	@Autowired
	private ITipoCambioRepo tipoCambioRepo;
	
	@Autowired
	private IHistorialConversionRepo historialConversionRepo;
		
	@Override
	public TipCambio registrar(TipCambio obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipCambio modificar(TipCambio obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipCambio> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipCambio listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OuputConversionDTO convertir(InputConversionMonedasDTO content) {
		TipCambio tipCambio = (TipCambio) tipoCambioRepo.obtener(content.getMonedaOrigen(), content.getMonedaDestino());
		OuputConversionDTO dto = new OuputConversionDTO();
		try {
			dto.setMontoResultado(content.getMonto()*tipCambio.getMontoDestino()+" "+content.getMonedaDestino());
			dto.setTipoCambio("1 "+tipCambio.getPaisOrigen()+" equivale a "+tipCambio.getMontoDestino()+" "+tipCambio.getPaisDestino());
		
			registrarHistorialConversion(dto, content);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}
	
	private void registrarHistorialConversion(OuputConversionDTO dto, InputConversionMonedasDTO content) {
		String montoConvertir = content.getMonto()+"";
		String monedaOrigen = content.getMonedaOrigen();
		String monedaDestino = content.getMonedaDestino();
		String montoConvertido = dto.getMontoResultado();
		String tipoCambio = dto.getTipoCambio();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				
		historialConversionRepo.save(new HistorialConversion(authentication.getName(), montoConvertir, monedaOrigen, 
				monedaDestino, montoConvertido, tipoCambio));

	}

}
