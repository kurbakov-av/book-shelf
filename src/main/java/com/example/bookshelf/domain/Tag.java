package com.example.bookshelf.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
@Data
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
}
