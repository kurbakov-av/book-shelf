package com.example.bookshelf.domain.shelf;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "favorite_books")
@Data
public class FavoriteBook {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserShelfBook book;

    @CreationTimestamp
    private LocalDateTime addedAt;
}
