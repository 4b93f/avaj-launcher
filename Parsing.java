import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Aircraft.*;
import Exceptions.*;



public class Parsing {
	public static List<Aircraft> parseContent(String[] content) throws ParsingError {
		List<Aircraft> fly = new ArrayList<Aircraft>();
		
		content = Arrays.copyOfRange(content, 1, content.length);
			for (String line : content) 
				fly.add(processLine(line));

		return fly;
	}

	public static Aircraft processLine(String line) throws ParsingError, NumberFormatException {

		String[] word = line.split(" ");
		String type, name, longitude, latitude, height;

		if (word.length != 5)
			throw new ParsingError("Invalid line format: " + line);
		for (int i = 2; i < word.length; i++) {
			if (Integer.parseInt(word[i]) <= 0)
				throw new ParsingError("Coordinates must be positive intergers : Exiting ...");
		}

		type = word[0];
		name = word[1];
		longitude = word[2];
		latitude = word[3];
		height = word[4];

		Coordinates coord = CoordinatesFactory.createCoordinates(
			Integer.parseInt(longitude), 
			Integer.parseInt(latitude), 
			Integer.parseInt(height)
		);

		if (coord.getHeight() > 100)
			throw new ParsingError("Height must be inferior or equal to 100 : Exiting ...");
			
		AircraftFactory factory = AircraftFactory.getInstance();
		
		return (Aircraft) factory.newAircraft(type, name, coord);
	}
}
