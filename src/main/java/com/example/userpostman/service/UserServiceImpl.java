package com.example.userpostman.service;

import com.example.userpostman.entity.User;
import com.example.userpostman.exception.UserExistException;
import com.example.userpostman.exception.UserNotFoundException;
import com.example.userpostman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.example.userpostman.exception.ExceptionConstant.*;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) throws UserExistException {
        Optional<User> checkUser = userRepository.isUserAlreadyExist(user.getFirst_name(), user.getLast_name());
        if(checkUser != null){
            throw new UserExistException(USER_ALREADY_EXIST);
        }
        else{
            return userRepository.save(user);
        }
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        User usertoUpdate = userRepository.findUserById(user.getId());
        if(usertoUpdate != null){
            return userRepository.save(user);
        }
        else{
            throw new UserNotFoundException(NO_USER_FOUND + " by id:"+ user.getId());
        }
    }

    @Override
    public User findUserById(Long id) throws UserNotFoundException{
        User user = userRepository.findUserById(id);
        if(user == null) {
            throw new UserNotFoundException(NO_USER_FOUND + " by id:"+ id);
        }
        else{
            return userRepository.findUserById(id);
        }
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {
        User user = userRepository.findUserById(id);
        if(user == null) {
            throw new UserNotFoundException(NO_USER_FOUND + " by id:"+ id);
        }
        else{
            userRepository.deleteUserById(id);
        }
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


}
