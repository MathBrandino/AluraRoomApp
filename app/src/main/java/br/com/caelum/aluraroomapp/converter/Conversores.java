package br.com.caelum.aluraroomapp.converter;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by matheusbrandino on 2/22/18.
 */

public class Conversores {

    private static final String PADRAO = "dd/MM/yyyy";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(PADRAO);

    public static String toString(Calendar dataASerConvertida) {

        String dataFormatada = FORMATTER.format(dataASerConvertida.getTime());

        return dataFormatada;
    }

    public static Calendar toCalendar(String dataASerConvertida) {
        Calendar data = Calendar.getInstance();
        try {

            Date date = FORMATTER.parse(dataASerConvertida);

            data.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
            Log.e("Erro na conversao", "A data não pode ser convertida, devolvendo data de agora");
        }
        return data;
    }
}
