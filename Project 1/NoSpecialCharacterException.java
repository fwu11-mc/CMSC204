
public class NoSpecialCharacterException extends Exception{
	public NoSpecialCharacterException() {
		// TODO Auto-generated constructor stub
		super("The password must contain at least one special character");
	}
	public NoSpecialCharacterException(String message) {
		super(message);
	}

}
