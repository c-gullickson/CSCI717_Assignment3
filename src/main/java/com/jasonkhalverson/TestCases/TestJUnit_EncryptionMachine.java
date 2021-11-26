package com.jasonkhalverson.TestCases;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;
import com.jasonkhalverson.EncryptionMachine;


public class TestJUnit_EncryptionMachine {

	EncryptionMachine encryptionMachine = new EncryptionMachine();
	Scanner scanner = new Scanner(System.in);
			
	
	@Test
	public void testGetNumberOfWords() {
		System.out.println("Inside testGetNumberOfWords()");  
		encryptionMachine.encryptMultipleWords(scanner);

	    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		String encryptionWord_1_result = "khoor";
  		assertContains(encryptionWord_1_result, outContent.toString() );    
	}
	
	
	private void assertContains(String exitMessage, String string) {
		// TODO Auto-generated method stub
	}
}
