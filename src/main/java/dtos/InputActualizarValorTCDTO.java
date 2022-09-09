package dtos;

public class InputActualizarValorTCDTO {

	private String abreviado;
	private double nuevoValor;
	
	public InputActualizarValorTCDTO() {
		super();
	}

	public String getAbreviado() {
		return abreviado;
	}

	public void setAbreviado(String abreviado) {
		this.abreviado = abreviado;
	}

	public double getNuevoValor() {
		return nuevoValor;
	}

	public void setNuevoValor(double nuevoValor) {
		this.nuevoValor = nuevoValor;
	}

}
