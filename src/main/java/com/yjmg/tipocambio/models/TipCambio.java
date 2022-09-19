package com.yjmg.tipocambio.models;

import javax.persistence.*;

@Entity
@Table(name = "tipo_cambio")
public class TipCambio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "pais_origen")
	private String paisOrigen;

	@Column(name = "pais_destino")
	private String paisDestino;

	@Column(name = "monto_origen")
	private Double montoOrigen;

	@Column(name = "monto_destino")
	private Double montoDestino;

	public TipCambio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipCambio(Integer id, String paisOrigen, String paisDestino, Double montoOrigen, Double montoDestino) {
		super();
		this.id = id;
		this.paisOrigen = paisOrigen;
		this.paisDestino = paisDestino;
		this.montoOrigen = montoOrigen;
		this.montoDestino = montoDestino;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getPaisDestino() {
		return paisDestino;
	}

	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}

	public Double getMontoOrigen() {
		return montoOrigen;
	}

	public void setMontoOrigen(Double montoOrigen) {
		this.montoOrigen = montoOrigen;
	}

	public Double getMontoDestino() {
		return montoDestino;
	}

	public void setMontoDestino(Double montoDestino) {
		this.montoDestino = montoDestino;
	}

}
