package Aircraft;

public class CoordinatesFactory {
	public static Coordinates createCoordinates(int p_longitude, int p_latitude, int p_height) {
		return new Coordinates(p_longitude, p_latitude, p_height);
	}
}
	