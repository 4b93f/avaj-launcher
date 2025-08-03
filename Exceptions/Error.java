package Exceptions;

public class Error {
	public static void quit(String errorMessage) {
		System.out.println(errorMessage);
		System.exit(1);
	}
}
