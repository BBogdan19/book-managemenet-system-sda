package com.sda.bogdan.bookmanagement.controller;

import com.sda.bogdan.bookmanagement.service.AuthorService;
import com.sda.bogdan.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.Scanner;

public class AuthorController {
    private final AuthorService authorService;
    private final Scanner scanner =new Scanner(System.in);

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    public void createAuthor(){
       try {
           System.out.println("Please insert Author's first name: ");
           String firstName = scanner.nextLine();
           System.out.println("Please insert Author's last name: ");
           String lastName = scanner.nextLine();


            authorService.createAuthor(firstName,lastName);
           System.out.println("Author was created");
        } catch (InvalidParameterException e) {
           System.out.println(e.getMessage());
        }catch (Exception ex){
           System.out.println("Internal server error");
       }
    }

}
