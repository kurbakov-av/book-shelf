package com.example.bookshelf.service;

import com.example.bookshelf.domain.Book;

public interface RateService {

    void update(Book book, Integer rating);
}
