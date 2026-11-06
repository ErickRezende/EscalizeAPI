package com.erickrezende.musicsapi.event;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class EventService {
    private final EventRepository repository;

    // CREATE
    public Event create(Event event) {
        return repository.save(event);
    }

    // READ
    public List<Event> getAllEvents(){
        return repository.findAll();
    }

    public Event getEvent(String id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Event not found on db"
        ));    
    }

    // UPDATE
    public Event update(String id, Event newEvent) {
        Event updatedEvent = getEvent(id);

        updatedEvent.setDate(newEvent.getDate());
        updatedEvent.setStartTime(newEvent.getStartTime());
        updatedEvent.setEndTime(newEvent.getEndTime());
        updatedEvent.setPresence(newEvent.getPresence());

        return repository.save(updatedEvent);
    }

    // DELETE
    public void delete(String id) {
        repository.deleteById(id);
    }
    
}