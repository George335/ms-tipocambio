package com.yjmg.tipocambio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historial_conversion")
public class HistorialConversion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre_usuario_modificador")
	private String nombreUsuarioModificador;

	@Column(name = "monto_convertir")
	private String montoConvertir;

	@Column(name = "moneda_origen")
	private String monedaOrigen;

	@Column(name = "moneda_destino")
	private String monedaDestino;

	@Column(name = "monto_convertido")
	private String montoConvertido;

	@Column(name = "tipo_cambio")
	private String tipoCambio;

	public HistorialConversion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistorialConversion(String nombreUsuarioModificador, String montoConvertir, String monedaOrigen,
			String monedaDestino, String montoConvertido, String tipoCambio) {
		super();
		this.nombreUsuarioModificador = nombreUsuarioModificador;
		this.montoConvertir = montoConvertir;
		this.monedaOrigen = monedaOrigen;
		this.monedaDestino = monedaDestino;
		this.montoConvertido = montoConvertido;
		this.tipoCambio = tipoCambio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreUsuarioModificador() {
		return nombreUsuarioModificador;
	}

	public void setNombreUsuarioModificador(String nombreUsuarioModificador) {
		this.nombreUsuarioModificador = nombreUsuarioModificador;
	}

	public String getMontoConvertir() {
		return montoConvertir;
	}

	public void setMontoConvertir(String montoConvertir) {
		this.montoConvertir = montoConvertir;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public String getMontoConvertido() {
		return montoConvertido;
	}

	public void setMontoConvertido(String montoConvertido) {
		this.montoConvertido = montoConvertido;
	}

	public String getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

}
