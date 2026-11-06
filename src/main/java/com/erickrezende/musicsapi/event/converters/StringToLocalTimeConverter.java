package com.erickrezende.musicsapi.event.converters;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;

public class StringToLocalTimeConverter implements Converter<String, LocalTime>{

    @Override
    public LocalTime convert(String source) {
        if (source == null || source.isBlank() || source.isEmpty()) {
            return null;
        }

        if(source.matches("\\d{1,2}")) {
            return LocalTime.of(Integer.parseInt(source), 0);
        }

        return LocalTime.parse(source);
    }
    
}
