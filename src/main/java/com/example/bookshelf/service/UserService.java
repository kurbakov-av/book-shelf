package com.example.bookshelf.service;

import com.example.bookshelf.domain.app.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

public interface UserService {

    User getCurrentUser();

    void create(User user);

    void updateAuthorities(User user, Set<GrantedAuthority> authorities);
}
