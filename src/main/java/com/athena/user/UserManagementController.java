package com.athena.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin/api/v1/users")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserManagementController {

    private static final List<User> USERS = new ArrayList<User>();

//        new User(1, "James Bond")
//        new User(2, "Maria Jones")
//        new User(3, "John Doe")
    @GetMapping
    @PreAuthorize("hasAuthority('administrator:read')")
    public List<User> getAllUsers(){
        return USERS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('administrator:write')")
    public void registerNewUser(@RequestBody User user){
        USERS.add(new User(user.getUserName()));
        System.out.println(user);
    }

    @DeleteMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('administrator:write')")
    public void removeUser(@PathVariable("userId") Integer userId){
        USERS.remove((int)userId);
        System.out.println(USERS);
    }

    @PutMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('administrator:write')")
    public void updateStudent(@PathVariable("userId")Integer userId, @RequestBody User user){
        USERS.set(userId, new User(user.getUserName()));
    }

}
