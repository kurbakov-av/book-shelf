package com.example.bookshelf.service;

import com.example.bookshelf.domain.app.User;

public interface TenantService {

    void initEnvironment(User user);
}
