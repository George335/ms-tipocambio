package dtos;

public class InputConversionDTO {

	private double valorDOlar;
	private String pais;
	private double cantidadMoneda;

	public InputConversionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InputConversionDTO(double valorDOlar, String pais, double cantidadMoneda) {
		super();
		this.valorDOlar = valorDOlar;
		this.pais = pais;
		this.cantidadMoneda = cantidadMoneda;
	}

	public double getValorDOlar() {
		return valorDOlar;
	}

	public void setValorDOlar(double valorDOlar) {
		this.valorDOlar = valorDOlar;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public double getCantidadMoneda() {
		return cantidadMoneda;
	}

	public void setCantidadMoneda(double cantidadMoneda) {
		this.cantidadMoneda = cantidadMoneda;
	}

}
