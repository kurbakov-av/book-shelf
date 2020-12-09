package com.example.bookshelf.web.view;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class BookVM {

    @NonNull
    private final Long id;

    @NonNull
    private final String title;

    private final String description;

    private final String cover;

    private final Integer volume;

    private final AuthorVM author;

    private final Set<TagVM> tags;

    private final Set<GenreVM> genres;

    @NonNull
    private final LocalDateTime publicationAt;
}
