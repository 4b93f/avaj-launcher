package Aircraft;

import java.util.UUID;
import Method.WeatherTower;
import Method.FileWriting;

public class Baloon extends Aircraft {
	String type = "Baloon";

	public Baloon(Long p_id, String p_name, Coordinates coordinates) {
		super(p_id != null ? p_id : UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
			p_name,
			coordinates != null ? coordinates : new Coordinates(0, 0, 0));
	}

	public void sunny() {
		int[] SUNNY_CHANGE = {2, 0, 4};
		coordinates.setLongitude(coordinates.getLongitude() + SUNNY_CHANGE[0]);
		coordinates.setLatitude(coordinates.getLatitude() + SUNNY_CHANGE[1]);
		coordinates.setHeight(coordinates.getHeight() + SUNNY_CHANGE[2]);
		FileWriting.writeToFile("Baloon#" + name + "(" + id + ") : IT'S SUNNY, MY BALLOON IS SHINING!");

	}
	public void rainy() {
		int[] RAIN_CHANGE = {0, 0, 5};
		coordinates.setLongitude(coordinates.getLongitude() + RAIN_CHANGE[0]);
		coordinates.setLatitude(coordinates.getLatitude() + RAIN_CHANGE[1]);
		coordinates.setHeight(coordinates.getHeight() + RAIN_CHANGE[2]);
		FileWriting.writeToFile("Baloon#" + name + "(" + id + ") : F*** OFF, IT'S RAINING, MY BALLOON ARE WET!");

	}
	public void foggy() {
		int[] FOG_CHANGE = {0, 0, -3};
		coordinates.setLongitude(coordinates.getLongitude() + FOG_CHANGE[0]);
		coordinates.setLatitude(coordinates.getLatitude() + FOG_CHANGE[1]);
		coordinates.setHeight(coordinates.getHeight() + FOG_CHANGE[2]);
		FileWriting.writeToFile("Baloon#" + name + "(" + id + ") : IT'S FOGGY, I CAN'T SEE ANYTHING!");

	}
	public void snowy() {
		int[] SNOW_CHANGE = {0, 0, -15};
		coordinates.setLongitude(coordinates.getLongitude() + SNOW_CHANGE[0]);
		coordinates.setLatitude(coordinates.getLatitude() + SNOW_CHANGE[1]);
		coordinates.setHeight(coordinates.getHeight() + SNOW_CHANGE[2]);
		FileWriting.writeToFile("Baloon#" + name + "(" + id + ") : IT'S SNOWING, WEIRD, WHERE ARE MY CHRISTMAS PRESENTS?");

	}

	public boolean checkStatus() {
		if (coordinates.getHeight() <= 0) {
			FileWriting.writeToFile("Baloon has landed.");
			return true;
		}
		if (coordinates.getHeight() > 100)
			coordinates.setHeight(100);
		return false;
	}

	@Override
	public void updateConditions() {
		WeatherTower tower = new WeatherTower();
		String meteo = tower.getWeather(coordinates);

		switch (meteo) {
			case "FOG":
				foggy();
				break;
			case "SUN":
				sunny();
				break;
			case "RAIN":
				rainy();
				break;
			case "SNOW":
				snowy();
				break;
			default:
				break;
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public Coordinates getCoordinates() {
		return this.coordinates;
	}

	@Override
	public String getType() {
		return this.type;
	}
}
