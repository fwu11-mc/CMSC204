
public class NoLowerAlphaException extends Exception{

	public NoLowerAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
	
	public NoLowerAlphaException (String message) {
		super(message);
	}

}
