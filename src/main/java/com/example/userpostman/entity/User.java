package com.example.userpostman.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String first_name;
    private String last_name;
    private String position;
    private Double salary;

}
