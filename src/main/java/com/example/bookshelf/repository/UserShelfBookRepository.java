package com.example.bookshelf.repository;

import com.example.bookshelf.domain.Book;
import com.example.bookshelf.domain.shelf.Shelf;
import com.example.bookshelf.domain.shelf.UserShelfBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserShelfBookRepository extends JpaRepository<UserShelfBook, Long> {
    Page<UserShelfBook> findPageByBook(Book book, Pageable pageable);

    int countByShelf(Shelf shelf);

    int countByRead(boolean flag);
}
