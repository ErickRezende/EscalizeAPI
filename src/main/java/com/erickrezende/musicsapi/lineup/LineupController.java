package com.erickrezende.musicsapi.lineup;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/lineup")
@AllArgsConstructor  
public class LineupController {
    private final LineupService service;

    // POST
    @PostMapping
    public Lineup create(@RequestBody Lineup lineup) {
        return service.create(lineup);
    }

    // GET
    @GetMapping
    public List<Lineup> getAllLineups() {
        return service.getAllLineups();
    }

    @GetMapping("/{id}")
    public Lineup get(@PathVariable String id){
        return service.getLineup(id);
    }

    // PUT
    @PutMapping("/{id}")
    public Lineup update(
        @PathVariable String id,
        @RequestBody Lineup lineup
    ) {
        return service.update(id, lineup);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
