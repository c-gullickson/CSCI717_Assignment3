package com.jasonkhalverson;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EncryptionMachine encryptionMachine = new EncryptionMachine();
        Scanner scanner = new Scanner(System.in);

        encryptionMachine.displayWelcomeMessage();

        encryptionMachine.retrieveKey(scanner);

        encryptionMachine.encryptMultipleWords(scanner);

        encryptionMachine.displayExitMessage();
    }
}
