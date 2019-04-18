package com.lbs.meetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void addUser(String username, LocalDate localDate) {
        User user = new User(username, localDate);
        userRepository.save(user);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findOne(id);
    }

    public List<User> getUserByName(String username) {
        return userRepository.findByUsername(username);
    }
}
