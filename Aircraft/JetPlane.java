package Aircraft;


import java.util.UUID;
// import Method.WeatherProvider;
import Method.WeatherTower;
import Method.ConsoleColor;

public class JetPlane extends Aircraft {
	public JetPlane(Long p_id, String p_name, Coordinates coordinates) {
		super(p_id != null ? p_id : UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
			p_name,
			coordinates != null ? coordinates : new Coordinates(0, 0, 0));
	}
	
	public void sunny() {
		int[] SUNNY_CHANGE = {0, 10, 2};
		coordinates.setLongitude(coordinates.getLongitude() + SUNNY_CHANGE[0]);
		coordinates.setLatitude(coordinates.getLatitude() + SUNNY_CHANGE[1]);
		coordinates.setHeight(coordinates.getHeight() + SUNNY_CHANGE[2]);
		System.out.println("JetPlane#" + name + "(" + id + ") : SUNBEAMS ! I LOVE THE SUNSHINE!");

	}
	public void rainy() {
		int[] RAIN_CHANGE = {0, 5, 0};
		coordinates.setLongitude(coordinates.getLongitude() + RAIN_CHANGE[0]);
		coordinates.setLatitude(coordinates.getLatitude() + RAIN_CHANGE[1]);
		coordinates.setHeight(coordinates.getHeight() + RAIN_CHANGE[2]);
		System.out.println("JetPlane#" + name + "(" + id + ") : LOOKS LIKE IT'S, RAINING, ARE WE IN BELGIUM ?");

	}
	public void foggy() {
		int[] FOG_CHANGE = {0, 1, 0};
		coordinates.setLongitude(coordinates.getLongitude() + FOG_CHANGE[0]);
		coordinates.setLatitude(coordinates.getLatitude() + FOG_CHANGE[1]);
		coordinates.setHeight(coordinates.getHeight() + FOG_CHANGE[2]);
		System.out.println("JetPlane#" + name + "(" + id + ") : FOG ? WHO FARTED ?");

	}
	public void snowy() {
		int[] SNOW_CHANGE = {0, 0, -7};
		coordinates.setLongitude(coordinates.getLongitude() + SNOW_CHANGE[0]);
		coordinates.setLatitude(coordinates.getLatitude() + SNOW_CHANGE[1]);
		coordinates.setHeight(coordinates.getHeight() + SNOW_CHANGE[2]);
		System.out.println("JetPlane#" + name + "(" + id + ") : Snow ? I have no good joke for this.");

	}

	public boolean checkStatus() {
		if (coordinates.getHeight() <= 0) {
			System.out.println(ConsoleColor.RED + "JetPlane has landed." + ConsoleColor.RESET);
			WeatherTower tower = new WeatherTower();
			tower.unregister(this);
			return true;
		}
		if (coordinates.getHeight() > 100)
			coordinates.setHeight(100);
		return false;
	}

	@Override
	public void updateConditions() {
		WeatherTower tower = new WeatherTower();
		// System.out.println("JetPlane conditions changed");
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
}
