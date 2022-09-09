package com.yjmg.tipocambio.models;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "tbl_tipo_cambio")
public class TipoCambio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "valor")
	private Double valor;

	@Column(name = "abreviado")
	private String abreviado;

	public TipoCambio() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getAbreviado() {
		return abreviado;
	}

	public void setAbreviado(String abreviado) {
		this.abreviado = abreviado;
	}

	@Override
	public String toString() {
		return "TipoCambio [id=" + id + ", nombre=" + nombre + ", valor=" + valor + ", abreviado=" + abreviado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(abreviado, id, nombre, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoCambio other = (TipoCambio) obj;
		return Objects.equals(abreviado, other.abreviado) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(valor, other.valor);
	}

}
