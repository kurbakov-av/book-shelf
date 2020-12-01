package com.example.bookshelf.repository;

import com.example.bookshelf.domain.Book;
import com.example.bookshelf.domain.Rate;
import com.example.bookshelf.domain.app.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
    boolean existsByBookAndVoter(Book book, User voter);
}
