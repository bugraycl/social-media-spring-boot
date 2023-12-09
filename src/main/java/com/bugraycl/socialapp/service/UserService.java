package com.bugraycl.socialapp.service;

import com.bugraycl.socialapp.models.User;

import java.util.List;

public interface UserService {

    public User registerUser(User user);

    public User findUserById(Integer userId) throws Exception;

    public User findUserByEmail(String email);

    public User followUser(Integer user1, Integer user2) throws Exception;

    public User updateUser(User user, Integer userId) throws Exception;

    public List<User> searchUser(String query);



}
