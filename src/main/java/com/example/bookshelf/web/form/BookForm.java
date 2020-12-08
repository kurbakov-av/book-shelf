package com.example.bookshelf.web.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookForm {

    @NotNull
    @Length(min = 1)
    private final String title;

    @Length(max = 5000)
    private final String description;

    private final String cover;

    private final Integer volume;

    private final AuthorForm author;

    private final Set<String> tags;

    private final Set<String> genres;

    private final LocalDateTime publicationAt;
}
