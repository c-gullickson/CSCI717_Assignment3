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

    public void retrieveKey(Scanner scanner) {
        System.out.println("Enter key: ");

        StringBuilder retrievedKey = new StringBuilder();

        while(scanner.hasNext()){
            retrievedKey.append(scanner.next());
        }

        key = retrievedKey.toString();
        System.out.println("Key is: " + key);
    }

    public char encryptLetter(final char character) {

        int indexOfLetter = character - ALPHABET.charAt(0);

        int indexOfShiftedLetter = (indexOfLetter + SHIFT) % 26;

        return (char) (indexOfShiftedLetter + ALPHABET.charAt(0));
    }
}
