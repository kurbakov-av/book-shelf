package com.example.bookshelf.web.view;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Builder
public class RateVM {

    @NonNull
    private final Long id;

    @NonNull
    private final Integer value;

    @NonNull
    private final LocalDateTime createdAt;
}
