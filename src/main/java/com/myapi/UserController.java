package com.myapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    // 1) Simple GET just to confirm it's working
    @GetMapping("/users")
    public String user() {
        return "Hello GET users is working!";
    }

    // 2) POST /users
    // Receives JSON like: { "name": "Alice", "age": 30 }
    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO user) {
        // Here you would normally save to a database.
        // For now, just echo the user back:
        System.out.println("Received user: " + user.getName() + ", id: " + user.getId());
        return user;
    }

    // 3) PATCH /users/{id}
    // Receives partial JSON like: { "name": "New Name" } or { "id": 40 }
    @PatchMapping("/users/{id}")
    public UserDTO updateUser(
            @PathVariable Long id,
            @RequestBody UserDTO updates
    )
//    {
//        UserDTO response = new HashMap<>();
//        //A HashMap cannot be assigned to a UserDTO
//        response.put("id", id);
//        response.put("updatesReceived", updates);
//        response.put("message", "PATCH simulated successfully");
//        //put(...) is a Map method, not a DTO method
//        return response;
//    }
    {
        // pretend you loaded this from a DB
        UserDTO existing = new UserDTO();
        existing.setId(id);
        existing.setName("Alice"); // sample existing data

        // apply patch only for fields that came in
        if (updates.getName() != null) {
            existing.setName(updates.getName());
        }
        if (updates.getId() != 0) {
            existing.setId(updates.getId());
        }

        return existing;
    }
}