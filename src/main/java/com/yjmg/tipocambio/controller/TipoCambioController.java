package com.yjmg.tipocambio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.yjmg.tipocambio.exception.ModeloNotFoundException;
import com.yjmg.tipocambio.models.TipoCambio;
import com.yjmg.tipocambio.service.ITipoCambioService;

import dtos.AuditResponse;
import dtos.InputActualizarValorTCDTO;
import dtos.InputTipoCambioDTO;
import dtos.OuputTipoCambioDTO;

@RestController
@RequestMapping("/tipos_cambio")
public class TipoCambioController {

	@Autowired
	private ITipoCambioService service;

	@Autowired
	private Environment env;

	@PutMapping("/actualizar")
	public ResponseEntity<AuditResponse> actualizarOperacionInsumo(
			@RequestBody InputActualizarValorTCDTO content) { 

		Gson gson = new Gson();
		String json = gson.toJson(content);
		System.out.println("JSON: " + json);

		AuditResponse respuesta = new AuditResponse();

		try {

			respuesta = service.actualizarValorTC(content);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			// respuesta.setEstado("-1");
			// respuesta.setDescripcion("Error: " + e.getMessage());
			throw new ModeloNotFoundException("Error: " + e.getMessage());
		}

		return new ResponseEntity<AuditResponse>(respuesta, HttpStatus.CREATED);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<TipoCambio>> listarOperacionInsumo() {

		List<TipoCambio> response = new ArrayList<>();

		try {

			response = service.listar();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			throw new ModeloNotFoundException("Error: " + e.getMessage());
		}

		return new ResponseEntity<List<TipoCambio>>(response, HttpStatus.OK);
		
	}

	@PostMapping("/convertir_tipo_cambio")
	public ResponseEntity<OuputTipoCambioDTO> listarPorIdOperacionInsumo(
			@RequestBody InputTipoCambioDTO content) {

		Gson gson = new Gson();
		System.out.println(gson.toJson(content));
		OuputTipoCambioDTO registro = new OuputTipoCambioDTO();
		try {

			registro = service.convertirTipoCambio(content);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			throw new ModeloNotFoundException("Error: " + e.getMessage());
		}

		return new ResponseEntity<OuputTipoCambioDTO>(registro, HttpStatus.OK);
	}

}
