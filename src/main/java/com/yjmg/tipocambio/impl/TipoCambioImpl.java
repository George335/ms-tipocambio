package com.yjmg.tipocambio.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yjmg.tipocambio.models.TipCambio;
import com.yjmg.tipocambio.models.TipoCambio;
import com.yjmg.tipocambio.models.UsuarioAcceso;
import com.yjmg.tipocambio.repo.ITipoCambioRepo;
import com.yjmg.tipocambio.repo.IUsuarioRepo;
import com.yjmg.tipocambio.service.ITipoCambioService;

import dtos.AuditResponse;
import dtos.InputActualizarValorTCDTO;
import dtos.InputTipoCambioDTO;
import dtos.OuputTipCambioDTO;
import dtos.OuputTipoCambioDTO;

//@Service(value = "tipCambioService")
@Service
public class TipoCambioImpl implements ITipoCambioService/*, UserDetailsService*/ {

	@Autowired
	private ITipoCambioRepo repo;
	
	@Autowired
	private IUsuarioRepo usuarioRepo;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Override
	public TipCambio registrar(TipCambio obj) {
		return repo.save(obj);
	}

	@Override
	public TipCambio modificar(TipCambio obj) {
		return repo.save(obj);
	}

	@Override
	public List<TipCambio> listar() {
		return repo.findAll();
	}

	@Override
	public TipCambio listarPorId(Integer id) {
		Optional<TipCambio> embarcacionContacto = repo.findById(id);

		return embarcacionContacto.isPresent() ? embarcacionContacto.get() : new TipCambio();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public OuputTipCambioDTO obtener(InputTipoCambioDTO content) {
		TipCambio tipCambio = (TipCambio) repo.obtener(content.getMonedaOrigen(), content.getMonedaDestino());

		OuputTipCambioDTO response = new OuputTipCambioDTO(tipCambio.getPaisOrigen(), tipCambio.getPaisDestino(),
				"1 " + tipCambio.getPaisOrigen() + " equivale a " + tipCambio.getMontoDestino() + " "
						+ tipCambio.getPaisDestino());
		return response;
	}

	/*
	 * @Override public OuputTipoCambioDTO convertirTipoCambio(InputTipoCambioDTO
	 * content) {
	 * 
	 * OuputTipoCambioDTO ouputTipoCambioDTO = new OuputTipoCambioDTO();
	 * 
	 * List<TipCambio> result = (List<TipCambio>) repo.findAll(); List<TipCambio>
	 * resultFilter = result.stream() .filter(t ->
	 * t.getAbreviado().equals(content.getMonedaDestino()))
	 * .collect(Collectors.toList());
	 * 
	 * for (TipoCambio tipoCambio : resultFilter) {
	 * 
	 * ouputTipoCambioDTO.setMonto(content.getMonto());
	 * ouputTipoCambioDTO.setResultado(content.getMonto()*tipoCambio.getValor()+" "
	 * +tipoCambio.getNombre());
	 * ouputTipoCambioDTO.setMonedaOrigen(content.getMonedaOrigen());
	 * ouputTipoCambioDTO.setMonedaDestino(content.getMonedaDestino());
	 * ouputTipoCambioDTO.setTipoCambio(tipoCambio.getValor()); }
	 * 
	 * return ouputTipoCambioDTO; }
	 */

	/*
	 * @Override public AuditResponse actualizarValorTC(InputActualizarValorTCDTO
	 * content) {
	 * 
	 * AuditResponse response = new AuditResponse(); response =
	 * setAuditResponseIDF("/tipos_cambio/actualizar", "0",
	 * "Actualizado correctamente", true);
	 * 
	 * try {
	 * 
	 * List<TipoCambio> result = (List<TipCambio>) repo.findAll(); List<TipoCambio>
	 * resultFilter = result.stream() .filter(t ->
	 * t.getAbreviado().equals(content.getAbreviado()))
	 * .collect(Collectors.toList());
	 * 
	 * for (TipoCambio tipoCambio : resultFilter) {
	 * tipoCambio.setValor(content.getNuevoValor()); repo.save(tipoCambio); }
	 * 
	 * } catch (Exception e) { response =
	 * setAuditResponseIDF("/tipos_cambio/actualizar", "1", e.getMessage(), false);
	 * }
	 * 
	 * 
	 * return response; }
	 */
	
//	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//
//		/*
//		 * List<GrantedAuthority> authorities = new ArrayList<>();
//		 * 
//		 * authorities.add(new SimpleGrantedAuthority("ADMINISTRADOR"));
//		 * 
//		 * UserDetails userDetails = new User("admin", bcrypt.encode("root123"),
//		 * authorities);
//		 * 
//		 * System.out.println("USUARIO #2: " + userDetails.getUsername());
//		 * System.out.println("PW ENCP #2: " + userDetails.getPassword());
//		 * 
//		 * return userDetails;
//		 */
//
//		// PubUsuario user = repo.findByCodUsuario(userId);
//		UsuarioAcceso user = usuarioRepo.obtenerUsuario(userId);
//		if (user == null) {
//			throw new UsernameNotFoundException("Invalid username or password.");
//		}
//
//		List<GrantedAuthority> authorities = new ArrayList<>();
//
//		authorities.add(new SimpleGrantedAuthority("ADMINISTRADOR"));
//
//		
//		UserDetails userDetails = new User(user.getNombreUsuario(), bcrypt.encode(user.getClave()), authorities);
//		// UserDetails userDetails = new User(user.getCodUsuario(), user.getClave(),
//		// authorities);
//
//		System.out.println("USUARIO #2: " + userDetails.getUsername());
//		System.out.println("PW ENCP #2: " + userDetails.getPassword());
//
//		return userDetails;
//	}

	public static AuditResponse setAuditResponseIDF(String metodo, String codRespuesta, String mensaje,
			boolean status) {
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

//	@Override
//	public String convertir(double valorDolar, String pais, double cantidadMoneda) {
//		double dolares = cantidadMoneda / valorDolar;
//		
//		dolares = (double) Math.round(dolares * 100d) / 100;
//		
//		return "Tienes $"+dolares+" dólares";
//		
//	}

}
