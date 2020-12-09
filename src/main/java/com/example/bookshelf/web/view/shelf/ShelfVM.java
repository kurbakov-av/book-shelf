package com.example.bookshelf.web.view.shelf;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ShelfVM {

    @NonNull
    private final Long id;

    @NonNull
    private final String title;

    private final String description;

    @Singular
    private final List<UserShelfBookVM> books;

    @NonNull
    private final LocalDateTime createdAt;

    @NonNull
    private final LocalDateTime updatedAt;
}
