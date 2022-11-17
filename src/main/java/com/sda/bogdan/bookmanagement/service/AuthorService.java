package com.sda.bogdan.bookmanagement.service;

import com.sda.bogdan.bookmanagement.service.exceptions.InvalidParameterException;

public interface AuthorService {
    void createAuthor(String firstName, String lastName) throws InvalidParameterException;
}
