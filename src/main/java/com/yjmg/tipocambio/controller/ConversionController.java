package com.yjmg.tipocambio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjmg.tipocambio.exception.ModeloNotFoundException;
import com.yjmg.tipocambio.service.IConversionService;

import dtos.InputConversionMonedasDTO;
import dtos.OuputConversionDTO;

@RestController
@RequestMapping("/tipos_cambio")
public class ConversionController {
	
	@Autowired
	private IConversionService service;

	@PreAuthorize("@restAuthService.hasAccess('conversion')")
	@PostMapping("/conversion")
	public ResponseEntity<OuputConversionDTO> conversion(
			@RequestBody InputConversionMonedasDTO content) {
		
		OuputConversionDTO response = null;
		try {
			response = service.convertir(content);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ModeloNotFoundException("Error: " + e.getMessage());
		}
		
		return new ResponseEntity<OuputConversionDTO>(response, HttpStatus.OK);
	}
	
}
