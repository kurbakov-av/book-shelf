package com.example.bookshelf.web.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorVM {

    private final String fullName;
}
