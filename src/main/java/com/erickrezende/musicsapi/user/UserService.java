package com.erickrezende.musicsapi.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class UserService {

    private final UserRepository repository;

    // Create
    private User create(User user) {
        return repository.save(user);
    }

    // Read
    public List<User> getAllUsers(){
        return repository.findAll();
    }
    
    public User getUser(String id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "User not found on db"
            ));
    }

    // Update
    public User update(String id, User updatedUser){
        User existingUser = getUser(id);
        
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setAdmin(updatedUser.getAdmin());
        existingUser.setRoles(updatedUser.getRoles());

        return repository.save(existingUser);
    }

    // Delete 
    public void delete(String id) {
        repository.delete(getUser(id));
    }
}
