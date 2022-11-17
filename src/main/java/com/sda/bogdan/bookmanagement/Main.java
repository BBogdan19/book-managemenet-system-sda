package com.sda.bogdan.bookmanagement;

import com.sda.bogdan.bookmanagement.controller.AuthorController;
import com.sda.bogdan.bookmanagement.menu.UserOption;
import com.sda.bogdan.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.bogdan.bookmanagement.service.AuthorServiceImpl;
import com.sda.bogdan.bookmanagement.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();

        AuthorController authorController = new AuthorController(new AuthorServiceImpl( new AuthorRepositoryImpl()));

        Scanner scanner = new Scanner(System.in);
        UserOption.printAllOptions();


        UserOption userOption = UserOption.UNKNOW;
        do {
            userOption.printAllOptions();
            System.out.println("Please insert an option! ");
            try {
                int numericOption = Integer.parseInt(scanner.nextLine());
                userOption = UserOption.findUserOption(numericOption);
            } catch (NumberFormatException e) {
                userOption = UserOption.UNKNOW;
            }
            switch (userOption) {
                case CREATE_AUTHOR:
                    authorController.createAuthor();
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
                case UNKNOW:
                    System.out.println("Option unknow");
                    break;
                default:
                    System.out.println("User option " + userOption + " is not implemented ");
            }
        } while (userOption != userOption.EXIT);

    SessionManager.shutDown();



    }

}
