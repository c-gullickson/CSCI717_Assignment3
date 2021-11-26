package com.jasonkhalverson.TestCases;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import com.jasonkhalverson.EncryptionMachine;

public class TestJUnit_EncryptionKeys {

	EncryptionMachine encryptionMachine = new EncryptionMachine();
	Scanner scanner = new Scanner(System.in);
	

	@Test
	public void testEncryptionKey() {
		System.out.println("Inside testEncryptionKey()");    
  		String encryptionKey = "csci";
  		String encryptionKeyResult = "fvfl";
  		assertEquals(encryptionKeyResult, encryptionMachine.encryptWord(encryptionKey));    
	}
	
	@Test
	public void testRetrieveKey() {
		System.out.println("Inside testRetrieveKey()");  
		encryptionMachine.retrieveKey(scanner);

	    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		String encryptionWord_1_result = "fvfl";
  		assertContains(encryptionWord_1_result, outContent.toString() );  
  		
		String key = "fvfl";
		assertEquals(key, encryptionMachine.getKey());
	}
	
	private void assertContains(String exitMessage, String string) {
		// TODO Auto-generated method stub
	}
}
