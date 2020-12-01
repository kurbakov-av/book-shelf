package com.example.bookshelf.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Length(min = 1, max = 255)
    @Column(nullable = false)
    private String title;

    @Length(max = 5000)
    private String description;

    private String cover;

    private Integer volume;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private Set<Tag> tags;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private Set<Genre> genres;

    private LocalDateTime publicationAt;
}
