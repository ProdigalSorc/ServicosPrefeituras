package br.gov.sp.prodesp.sim.servicosprefeituras.utils;

import android.support.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {
    private static final String DIA_MES_ANO = "dd/MM/yyyy";
    private static final String HORA = "HH:mm";

    @NonNull
    public static String dataEmTexto(Calendar data) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(DIA_MES_ANO);
        return formatoBrasileiro.format(data.getTime());
    }

    @NonNull
    public static String horaEmTexto(Calendar hora) {
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(HORA);
        return formatoBrasileiro.format(hora.getTime());
    }


    public static String dateToString(Date date, String format) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        }
        return "";
    }


    public static Date strToDateTime(String data){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        if (data != null) {
            try {
                return dateFormat.parse(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
