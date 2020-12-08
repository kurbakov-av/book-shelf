package com.example.bookshelf.service;

import com.example.bookshelf.domain.Book;
import com.example.bookshelf.domain.Rate;
import com.example.bookshelf.domain.app.User;
import com.example.bookshelf.repository.BookRepository;
import com.example.bookshelf.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final BookRepository bookRepository;

    private final RateRepository rateRepository;

    private final UserService userService;

    @Override
    @Transactional
    @PreAuthorize("isAuthenticated()")
    public void update(Book book, Integer rating) {
        User currentUser = userService.getCurrentUser();
        Assert.state(rateRepository.existsByBookAndVoter(book, currentUser), "User already voted");

        Rate rate = new Rate();
        rate.setVoter(currentUser);
        rate.setValue(rating);
        rate.setBook(book);

        bookRepository.save(book);
    }
}
