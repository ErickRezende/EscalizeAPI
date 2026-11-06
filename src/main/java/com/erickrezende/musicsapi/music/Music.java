package com.erickrezende.musicsapi.music;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection = "musics")
@Data 
public class Music {

    @Id
    private String id;

    private String title;
    private List<String> theme;
    private String chordsLink;
    private String youtubeLink;
    private String originalTone;
    private String tone;
    private String author;
    private List<String> references;

    @Deprecated 
    public Music() {};
}
