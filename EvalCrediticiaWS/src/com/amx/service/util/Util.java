package com.amx.service.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Util {

	/**
	 * @param date
	 * @param diaSuma
	 * @return Date
	 */
	public static Date SumarDiasDate(Date date, int diaSuma) {

		Date response = new Date();
		Calendar cal = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
		format.format(date);
		cal = format.getCalendar();
		cal.add(Calendar.DATE, diaSuma);
		response = cal.getTime();
		return response;
	}

	/**
	 * @param fechaInicio
	 * @param fechaFinal
	 * @return int
	 */
	public static int calcularEdad(Date fechaInicio, Date fechaFinal) {

		Calendar fechaAct = Calendar.getInstance();
		fechaAct.setTime(fechaFinal);

		Calendar fechaNac = Calendar.getInstance();
		fechaNac.setTime(fechaInicio);

		int dif_anios = fechaAct.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
		int dif_meses = fechaAct.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
		int dif_dias = fechaAct.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

		if (dif_meses < 0 || (dif_meses == 0 && dif_dias < 0)) {
			dif_anios--;
		}
		return dif_anios;
	}

	/**
	 * @return Date
	 */
	public static Date getPrimerDiaDelMes() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		cal.set(cal.get(Calendar.YEAR),

		cal.get(Calendar.MONTH),

		cal.getMinimum(Calendar.DAY_OF_MONTH));

		return cal.getTime();

	}

	/**
	 * @return Date
	 */
	public static Date getUltimoDiaDelMes() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		cal.set(cal.get(Calendar.YEAR),

		cal.get(Calendar.MONTH),

		cal.getActualMaximum(Calendar.DAY_OF_MONTH));

		return cal.getTime();

	}

	/**
	 * @param date
	 * @return XMLGregorianCalendar
	 * @throws DatatypeConfigurationException
	 */
	public static XMLGregorianCalendar DateToXMLCalendar(Date date) throws DatatypeConfigurationException {

		GregorianCalendar calendar = new GregorianCalendar();
		XMLGregorianCalendar xmlCalendar;
		xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
		calendar.setTime(date);

		return xmlCalendar;
	}

}
