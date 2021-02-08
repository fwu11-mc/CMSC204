
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.BooleanSupplier;
import java.util.regex.*;

public class PasswordCheckerUtility {
	
	private ArrayList<String> passwordsFromFile; 
	
	public PasswordCheckerUtility(){}
	
	public static void	comparePasswords(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException {
		
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException("The passwords do not match");
		}
	}
	
	public static boolean	comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) {
		if (password.equals(passwordConfirm)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static java.util.ArrayList<java.lang.String>	getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords){
		
		ArrayList<String> invalidPasswords = new ArrayList<>();
		
		for (int i = 0; i < passwords.size(); i++) {
			try {
				isValidPassword(passwords.get(i));
			}catch(Exception e) {
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				}
			}
		return invalidPasswords;
	}
	
	
	public static boolean	hasBetweenSixAndNineChars(java.lang.String password) {
		boolean v = false;
		if (password.length() >= 6 && password.length() <= 9) {
			v = true;
		}
		return v;
	}
	
	public static boolean	hasDigit(java.lang.String password) throws NoDigitException{
		boolean v = false;

		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
				return true;
			}
		}
			
		
		throw new NoDigitException("The password must contain at least one digit");
	}
	
	public static boolean	hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException {

		for (int i = 0; i < password.length(); i++) {
						if (password.charAt(i) >= 97 && password.charAt(i) <= 122) {
				return true;
			}
		}

		throw new NoLowerAlphaException("The password must contain at least one lower case alphabetic character");
		
	}
	
	public static boolean	hasSameCharInSequence(java.lang.String password) throws InvalidSequenceException {
		char[] arr = password.toCharArray();
        for(int i = 0; i < arr.length - 3; i++){
            if(arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2])
                throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
        }
        return true;
	}

	public static boolean	hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException{
		
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) == ' ' || password.charAt(i) == '!' || password.charAt(i) == '"' || password.charAt(i) == '#' || password.charAt(i) == '$' ||
					password.charAt(i) == '%' ||password.charAt(i) == '&' ||password.charAt(i) == '\'' ||password.charAt(i) == '(' ||
					password.charAt(i) == ')' ||password.charAt(i) == '*' ||password.charAt(i) == '+' ||password.charAt(i) == ',' ||
					password.charAt(i) == '-' ||password.charAt(i) == '.' ||password.charAt(i) == '/' ||password.charAt(i) == ';' ||
					password.charAt(i) == ':' ||password.charAt(i) == '<' ||password.charAt(i) == '=' ||password.charAt(i) == '>' ||
					password.charAt(i) == '?' ||password.charAt(i) == '@' ||password.charAt(i) == '[' ||password.charAt(i) == ']' ||
					password.charAt(i) == '\\' ||password.charAt(i) == '^' ||password.charAt(i) == '_' ||password.charAt(i) == '`' ||
					password.charAt(i) == '{' ||password.charAt(i) == '|' ||password.charAt(i) == '}' ||password.charAt(i) == '~') {
				return true;
			}
		}
		throw new NoSpecialCharacterException("The password must contain at least one special character");

	}
	
	public static boolean	hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException {
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {
				return true;
			}
		}
		throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
	}
	
	public static boolean	isValidLength(java.lang.String password) throws LengthException{
		if (password.length() >=6 ) {
			return true;
		}else {
			throw new LengthException("The password must be at least 6 characters long");
		}
	}
	
	public static boolean	isValidPassword(java.lang.String password) throws LengthException,
    NoUpperAlphaException,
    NoLowerAlphaException,
    NoDigitException,
    NoSpecialCharacterException,
    InvalidSequenceException{
		
		boolean valid = true;
		try {
			if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && !hasSameCharInSequence(password)) {
				
			}else
				valid = false;
		} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
				| NoSpecialCharacterException | InvalidSequenceException e) {
			
			throw e;
			
		}
		
		return valid;
	
		
	}
	
	public static boolean	isWeakPassword(java.lang.String password) throws WeakPasswordException{
		if (password.length() >= 6 && password.length() <= 9) {
			return true;
		}
		throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters");
	}
}
