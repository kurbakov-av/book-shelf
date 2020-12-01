package com.example.bookshelf.repository;

import com.example.bookshelf.domain.Author;
import com.example.bookshelf.domain.Book;
import com.example.bookshelf.domain.Genre;
import com.example.bookshelf.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findPageByAuthor(Author author, Pageable pageable);

    Page<Book> findPageByTitleContains(String term, Pageable pageable);

    Page<Book> findPageByDescriptionContains(String term, Pageable pageable);

    Page<Book> findPageByGenresContains(Genre genre, Pageable pageable);

    Page<Book> findPageByTagsContains(Tag tag, Pageable pageable);

    int countBooksByAuthor(Author author);
}
