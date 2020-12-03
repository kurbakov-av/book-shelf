package com.example.bookshelf.service;

import com.example.bookshelf.domain.app.User;
import com.example.bookshelf.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    @PreAuthorize("isAuthenticated()")
    public User getCurrentUser() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getDetails)
                .flatMap(details -> userRepository.findByUsername(((UserDetails) details).getUsername()))
                .orElse(null);
    }

    @Override
    @Transactional
    @PreAuthorize("isAnonymous() or hasRole('ADMIN')")
    public void create(User user) {
        Assert.notEmpty(user.getAuthorities(), "authorities is empty");
        userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public void updateAuthorities(User user, Set<GrantedAuthority> authorities) {
        Assert.notEmpty(authorities, "authorities is empty");

        user.setAuthorities(authorities);
        userRepository.save(user);
    }
}
