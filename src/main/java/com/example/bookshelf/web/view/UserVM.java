package com.example.bookshelf.web.view;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Set;

@Data
@Builder
public class UserVM {

    @NonNull
    private final Long id;

    @NonNull
    private final String username;

    @NonNull
    private final String email;

    @NonNull
    private final Set<String> authorities;
}
