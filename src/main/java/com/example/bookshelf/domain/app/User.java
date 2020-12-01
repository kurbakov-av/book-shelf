package com.example.bookshelf.domain.app;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(schema = "app", name = "users")
@Data
@EqualsAndHashCode(of = {"id", "username", "email"})
@ToString(exclude = {"password"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Email(regexp = ".*@.*")
    @Column(nullable = false, unique = true)
    private String email;

    @Length(min = 8)
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @CollectionTable(schema = "app", name = "authorities")
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    private Set<GrantedAuthority> authorities;
}
