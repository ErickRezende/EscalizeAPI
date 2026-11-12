package com.erickrezende.musicsapi.user;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;


public interface UserRepository extends MongoRepository<User, String>{

    Optional<User> findByEmail(String email);

}
