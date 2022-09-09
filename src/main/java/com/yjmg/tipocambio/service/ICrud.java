package com.yjmg.tipocambio.service;

import java.util.List;

public interface ICrud<T, V> {
	T registrar(T obj);
	
//	List<T> registrarAll(List<T> obj);

	T modificar(T obj);

	List<T> listar();

	T listarPorId(V id);


	void eliminar(V id);
}
