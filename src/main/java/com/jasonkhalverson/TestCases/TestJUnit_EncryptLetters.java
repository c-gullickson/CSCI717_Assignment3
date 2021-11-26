package com.jasonkhalverson.TestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jasonkhalverson.EncryptionMachine;

public class TestJUnit_EncryptLetters {

	EncryptionMachine encryptionMachine = new EncryptionMachine();

	@Test
	public void testEncryptLetter() {
		System.out.println("Inside testEncryptLetter()");    
		char encryptionLetter = 'a';
		char encryptionLetterResult = 'd';
  		assertEquals(encryptionLetterResult, encryptionMachine.encryptLetter(encryptionLetter));    
	}
	
	@Test
	public void testEncryptLetterPast_z() {
		System.out.println("Inside testEncryptLetterPast_z()");    
		char encryptionLetter = 'y';
		char encryptionLetterResult = 'b';
  		assertEquals(encryptionLetterResult, encryptionMachine.encryptLetter(encryptionLetter));    
	}

}
