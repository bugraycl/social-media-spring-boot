package com.bugraycl.socialapp.controller;

import com.bugraycl.socialapp.models.User;
import com.bugraycl.socialapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {

        List<User> users = userRepository.findAll();
        return users;

    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer id) throws Exception {

        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        }

        throw new Exception("user not exist with userid " + id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {

        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        User savedUser = userRepository.save(newUser);
        return savedUser;
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable("userId") Integer userId) throws Exception {

        Optional<User> user1 = userRepository.findById(userId);

        if(user1.isEmpty()) {
            throw new Exception("user not exit with by id " + userId);
        }

        User oldUser = user1.get();

        if (user.getFirstName() != null) {
            oldUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            oldUser.setLastName(user.getLastName());
        }
        if (user.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }

        User updatedUser = userRepository.save(oldUser);

        return updatedUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()) {
            throw new Exception("user not exit with by id " + userId);
        }
        userRepository.delete(user.get());
        return "user deleted successfully with id " + userId;
    }

}
