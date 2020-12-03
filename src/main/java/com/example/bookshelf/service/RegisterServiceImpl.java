package com.example.bookshelf.service;

import com.example.bookshelf.domain.app.OauthUserDetails;
import com.example.bookshelf.domain.app.Role;
import com.example.bookshelf.domain.app.User;
import com.example.bookshelf.repository.OauthUserDetailsRepository;
import com.example.bookshelf.web.form.UserRegisterForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final OauthUserDetailsRepository oauthUserDetailsRepository;

    @Override
    @Transactional
    @PreAuthorize("isAnonymous() or hasRole('ADMIN')")
    public User register(UserRegisterForm form) {
        return register(form, Set.of(Role.USER.name()));
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public User register(UserRegisterForm form, Set<String> authorities) {
        Set<GrantedAuthority> grants = authorities.stream()
                .map(Role::valueOf)
                .collect(Collectors.toSet());

        User user = create(form);
        user.setAuthorities(grants);
        userService.create(user);

        OauthUserDetails details = new OauthUserDetails();
        details.setClientId(user.getUsername());
        details.setClientSecret(user.getPassword());
        details.setAccessTokenValidity(3600);
        details.setRefreshTokenValidity(3600 * 14);
        details.setScope("api");
        details.setResourceIds("api");
        details.setAuthorities(StringUtils.collectionToCommaDelimitedString(grants));
        details.setAuthorizedGrantTypes("password, refresh_token");
        oauthUserDetailsRepository.save(details);

        return user;
    }

    private User create(UserRegisterForm form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setEmail(form.getEmail());

        return user;
    }
}
