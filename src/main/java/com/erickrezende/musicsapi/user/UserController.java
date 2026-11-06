package com.erickrezende.musicsapi.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/user")
@AllArgsConstructor 
public class UserController {
    private final UserService service;

    // POST
    // No POSTs yet

    // GET
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable String id){
        return service.getUser(id);
    }

    // PUT
    @PutMapping("/{id}")
    public User update(
        @PathVariable String id,
        @RequestBody User user
    ) {
        return service.update(id, user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
