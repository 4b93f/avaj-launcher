import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import Aircraft.Aircraft;
import Method.*;
import Exceptions.*;
import Exceptions.Error;


public class Main {
	public static void main(String[] args) {
		try {
			if (args.length != 1)
				throw new WrongArgumentsNumber("Usage: java Main <filename>");
			File myfile = new File(args[0]);
			Scanner reader = new Scanner(myfile);
			String content = "";

			if (!reader.hasNextLine())
			{
				reader.close();
				throw new ParsingError("File is empty");
			}
			while (reader.hasNextLine()){
				content = content.concat(reader.nextLine());
				if (reader.hasNextLine()) {
					content = content.concat("\n");
				}
			}
			reader.close();
			FileWriting.alreadyExists();
			String[] lines = content.split("\n");
			String weatherCount = lines[0];

			List<Aircraft> aircrafts = Parsing.parseContent(lines);
			if (aircrafts.isEmpty())
				throw new ParsingError("No aircrafts found in the file.");

			Flying.fly(weatherCount, aircrafts);
		}
		catch (FileNotFoundException e) {
			Error.quit("File not found : " + e.getMessage());
		}
		catch (WrongArgumentsNumber e) {
			Error.quit("Wrong arguments number : " + e.getMessage());
		}
		catch (ParsingError e) {
			Error.quit("Parsing error : " + e.getMessage());
		}
		catch (NumberFormatException e) {
			Error.quit("Number format error : " + e.getMessage());
		}
		catch (Exception e) {
			Error.quit("Parsing error : " + e.getMessage());
		}
	}
}