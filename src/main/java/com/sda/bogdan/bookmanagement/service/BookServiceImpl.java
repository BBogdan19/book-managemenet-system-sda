package com.sda.bogdan.bookmanagement.service;

import com.sda.bogdan.bookmanagement.model.Author;
import com.sda.bogdan.bookmanagement.model.Book;
import com.sda.bogdan.bookmanagement.repository.AuthorRepository;
import com.sda.bogdan.bookmanagement.repository.BookRepository;
import com.sda.bogdan.bookmanagement.service.exceptions.EntityNotFoundException;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void createBook(String title, String description, int authorId) throws EntityNotFoundException {
        if (title == null || title.isBlank() || title.length() < 4) {
            throw new InvalidParameterException("Provided value for first name: " + title + " is invalid");
        }
        if (description == null || description.isBlank() || description.length() < 3) {
            throw new InvalidParameterException("Provided value for first name: " + description + " is invalid");
        }
        if (authorId < 1) {
            throw new InvalidParameterException("Provided value for author id: " + authorId + " is invalid");
        }
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with provided id: " + authorId + "not existent!");
        }
        Author author = authorOptional.get();

        Book book = new Book(title, description);
        book.setAuthor(author);
        bookRepository.create(book);

    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}