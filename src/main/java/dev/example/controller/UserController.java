package dev.example.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final List<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User("Alice"));
        users.add(new User("Bob"));
        users.add(new User("Charlie"));
    }

    @GetMapping
    public List<User> getAll() {
        return users;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        users.add(user);
        return user;
    }

    public static class User {
        private String name;

        public User() { }

        public User(String name) { this.name = name; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}