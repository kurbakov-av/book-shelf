package com.example.bookshelf.repository;

import com.example.bookshelf.domain.app.OauthUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthUserDetailsRepository extends JpaRepository<OauthUserDetails, String> {
}
