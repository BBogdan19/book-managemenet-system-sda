package com.sda.bogdan.bookmanagement.service;


import com.sda.bogdan.bookmanagement.model.Book;
import com.sda.bogdan.bookmanagement.service.exceptions.EntityNotFoundException;

import java.util.List;

public interface BookService {
    void createBook(String title, String description, int authorId) throws EntityNotFoundException;

    List<Book> getAllBooks();
}
