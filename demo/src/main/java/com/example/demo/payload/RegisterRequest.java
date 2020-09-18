package com.example.demo.payload;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
public class RegisterRequest implements Serializable {

    @NotNull @NotEmpty
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @NotNull @NotEmpty
    private String password;

    @NotNull @NotEmpty
    private String name;
}
