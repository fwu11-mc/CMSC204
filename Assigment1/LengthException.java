
public class LengthException extends Exception {

	public LengthException() {
		super("The password must be at least 8 characters long");
	}
	public LengthException(String message) {
		
		super(message);
	}
}
