package com.example.bookshelf.domain;

import com.example.bookshelf.domain.app.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rates")
@Data
public class Rate {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer value;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Book book;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User voter;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
