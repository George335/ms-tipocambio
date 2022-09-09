package com.yjmg.tipocambio.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjmg.tipocambio.models.TipoCambio;
import com.yjmg.tipocambio.repo.ITipoCambioRepo;
import com.yjmg.tipocambio.service.ITipoCambioService;

import dtos.AuditResponse;
import dtos.InputActualizarValorTCDTO;
import dtos.InputTipoCambioDTO;
import dtos.OuputTipoCambioDTO;

@Service
public class ITipoCambioImpl implements ITipoCambioService {

	@Autowired
	private ITipoCambioRepo repo;
	
	@Override
	public TipoCambio registrar(TipoCambio obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoCambio modificar(TipoCambio obj) {
		return repo.save(obj);
	}

	@Override
	public List<TipoCambio> listar() {
		return repo.findAll();
	}

	@Override
	public TipoCambio listarPorId(Integer id) {
		Optional<TipoCambio> embarcacionContacto = repo.findById(id);

		return embarcacionContacto.isPresent() ? embarcacionContacto.get() : new TipoCambio();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public OuputTipoCambioDTO convertirTipoCambio(InputTipoCambioDTO content) {
		
		OuputTipoCambioDTO ouputTipoCambioDTO = new OuputTipoCambioDTO();
		
		List<TipoCambio> result = (List<TipoCambio>) repo.findAll();
		List<TipoCambio> resultFilter = result.stream()
                .filter(t -> t.getAbreviado().equals(content.getMonedaDestino()))
                .collect(Collectors.toList());
		
		for (TipoCambio tipoCambio : resultFilter) {
			
			ouputTipoCambioDTO.setMonto(content.getMonto());
			ouputTipoCambioDTO.setResultado(content.getMonto()*tipoCambio.getValor()+" "+tipoCambio.getNombre());
			ouputTipoCambioDTO.setMonedaOrigen(content.getMonedaOrigen());
			ouputTipoCambioDTO.setMonedaDestino(content.getMonedaDestino());
			ouputTipoCambioDTO.setTipoCambio(tipoCambio.getValor());
		}

		return ouputTipoCambioDTO;
	}

	@Override
	public AuditResponse actualizarValorTC(InputActualizarValorTCDTO content) {
		
		AuditResponse response = new AuditResponse();
		response = setAuditResponseIDF("/tipos_cambio/actualizar", "0", "Actualizado correctamente", true);
		
		try {
			
			List<TipoCambio> result = (List<TipoCambio>) repo.findAll();
			List<TipoCambio> resultFilter = result.stream()
	                .filter(t -> t.getAbreviado().equals(content.getAbreviado()))
	                .collect(Collectors.toList());
			
			for (TipoCambio tipoCambio : resultFilter) {
				tipoCambio.setValor(content.getNuevoValor());
				repo.save(tipoCambio);
			}
			
		} catch (Exception e) {
			response = setAuditResponseIDF("/tipos_cambio/actualizar", "1", e.getMessage(), false);
		}
		
		
		return response;
	}
	
	public static AuditResponse setAuditResponseIDF(String metodo, String codRespuesta, String mensaje, boolean status) {
		String FORMAT_DATE_TIME_ZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
		AuditResponse auditResponse = new AuditResponse();
		auditResponse.setMetodo(metodo);
		auditResponse.setFecha(parseDateFormat(FORMAT_DATE_TIME_ZONE));
		auditResponse.setCodigoRespuesta(codRespuesta);
		auditResponse.setDescripcionRespuesta(mensaje);
		auditResponse.setStatus(status);
		return auditResponse;
	}
	
	public static String parseDateFormat(String dateformat) {
		String TIME_ZONE_LIMA = "America/Lima";
        DateFormat sdf = new SimpleDateFormat(dateformat);
        sdf.setTimeZone(TimeZone.getTimeZone(TIME_ZONE_LIMA));
        return sdf.format(new Date());
    }

}
