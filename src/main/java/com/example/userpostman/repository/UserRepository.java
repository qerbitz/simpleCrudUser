package com.example.userpostman.repository;

import com.example.userpostman.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    void deleteUserById(Long id);

    User findUserById(Long id);

    @Query(
            value = "SELECT * FROM user where first_name = :first_name and last_name = :last_name",
            nativeQuery = true
    )
    Optional<User> isUserAlreadyExist(String first_name, String last_name);
}
