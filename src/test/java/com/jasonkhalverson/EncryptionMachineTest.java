package com.jasonkhalverson;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncryptionMachineTest {

    // Used to test the System.out.print functions
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    // Used to test the Scanner.in
    InputStream sysInBackup = System.in; // backup System.in to restore it later



    @BeforeEach
    public void setUpInputOutputStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        // Reset System.out
        System.setOut(originalOut);

        // Reset System.in to its original
        System.setIn(sysInBackup);
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
        EncryptionMachine encryptionMachine = new EncryptionMachine();
        String testingKey = "car";

        // Used to test the Scanner.in
        ByteArrayInputStream in = new ByteArrayInputStream(testingKey.getBytes());
        System.setIn(in);

        encryptionMachine.retrieveKey();

        assertEquals(testingKey, encryptionMachine.getKey());
        assertEquals("Enter key: \nKey is: "+testingKey+"\n", outContent.toString());

    }

    @Test
    void encryptLetter(){
        EncryptionMachine encryptionMachine = new EncryptionMachine();
        encryptionMachine.encryptLetter("a");
    }
}