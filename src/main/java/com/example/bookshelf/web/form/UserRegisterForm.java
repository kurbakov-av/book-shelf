package com.example.bookshelf.web.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserRegisterForm {

    @NotNull
    @Length(min = 3, max = 255)
    private final String username;

    @NotNull
    @Length(min = 8)
    private final String password;

    @NotNull
    @Email(regexp = ".*@.*")
    private final String email;
}
