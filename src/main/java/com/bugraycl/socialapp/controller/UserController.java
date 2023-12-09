package com.bugraycl.socialapp.controller;

import com.bugraycl.socialapp.models.User;
import com.bugraycl.socialapp.repository.UserRepository;
import com.bugraycl.socialapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer id) throws Exception {
        User user = userService.findUserById(id);
        return user;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return savedUser;
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable("userId") Integer userId) throws Exception {
        User updatedUser = userService.updateUser(user,userId);
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

    @PutMapping("/users/follow/{userId1}/{userId2}")
    public User followUserHandler(@PathVariable("userId1") Integer userId1, @PathVariable("userId2") Integer userId2) throws Exception {
        User user = userService.followUser(userId1,userId2);
        return user;
    }

    @GetMapping("/users/search")
    public List<User> searchUser(@RequestParam("query") String query) {
        List<User> users = userService.searchUser(query);
        return users;
    }

}
