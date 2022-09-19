package com.yjmg.tipocambio.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import dtos.AuditResponse;

public class Utilitario {

	public static AuditResponse setAuditResponseIDF(String metodo, String codRespuesta, String mensaje, boolean status) {
		String FORMAT_DATE_TIME_ZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
		AuditResponse auditResponse = new AuditResponse();
		auditResponse.setMetodo(metodo);
		auditResponse.setFecha(parseDateFormat(FORMAT_DATE_TIME_ZONE));
		auditResponse.setCodigoRespuesta(codRespuesta);
		auditResponse.setDescripcionRespuesta(mensaje);
		auditResponse.setStatus(status);
		return auditResponse;
	}
	
	public static String parseDateFormat(String dateformat) {
		String TIME_ZONE_LIMA = "America/Lima";
        DateFormat sdf = new SimpleDateFormat(dateformat);
        sdf.setTimeZone(TimeZone.getTimeZone(TIME_ZONE_LIMA));
        return sdf.format(new Date());
    }
	
}
