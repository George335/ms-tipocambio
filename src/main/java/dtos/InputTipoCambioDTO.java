package dtos;

public class InputTipoCambioDTO {

	private String monedaOrigen;
	private String monedaDestino;
	
	public InputTipoCambioDTO() {
		super();
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
	
	
}
