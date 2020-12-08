package com.example.bookshelf.service;

import com.example.bookshelf.domain.Author;
import com.example.bookshelf.domain.Book;
import com.example.bookshelf.domain.Genre;
import com.example.bookshelf.domain.Tag;
import com.example.bookshelf.repository.BookRepository;
import com.example.bookshelf.web.form.BookForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('USER')")
    public void create(BookForm form) {
        Set<Genre> genres = form.getGenres().stream()
                .map(line -> {
                    Genre genre = new Genre();
                    genre.setTitle(line);
                    return genre;
                })
                .collect(Collectors.toSet());

        Set<Tag> tags = form.getTags().stream()
                .map(line -> {
                    Tag tag = new Tag();
                    tag.setTitle(line);
                    return tag;
                })
                .collect(Collectors.toSet());

        Book book = new Book();
        book.setTitle(form.getTitle());
        book.setDescription(form.getDescription());
        book.setCover(form.getCover());
        book.setVolume(form.getVolume());
        book.setPublicationAt(form.getPublicationAt());
        book.setGenres(genres);
        book.setTags(tags);

        if (form.getAuthor() != null) {
            Author author = new Author();
            author.setFullName(form.getAuthor().getFullName());
            book.setAuthor(author);
        }

        bookRepository.save(book);
    }
}
