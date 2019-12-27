package com.demo.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class User {

    private String username;

    private String password;

    private String email;

}
