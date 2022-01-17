package com.example.userpostman.controller;


import com.example.userpostman.entity.User;
import com.example.userpostman.exception.UserExistException;
import com.example.userpostman.exception.UserNotFoundException;
import com.example.userpostman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.findAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getEmployeeById (@PathVariable("id") Long id) throws UserNotFoundException {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) throws UserExistException {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateEmployee(@RequestBody User employee) throws UserNotFoundException, UserExistException {
        User updateEmployee = userService.updateUser(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) throws UserNotFoundException {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
