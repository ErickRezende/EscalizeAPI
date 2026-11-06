package com.erickrezende.musicsapi.lineup;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LineupRepository extends MongoRepository<Lineup, String> {}
