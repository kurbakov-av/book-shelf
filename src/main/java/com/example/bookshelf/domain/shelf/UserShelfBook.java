package com.example.bookshelf.domain.shelf;

import com.example.bookshelf.domain.Book;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_shelf_books")
@Data
public class UserShelfBook {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Book book;

    private boolean read;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Shelf shelf;

    @CreationTimestamp
    private LocalDateTime addedAt;
}