package com.systemintegration.backend.entity;

import jakarta.persistence.*;
import jdk.jfr.Name;

import javax.swing.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;
    private String username;
    private String email;
    private String password_hash;

    @Enumerated(EnumType.STRING)
    private Role role = Role.GUEST;

    public User (){}
    public User (String username,String email,String password_hash) {
        this.username = username;
        this.email = email;
        this.password_hash = password_hash;
    }

    //set get

    public void setUsername(String username) {this.username = username;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword_hash(String password_hash) {this.password_hash = password_hash;}

    public String getUsername() {return username;}
    public String getEmail() {return email;}
    public String getPassword_hash() {return password_hash;}


}
