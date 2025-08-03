package Exceptions;

public class WrongArgumentsNumber extends Exception {
	public WrongArgumentsNumber(String errorMessage) {
		super(errorMessage);
	}
}