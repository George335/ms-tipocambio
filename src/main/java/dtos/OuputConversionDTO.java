package dtos;

public class OuputConversionDTO {

	private String montoResultado;
	private String tipoCambio;

	public OuputConversionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OuputConversionDTO(String montoResultado, String tipoCambio) {
		super();
		this.montoResultado = montoResultado;
		this.tipoCambio = tipoCambio;
	}

	public String getMontoResultado() {
		return montoResultado;
	}

	public void setMontoResultado(String montoResultado) {
		this.montoResultado = montoResultado;
	}

	public String getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

}
