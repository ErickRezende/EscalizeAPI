package com.erickrezende.musicsapi.music;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController 
@RequestMapping("/music")
@AllArgsConstructor 
public class MusicController {

    private final MusicService service;

    // POST
    @PostMapping    
    public ResponseEntity<Music> create(@RequestBody Music music) {
        Music createdMusic = service.create(music);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(createdMusic);
    }


    // GET
    @GetMapping
    public List<Music> getMusic() {
        return service.getAllMusics();
    }

    @GetMapping("/{id}")
    public Music getMusic(@PathVariable String id) {
        return service.getMusic(id);
    }
    
    // PUT
    @PutMapping("/{id}")
    public Music update(@PathVariable String id, @RequestBody Music music) {
        return service.update(id, music);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
