package Aircraft;

import java.util.UUID;
// import Method.WeatherProvider;
import Method.WeatherTower;
import Method.ConsoleColor;

public class Helicopter extends Aircraft{
	public Helicopter(Long p_id, String p_name, Coordinates coordinates) {
		super(p_id != null ? p_id : UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
			p_name,
			coordinates != null ? coordinates : new Coordinates(0, 0, 0));
	}
	
	public void sunny() {
		int[] SUNNY_CHANGE = {10, 0, 2};
		coordinates.setLongitude(coordinates.getLongitude() + SUNNY_CHANGE[0]);
		coordinates.setLatitude(coordinates.getLatitude() + SUNNY_CHANGE[1]);
		coordinates.setHeight(coordinates.getHeight() + SUNNY_CHANGE[2]);
		System.out.println("Helicopter#" + name + "(" + id + ") : IT'S SUNNY, BOND, I'M COMING TO SAVE YOU!");

	}
	public void rainy() {
		int[] RAIN_CHANGE = {5, 0, 0};
		coordinates.setLongitude(coordinates.getLongitude() + RAIN_CHANGE[0]);
		coordinates.setLatitude(coordinates.getLatitude() + RAIN_CHANGE[1]);
		coordinates.setHeight(coordinates.getHeight() + RAIN_CHANGE[2]);
		System.out.println("Helicopter#" + name + "(" + id + ") : IT'S RAINING, BUT I'M STILL FLYING!");

	}
	public void foggy() {
		int[] FOG_CHANGE = {1, 0, 0};
		coordinates.setLongitude(coordinates.getLongitude() + FOG_CHANGE[0]);
		coordinates.setLatitude(coordinates.getLatitude() + FOG_CHANGE[1]);
		coordinates.setHeight(coordinates.getHeight() + FOG_CHANGE[2]);
		System.out.println("Helicopter#" + name + "(" + id + ") : GOOFY FOGGY, I CAN'T SEE SH*T!");

	}
	public void snowy() {
		int[] SNOW_CHANGE = {0, 0, -12};
		coordinates.setLongitude(coordinates.getLongitude() + SNOW_CHANGE[0]);
		coordinates.setLatitude(coordinates.getLatitude() + SNOW_CHANGE[1]);
		coordinates.setHeight(coordinates.getHeight() + SNOW_CHANGE[2]);
		System.out.println("Helicopter#" + name + "(" + id + ") : ELSA ? JE VOUDRAIS UN BONHOMME DE NEIGE !");

	}

	public boolean checkStatus() {
		if (coordinates.getHeight() <= 0) {
			System.out.println(ConsoleColor.RED + "Helicopter has landed." + ConsoleColor.RESET);
			return true;
		}
		if (coordinates.getHeight() > 100)
			coordinates.setHeight(100);
		return false;
	}

	@Override
	public void updateConditions() {
		WeatherTower tower = new WeatherTower();
		// System.out.println("Helicopter conditions changed");
		switch (tower.getWeather(coordinates)) {
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

	public String getName() {
		return this.name;
	}
	public Long getId() {
		return this.id;
	}
	public Coordinates getCoordinates() {
		return this.coordinates;
	}
}
