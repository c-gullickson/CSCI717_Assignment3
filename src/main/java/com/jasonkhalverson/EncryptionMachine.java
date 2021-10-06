package com.jasonkhalverson;

import lombok.Data;

import java.util.Scanner;

//TODO: Add header comments for JavaDocs
@Data
public class EncryptionMachine {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final int SHIFT = 3;
    private String key = "";

    public void displayWelcomeMessage(){
        System.out.println("Welcome to the CSCI717 Encryption Machine Construction\n"
                + "The program lets you encrypt a message"
                + "with a key for your recipient to decrypt!");
    }

    public void retrieveKey(Scanner scanner) {
        System.out.print("Enter key: ");

        String word = scanner.nextLine();
        key = encryptWord(word);
        System.out.println("\"" + word + "\" has been encrypted to: " + key + "\n");
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

    public void displayExitMessage() {
        System.out.println("Message fully encrypted. Happy secret messaging!");
    }

    public void encryptMultipleWords(Scanner scanner) {
        int numberOfWords = getNumberOfWords(scanner);

        for(int i = 0; i < numberOfWords; i++){
            System.out.println("Next word:");
            String word = scanner.nextLine();
            System.out.println("\"" + word + "\" has been encrypted to: " + encryptWord(word) + "\n");
        }
    }

    private int getNumberOfWords(final Scanner scanner) {
        System.out.println("How many words is your message?:");
        int numberOfWords = Integer.parseInt(scanner.nextLine());
        return numberOfWords;
    }
}
