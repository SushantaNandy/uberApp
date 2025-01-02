package com.nandysushanta.project.uber.uberApp.entities;

import com.nandysushanta.project.uber.uberApp.entities.enums.Role;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING) // STRING --> Deals with string value, ODINAL --> Deals with numeric values like 0 for ADMIN, 1 for anything else
    private Set<Role> roles;
}
