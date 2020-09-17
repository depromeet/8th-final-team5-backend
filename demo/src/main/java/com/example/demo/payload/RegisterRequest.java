package com.example.demo.payload;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class RegisterRequest implements Serializable {
    private String email;
    private String password;
    private String name;
}
