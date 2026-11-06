package com.erickrezende.musicsapi.music;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicRepository extends MongoRepository<Music, String> {

}
