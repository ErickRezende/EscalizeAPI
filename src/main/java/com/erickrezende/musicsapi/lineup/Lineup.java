package com.erickrezende.musicsapi.lineup;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "lineups")
@Data 
public class Lineup {

    @Id 
    private String id;

    private LocalDate date;
    private List<LocalDate> rehearsalDates;
    private List<String> booth; // Lista de ids de User
    private List<String> signs; // Lista de ids de User
    private List<String> ministering; // Lista de ids de User
    private List<String> vocal; // Lista de ids de User
    private List<String> instrumental; // Lista de ids de User
    private List<String> musics; // Lista de ids de Music 
    private String welcome;
    private String obs;

    @Deprecated 
    public Lineup() {}

}
