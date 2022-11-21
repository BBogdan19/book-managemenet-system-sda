package com.sda.bogdan.bookmanagement.repository;

import com.sda.bogdan.bookmanagement.model.Author;


public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author> implements AuthorRepository  {

    public AuthorRepositoryImpl() {
        super(Author.class);
    }
}