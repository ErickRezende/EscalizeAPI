package com.erickrezende.musicsapi.event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.erickrezende.musicsapi.event.presence.Presence;

import lombok.Data;

@Document(collection= "events")
@Data 
public class Event {
    @Id 
    private String id;
    
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<Presence> presence;

    @Deprecated 
    public Event() {}
}
