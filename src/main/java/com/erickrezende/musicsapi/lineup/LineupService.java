package com.erickrezende.musicsapi.lineup;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor 
public class LineupService {
    private final LineupRepository repository;

    // CREATE
    public Lineup create(Lineup lineup) {
        return repository.save(lineup);
    }

    // READ
    public List<Lineup> getAllLineups() {
        return repository.findAll();
    }

    public Lineup getLineup(String id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Lineup not found on db"));
    }

    // UPDATE
    public Lineup update(String id, Lineup newLineup) {
        Lineup updatedLineup = getLineup(id);

        updatedLineup.setDate(newLineup.getDate());
        updatedLineup.setRehearsalDates(newLineup.getRehearsalDates());
        updatedLineup.setBooth(newLineup.getBooth());
        updatedLineup.setSigns(newLineup.getSigns());
        updatedLineup.setMinistering(newLineup.getMinistering());
        updatedLineup.setWelcome(newLineup.getWelcome());
        updatedLineup.setVocal(newLineup.getVocal());
        updatedLineup.setInstrumental(newLineup.getInstrumental());
        updatedLineup.setMusics(newLineup.getMusics());
        updatedLineup.setObs(newLineup.getObs());

        return repository.save(updatedLineup);
    }

    // DELETE
    public void delete(String id) {
        repository.deleteById(id);
    }
}
