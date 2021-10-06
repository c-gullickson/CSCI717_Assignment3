package com.jasonkhalverson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncryptionMachineTest {

    // Used to test the System.out.print functions
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private EncryptionMachine encryptionMachine;

    @BeforeEach
    public void setUp() {
        // Setup output stream
        System.setOut(new PrintStream(outContent));

        encryptionMachine = new EncryptionMachine();
    }

    @AfterEach
    public void restoreStreams() {
        // Reset System.out
        System.setOut(originalOut);
    }

    @Test
    void displayWelcomeMessage() {
        EncryptionMachine encryptionMachine = new EncryptionMachine();

        String displayMessage = "Welcome to the CSCI717 Encryption Machine Construction\n"
                + "The program lets you encrypt a message"
                + "with a key for your recipient to decrypt!\n";

        encryptionMachine.displayWelcomeMessage();
        assertEquals(displayMessage, outContent.toString());
    }

    @Test
    void retrieveKey(){
        String testingKey = "quick";
        String encryptedKey = "txlfn";

        encryptionMachine.retrieveKey(new Scanner(new ByteArrayInputStream(testingKey.getBytes())));

        assertEquals(encryptedKey, encryptionMachine.getKey());
        assertEquals("Enter key: \"" + testingKey + "\" has been encrypted to: "+ encryptedKey + "\n\n", outContent.toString());
    }

    @Test
    void testEncryptLetter(){
        char encryptedKey = encryptionMachine.encryptLetter('a');
        assertEquals('d', encryptedKey);
    }

    @Test
    void testEncryptLetterWrapAround(){
        char encryptedKey = encryptionMachine.encryptLetter('y');
        assertEquals('b', encryptedKey);
    }

    @Test
    void testWordEncrypt(){
        final String wordToEncrypt = "the";
        final String testEncryptedWord = "wkh";
        String encryptedWord = encryptionMachine.encryptWord(wordToEncrypt);
        assertEquals(testEncryptedWord, encryptedWord);
    }
}