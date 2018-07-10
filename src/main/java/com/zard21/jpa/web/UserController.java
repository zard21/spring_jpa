package com.zard21.jpa.web;

import com.zard21.jpa.domain.User;
import com.zard21.jpa.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Cacheable(value = "users", key = "#id")
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        User user = userRepository.findById(id);

        return user;
    }

    @CachePut(value = "users", key = "#user.id")
    @PostMapping("/create")
    public User setUser(@RequestBody User user) {
        userRepository.save(user);

        return user;
    }
}
