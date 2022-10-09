package com.example.AplikasiPerpustakaan.Common;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserialize extends JsonDeserializer<Date> {
    private static final String[] DATE_FORMAT ={
            "dd-MM-yyyy",
            "dd/MM/yyyy",
            "dd.MM.yyyy"
    };

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        if (jsonParser == null || jsonParser.getText().equals("")){
            return null;
        }
        String date = jsonParser.getText();

        for (String format : DATE_FORMAT){

            try {
                return new SimpleDateFormat(format).parse(date);

            }catch (ParseException e){
                e.printStackTrace();
            }
        }
        return null;

    }
}
