package com.jasonkhalverson;

import lombok.Data;

import java.util.Scanner;

@Data
public class EncryptionMachine {
    private String key = "";
    private final int SHIFT = 3;
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public void displayWelcomeMessage(){
        System.out.println("Welcome to the CSCI717 Encryption Machine Construction\n"
                + "The program lets you encrypt a message"
                + "with a key for your recipient to decrypt!");
    }

    public void retrieveKey(Scanner scanner) {
        System.out.print("Enter key: ");

        key = encryptWord(scanner.nextLine());
        System.out.println("Key is: " + key);
    }

    public char encryptLetter(final char character) {

        int indexOfLetter = character - ALPHABET.charAt(0);

        int indexOfShiftedLetter = (indexOfLetter + SHIFT) % ALPHABET.length();

        return (char) (indexOfShiftedLetter + ALPHABET.charAt(0));
    }

    public String encryptWord(String word) {
        StringBuilder encryptedWord = new StringBuilder();

        for(char letter: word.toCharArray()){
            encryptedWord.append(encryptLetter(letter));
        }

        return encryptedWord.toString();
    }
}
