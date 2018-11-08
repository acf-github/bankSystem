package com.myfinance.utils;

import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class DateUtils {

	public static int calcularDiasEntre(Date data1, Date data2) {

		// return (int) Math.abs(calcularDiasEntreNegPos(data1, data2));
		return Integer.parseInt(Long.toString(Math.abs(calcularDiasEntreNegPos(data1, data2))));
	}

	public static long calcularDiasEntreNegPos(Date data1, Date data2) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(data1);
		gc.set(GregorianCalendar.HOUR_OF_DAY, 12);
		Date tim1 = gc.getTime();
		DateTime dt1 = new DateTime(tim1);
		gc.setTime(data2);
		gc.set(GregorianCalendar.HOUR_OF_DAY, 12);
		Date tim2 = gc.getTime();
		DateTime dt2 = new DateTime(tim2);
		Days d = Days.daysBetween(dt2.toLocalDate(), dt1.toLocalDate());
		return d.getDays();
	}	

}
