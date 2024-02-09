package com.loja.compras.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    private static final String PATTERN = "dd/MM/yyyy HH:mm";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);

    static {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3"));
    }

    public static String toString(Date data) {
        return dateFormat.format(data);
    }

    public static Date toDate(String data) {
        try {
            return dateFormat.parse(data);
        } catch (ParseException e) {
            return null;
        }
    }

}
