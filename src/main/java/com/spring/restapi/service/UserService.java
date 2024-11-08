package com.spring.restapi.service;

import com.spring.restapi.model.User;
import com.spring.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        if (user.getCreated() == null) user.setCreated(new Date());
        if (user.getUpdated() == null) user.setUpdated(user.getCreated());
        if (user.getCreatedBy() == null) user.setCreatedBy(1L);
        if (user.getUpdatedBy() == null) user.setUpdatedBy(user.getCreatedBy());
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        User userData = userRepository.findById(id).get();
        userData.setName(user.getName());
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());
        userData.setStatus(user.getStatus());
        userData.setUpdatedBy(user.getUpdatedBy());
        userData.setUpdated(user.getUpdated());
        return userRepository.save(userData);
    }
}
