package com.jasonkhalverson;

import java.util.Scanner;

/**
 * Encryption machine built for CSCI 717
 * <p>
 *  This class handles the display and encryption of a key and several words
 * </p>
 * @author Jason Halverson
 */
public class EncryptionMachine {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final int SHIFT = 3;
    private String key = "";

    public void displayWelcomeMessage(){
        System.out.println("Welcome to the CSCI717 Encryption Machine Construction\n"
                + "The program lets you encrypt a message"
                + "with a key for your recipient to decrypt!");
    }

    /**
     * Retrieve the key for future decryption
     * @param scanner
     */
    public void retrieveKey(Scanner scanner) {
        System.out.print("Enter key: ");

        String word = scanner.nextLine();
        key = encryptWord(word);
        System.out.println("\"" + word + "\" has been encrypted to: " + key + "\n");
    }

    /**
     * Encrypts a single char utilizing the Caesar shift cypher
     * <p>
     *     The shift value is currently statically set.
     * <p/>
     * @param character to encrypt
     * @return char is the encrypted value.
     */
    public char encryptLetter(final char character) {

        int indexOfLetter = character - ALPHABET.charAt(0);

        int indexOfShiftedLetter = (indexOfLetter + SHIFT) % ALPHABET.length();

        return (char) (indexOfShiftedLetter + ALPHABET.charAt(0));
    }

    /**
     *
     * @param word to encrypt letter by letter
     * @return encrypted string
     * @see encryptLetter()
     */
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

    /**
     * Encrypts multiple words based on the input the user.
     * @param scanner
     */
    public void encryptMultipleWords(Scanner scanner) {
        int numberOfWords = getNumberOfWords(scanner);

        for(int i = 0; i < numberOfWords; i++){
            System.out.println("Next word:");
            String word = scanner.nextLine();
            System.out.println("\"" + word + "\" has been encrypted to: " + encryptWord(word) + "\n");
        }
    }

    /**
     *
     * @param scanner to retrieve input
     * @return number of words to be encrypted.
     */
    private int getNumberOfWords(final Scanner scanner) {
        System.out.println("How many words is your message?:");
        int numberOfWords = Integer.parseInt(scanner.nextLine());
        return numberOfWords;
    }

    public String getKey() {return this.key;}
}
