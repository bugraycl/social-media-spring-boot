package com.bugraycl.socialapp.controller;

import com.bugraycl.socialapp.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>(); //users adında bir dizi listesi
        User user1 = new User("buğra","yücel","bycl@gmail.com","123");
        User user2 = new User("jhon","doe","jhondoe@gmail.com","123");

        users.add(user1);
        users.add(user2);

        return users;
    }
}
