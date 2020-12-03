package com.example.bookshelf.service;

import com.example.bookshelf.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DomainSecurityUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsernameOrEmail(s, s)
                .map(user -> new User(user.getUsername(), user.getPassword(), user.getAuthorities()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + s));
    }
}
