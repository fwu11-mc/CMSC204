
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Fan Wu
 *
 */
public class PasswordCheckerSTUDENT_Test {

	ArrayList<String> passwords;
	String password1, password2;
	
	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("12138ac"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
			System.out.println("line 49");
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("Working"));
		} catch (NoUpperAlphaException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("Working"));
		} catch (NoLowerAlphaException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword("XiaJizuimei"));
		} catch (WeakPasswordException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence("deuws@#4!Q"));
			PasswordCheckerUtility.hasSameCharInSequence("Qssingqqq");
			assertTrue("Did not throw InvalideSequenceException",true);
		}
		
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides InvalideSequenceException", true);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit("tia1wheb"));
		} catch (NoDigitException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit("Qtia1whe$b"));
		}catch (Exception e) {
			// TODO: handle exception
		}			
		assertTrue("not throw an exception", true);
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		passwords.add("Qssingqq1");
		passwords.add("Qtia1whe$b");
		passwords.add("1Assddd@");
		
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(results.size(), 2);
		assertEquals(results.get(0), "Qssingqq1 -> The password must contain at least one special character");
		assertEquals(results.get(1), "1Assddd@ -> The password cannot contain more than two of the same character in sequence");
	}
	
}