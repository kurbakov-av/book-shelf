package com.example.bookshelf.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "authors")
@Data
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String fullName;
}
