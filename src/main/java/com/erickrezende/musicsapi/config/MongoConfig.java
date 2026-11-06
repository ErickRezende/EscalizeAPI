package com.erickrezende.musicsapi.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import com.erickrezende.musicsapi.event.converters.LocalTimeToStringConverter;
import com.erickrezende.musicsapi.event.converters.StringToLocalTimeConverter;

@Configuration 
public class MongoConfig {
    
    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(
            List.of(
                new StringToLocalTimeConverter(),
                new LocalTimeToStringConverter()
            )
        );
    }
}
