package com.example.bookshelf.web.view.shelf;

import com.example.bookshelf.web.view.BookVM;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Builder
public class UserShelfBookVM {

    @NonNull
    private final Long id;

    @NonNull
    private final BookVM book;

    private final boolean read;

    private boolean favorite;

    @NonNull
    private final LocalDateTime addedAt;
}
