package com.sda.bogdan.bookmanagement.service;

import com.sda.bogdan.bookmanagement.model.Author;
import com.sda.bogdan.bookmanagement.service.exceptions.EntityNotFoundException;


import java.security.InvalidParameterException;
import java.util.List;

public interface AuthorService {

    void createAuthor(String firstName, String lastName) throws InvalidParameterException;

    void updateAuthor(int authorId, String firstName, String lastName) throws InvalidParameterException, EntityNotFoundException;

    void deleteAuthor(int authorId) throws EntityNotFoundException;

    List<Author> getAllAuthors();


}