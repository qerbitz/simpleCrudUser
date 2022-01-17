package com.example.userpostman.service;

import com.example.userpostman.entity.User;
import com.example.userpostman.exception.UserExistException;
import com.example.userpostman.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User addUser(User user) throws UserExistException;

    User updateUser(User user) throws UserExistException, UserNotFoundException;

    User findUserById(Long id) throws UserNotFoundException;

    void deleteUser(Long id) throws UserNotFoundException;

    
    
}
