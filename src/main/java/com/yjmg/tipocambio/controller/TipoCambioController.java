package com.yjmg.tipocambio.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.yjmg.tipocambio.exception.ModeloNotFoundException;
import com.yjmg.tipocambio.models.TipCambio;
import com.yjmg.tipocambio.models.TipoCambio;
import com.yjmg.tipocambio.service.ITipoCambioService;
import com.yjmg.tipocambio.util.Utilitario;

import dtos.AuditResponse;
import dtos.InputActualizarValorTCDTO;
import dtos.InputTipoCambioDTO;
import dtos.OuputTipCambioDTO;
import dtos.OuputTipoCambioDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tipos_cambio")
public class TipoCambioController {

	@Autowired
	private ITipoCambioService service;

	@Autowired
	private Environment env;
	
	@PreAuthorize("@restAuthService.hasAccess('registrarTipoCambio')")
	@PostMapping("/registrar")
	public ResponseEntity<AuditResponse> registrar(
			@RequestBody TipCambio content) {
		
		AuditResponse response = new AuditResponse();
		response = Utilitario.setAuditResponseIDF("/tipos_cambio/registrar", "0", "Registrado correctamente.", true);

		try {
			service.registrar(content);
		} catch (Exception e) {
			response = Utilitario.setAuditResponseIDF("/tipos_cambio/registrar", "1", e.getMessage(), false);
		}
		
		return new ResponseEntity<AuditResponse>(response, HttpStatus.OK);
	}
	
	@PreAuthorize("@restAuthService.hasAccess('actualizarTipoCambio')")
	@PostMapping("/actualizar")
	public ResponseEntity<AuditResponse> actualizar(
			@RequestBody TipCambio content) {
		
		AuditResponse response = new AuditResponse();
		response = Utilitario.setAuditResponseIDF("/tipos_cambio/actualizar", "0", "Actualizado correctamente.", true);

		try {
			service.modificar(content);
		} catch (Exception e) {
			response = Utilitario.setAuditResponseIDF("/tipos_cambio/actualizar", "1", e.getMessage(), false);
		}
		
		return new ResponseEntity<AuditResponse>(response, HttpStatus.OK);
	}
	
	/*@PostMapping("/obtener")
	public ResponseEntity<OuputTipCambioDTO> obtener(
			@RequestBody InputTipoCambioDTO content) {
		
		OuputTipCambioDTO tipCambio = null;
		try {
			tipCambio = service.obtener(content);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ModeloNotFoundException("Error: " + e.getMessage());
		}
		
		return new ResponseEntity<OuputTipCambioDTO>(tipCambio, HttpStatus.OK);
	}*/
	
	@PreAuthorize("@restAuthService.hasAccess('obtenerTipoCambio')")
	@PostMapping("/obtener")
	public Mono<ResponseEntity<OuputTipCambioDTO>> obtener(@RequestBody InputTipoCambioDTO content){
	
		OuputTipCambioDTO tipCambio = null;
		try {
			tipCambio = service.obtener(content);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ModeloNotFoundException("Error: " + e.getMessage());
		}

		return Mono.just(new ResponseEntity<OuputTipCambioDTO>(tipCambio, HttpStatus.OK));
	}

	/*
	@PutMapping("/actualizar")
	public ResponseEntity<AuditResponse> actualizar(
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
*/
	
	@GetMapping("/listar")
	public ResponseEntity<List<TipCambio>> listar() {

		List<TipCambio> response = new ArrayList<>();

		try {

			response = service.listar();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			throw new ModeloNotFoundException("Error: " + e.getMessage());
		}

		return new ResponseEntity<List<TipCambio>>(response, HttpStatus.OK);
		
	}

	//@PreAuthorize("@restAuthService.hasAccess('convertirTipoCambio')")
	/*@PostMapping("/convertir_tipo_cambio")
	public ResponseEntity<OuputTipoCambioDTO> convertirTipoCambio(
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
*/
	
/*	
	//@PreAuthorize("@restAuthService.hasAccess('convertir')")
	@PostMapping("/convertir")
	public ResponseEntity<String> convertir(
			@RequestBody InputTipoCambioDTO content) {

		Gson gson = new Gson();
		System.out.println(gson.toJson(content));
		String rpt = "";
		try {

			switch (content.getMonedaOrigen()) {
			case "":
				
				break;

			default:
				break;
			}
			
			rpt = service.convertir(content);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			throw new ModeloNotFoundException("Error: " + e.getMessage());
		}

		return new ResponseEntity<String>(registro, HttpStatus.OK);
	}
*/
	
	

}
