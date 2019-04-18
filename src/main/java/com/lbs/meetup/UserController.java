package com.lbs.meetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUserList();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/usersByName/{name}", method = RequestMethod.GET)
    public List<User> getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }
}
