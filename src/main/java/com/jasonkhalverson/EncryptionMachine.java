package com.jasonkhalverson;

import lombok.Data;

import java.util.Scanner;

@Data
public class EncryptionMachine {
    private String key = "";
    private final int SHIFT = 3;
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public void displayWelcomeMessage(){
        String displayMessage = "Welcome to the CSCI717 Encryption Machine Construction\n"
                + "The program lets you encrypt a message"
                + "with a key for your recipient to decrypt!";
        System.out.println(displayMessage);
    }

    public void retrieveKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter key: ");

        while(scanner.hasNext()){
            key += scanner.next();
        }

        System.out.println("Key is: " + key);
    }

    public void encryptLetter(final String a) {

    }
}
