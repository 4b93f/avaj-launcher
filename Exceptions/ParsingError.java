package Exceptions;

public class ParsingError extends Exception{
	public ParsingError (String errorMessage) {
		super(errorMessage);
	}
}
