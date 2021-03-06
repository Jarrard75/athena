package com.athena.user;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private static final List<User> USERS = Arrays.asList(
            new User(1, "James Bond", "user"),
            new User(2, "Maria Jones", "user"),
            new User(3, "John Doe", "user")
    );

    @GetMapping(path = "{userId}")
    public List<User> getAllUsers(@PathVariable("userId") Integer userId){
        return USERS;
    }

}
