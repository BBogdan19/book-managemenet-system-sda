package com.sda.bogdan.bookmanagement.repository;

import com.sda.bogdan.bookmanagement.model.Book;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book> implements BookRepository {
    public BookRepositoryImpl() {
        super(Book.class);
    }
}