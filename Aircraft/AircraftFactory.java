package Aircraft;

public class AircraftFactory {
	public final static AircraftFactory instance = new AircraftFactory();
	
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		switch (p_type) {
			case "Baloon":
				return new Baloon(null, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(null, p_name, p_coordinates);
			case "Helicopter":
				return new Helicopter(null, p_name, p_coordinates);
			default:
				return null;
		}
	}
	
	public static AircraftFactory getInstance() {
		return instance;
	}

}
