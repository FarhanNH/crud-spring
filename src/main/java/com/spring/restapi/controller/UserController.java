package com.spring.restapi.controller;

import com.spring.restapi.model.User;
import com.spring.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> readUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public User readUsers(@PathVariable(value = "userId") Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "userId") Long id) {
        userService.deleteUser(id);
    }
}
