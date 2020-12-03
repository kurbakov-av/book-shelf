package com.example.bookshelf.service;

import com.example.bookshelf.domain.app.User;
import com.example.bookshelf.web.form.UserRegisterForm;

import java.util.Set;

public interface RegisterService {

    User register(UserRegisterForm form);

    User register(UserRegisterForm form, Set<String> authorities);
}
