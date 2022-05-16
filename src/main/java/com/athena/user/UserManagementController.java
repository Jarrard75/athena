package com.athena.user;

import com.athena.auth.ApplicationUser;
import com.athena.auth.ApplicationUserService;
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

    private static final List<User> USERS = Arrays.asList(
            new User(1, "James Bond", "user"),
            new User(2, "Maria Jones", "user"),
            new User(3, "John Doe", "user")
    );

    @GetMapping
    @PreAuthorize("hasAuthority('administrator:read')")
    public List<User> getAllUsers(){
        return USERS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('administrator:write')")
    public void registerNewUser(@RequestBody User user){
        USERS.add(new User(user.getUserName()));
    }

    @DeleteMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('administrator:write')")
    public void removeUser(@PathVariable("userId") Integer userId){

        User searchUser = USERS.stream()
                .filter(someUser -> userId.equals(someUser.getUserId()))
                .findFirst()
                .orElse(null);

        if(searchUser != null){
            USERS.remove(USERS.indexOf(searchUser));
        }

    }

    @PutMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('administrator:write')")
    public void updateStudent(@PathVariable("userId")Integer userId, @RequestBody User user, @RequestBody String password){

        User searchUser = USERS.stream()
                .filter(someUser -> userId.equals(someUser.getUserId()))
                .findFirst()
                .orElse(null);

        if(searchUser != null){
            if(searchUser.getPassword().equals(password)){
                User newUser = new User(userId,user.getUserName(), password);
                USERS.set(USERS.indexOf(searchUser), newUser);
            }
            else{
                throw new RuntimeException("Username/Password Incorrect.");
            }
        }
        else {
            throw new RuntimeException("User: " + userId + " does not exist.");
        }
    }
}
