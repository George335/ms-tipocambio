package dtos;

public class OuputTipCambioDTO {

	private String origen;
	private String destino;
	private String tipoCambio;

	public OuputTipCambioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OuputTipCambioDTO(String origen, String destino, String tipoCambio) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.tipoCambio = tipoCambio;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

}
