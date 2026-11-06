package com.erickrezende.musicsapi.music;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class MusicService {

    private final MusicRepository musicRepository;


    // Create
    public Music create(Music music){
        return musicRepository.save(music);
    }

    // Read
    public Music getMusic(String id) {
        return musicRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Music not found on db"
            ));
    }

    public List<Music> getAllMusics() {
        return musicRepository.findAll();
    }

    // Update
    public Music update(String id, Music updatedMusic) {
        Music existingMusic = getMusic(id);

        existingMusic.setTitle(updatedMusic.getTitle());
        existingMusic.setTheme(updatedMusic.getTheme());
        existingMusic.setChordsLink(updatedMusic.getChordsLink());
        existingMusic.setYoutubeLink(updatedMusic.getYoutubeLink());
        existingMusic.setOriginalTone(updatedMusic.getOriginalTone());
        existingMusic.setTone(updatedMusic.getTone());
        existingMusic.setAuthor(updatedMusic.getAuthor());
        existingMusic.setReferences(updatedMusic.getReferences());

        return musicRepository.save(existingMusic);
    }

    // Delete
    public void delete(String id) {
        Music musicToDelete = getMusic(id);
        musicRepository.delete(musicToDelete);
    }

}
