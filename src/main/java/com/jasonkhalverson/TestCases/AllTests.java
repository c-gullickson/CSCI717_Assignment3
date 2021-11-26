package com.jasonkhalverson.TestCases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({TestJUnit_EncryptionMachine.class, TestJUnit_DisplayMessages.class, TestJUnit_EncryptLetters.class, TestJUnit_EncryptionKeys.class})

public class AllTests {
}
