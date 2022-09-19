package com.yjmg.tipocambio.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjmg.tipocambio.models.UsuarioAcceso;
import com.yjmg.tipocambio.service.IUsuarioAccesoService;
import com.yjmg.tipocambio.util.Utilitario;

import dtos.AuditResponse;
import dtos.InputUsuarioAcceso;



@RestController
@RequestMapping("/usuarios")
public class UsuarioAccesoController {

	@Autowired
	private IUsuarioAccesoService service;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@PostMapping("/registrar_token")
	public AuditResponse registrar_token(@RequestBody InputUsuarioAcceso content) {
		
		AuditResponse response = new AuditResponse();
		response = Utilitario.setAuditResponseIDF("registrar_token", "0", "Se registró correctamente.", true);
		try {
						
			UsuarioAcceso usuario = new UsuarioAcceso();
			usuario.setNombreUsuario(content.getUsuario());
			usuario.setClave(bcrypt.encode(content.getClave()));
			service.registrar(usuario);

		} catch (Exception e) {
			
			response = Utilitario
					.setAuditResponseIDF("registrar_token", "1", "Error interno.", false);
		}

		return response;
	}

}
