package dtos;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuditResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String metodo;
	private String fecha;
	private String codigoRespuesta;
	private String descripcionRespuesta;
	private String mensajeRespuesta;
	private boolean status;

	public AuditResponse() {
		String FORMAT_DATE_TIME_ZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
	 	String TIME_ZONE_LIMA = "America/Lima";
		DateFormat sdf = new SimpleDateFormat(FORMAT_DATE_TIME_ZONE);
		sdf.setTimeZone(TimeZone.getTimeZone(TIME_ZONE_LIMA));
		String fechaActual = sdf.format(new Date());
		this.fecha = fechaActual;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}

	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AuditResponse [metodo=" + metodo + ", fecha=" + fecha + ", codigoRespuesta=" + codigoRespuesta
				+ ", descripcionRespuesta=" + descripcionRespuesta + ", mensajeRespuesta=" + mensajeRespuesta
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoRespuesta, descripcionRespuesta, fecha, mensajeRespuesta, metodo, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuditResponse other = (AuditResponse) obj;
		return Objects.equals(codigoRespuesta, other.codigoRespuesta)
				&& Objects.equals(descripcionRespuesta, other.descripcionRespuesta)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(mensajeRespuesta, other.mensajeRespuesta)
				&& Objects.equals(metodo, other.metodo) && status == other.status;
	}

	

	
}