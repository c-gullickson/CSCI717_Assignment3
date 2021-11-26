package com.jasonkhalverson.TestCases;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.jasonkhalverson.EncryptionMachine;

public class TestJUnit_DisplayMessages {

	EncryptionMachine encryptionMachine = new EncryptionMachine();

	@Test
	public void testWelcomeMessage() {
		System.out.println("Inside testWelcomeMessage()");  
		encryptionMachine.displayWelcomeMessage();
	    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		String welcomeMessage = "Welcome to the CSCI717 Encryption Machine Construction";
		
  		assertContains(welcomeMessage, outContent.toString());    
	}
	
	@Test
	public void testExitMessage() {
		System.out.println("Inside testExitMessage()");  
		encryptionMachine.displayExitMessage();
	    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		String exitMessage = "Message fully encrypted. Happy secret messaging!";
		
  		assertContains(exitMessage, outContent.toString());    
	}

	private void assertContains(String welcomeMessage, String string) {
		// TODO Auto-generated method stub
		
	}
}
