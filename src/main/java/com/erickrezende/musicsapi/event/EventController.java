package com.erickrezende.musicsapi.event;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/event")
@AllArgsConstructor 
public class EventController {
    private final EventService service;

    // POST
    @PostMapping 
    public Event create(@RequestBody Event event) {
        return service.create(event);
    }

    // GET
    @GetMapping("/{id}")
    public Event getEvent(@PathVariable String id) {
        return service.getEvent(id);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    } 

    // PUT
    @PutMapping("/{id}")
    public Event update(@PathVariable String id, @RequestBody Event event) {
        return service.update(id, event);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
