package com.yjmg.tipocambio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yjmg.tipocambio.models.UsuarioAcceso;
import com.yjmg.tipocambio.repo.IUsuarioRepo;
import com.yjmg.tipocambio.service.IUsuarioAccesoService;


@Service(value = "userService")
public class UsuarioAccesoImpl implements UserDetailsService, IUsuarioAccesoService {

	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		/*
		 * List<GrantedAuthority> authorities = new ArrayList<>();
		 * 
		 * authorities.add(new SimpleGrantedAuthority("ADMINISTRADOR"));
		 * 
		 * UserDetails userDetails = new User("admin", bcrypt.encode("root123"),
		 * authorities);
		 * 
		 * System.out.println("USUARIO #2: " + userDetails.getUsername());
		 * System.out.println("PW ENCP #2: " + userDetails.getPassword());
		 * 
		 * return userDetails;
		 */

		// PubUsuario user = repo.findByCodUsuario(userId);
		UsuarioAcceso user = usuarioRepo.obtenerUsuario(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		authorities.add(new SimpleGrantedAuthority("ADMINISTRADOR"));

		
		UserDetails userDetails = new User(user.getNombreUsuario(), user.getClave(), authorities);
		// UserDetails userDetails = new User(user.getCodUsuario(), user.getClave(),
		// authorities);

		System.out.println("USUARIO #2: " + userDetails.getUsername());
		System.out.println("PW ENCP #2: " + userDetails.getPassword());

		return userDetails;
	}

	@Override
	public UsuarioAcceso registrar(UsuarioAcceso obj) {
		// TODO Auto-generated method stub
		return usuarioRepo.save(obj);
	}

	@Override
	public UsuarioAcceso modificar(UsuarioAcceso obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioAcceso> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioAcceso listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
