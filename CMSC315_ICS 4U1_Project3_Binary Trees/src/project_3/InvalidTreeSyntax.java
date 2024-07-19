package project_3;

/**
 * @author Kelvin Njenga
 * Date: September 26, 2023
 * This is the class that catches errors when an invalid input is made and throws the syntax exceptions.
 */
public class InvalidTreeSyntax extends Exception {
	private static final long serialVersionUID = 96938660376398391L;

	public InvalidTreeSyntax(String message) {
        super(message);
    }
}
