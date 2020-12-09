package com.example.bookshelf.web.view;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class GenreVM {

    @NonNull
    private final Long id;

    @NonNull
    private final String title;
}
