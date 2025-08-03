package Method;
import Aircraft.Coordinates;

public class WeatherProvider {
	private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
	private static final WeatherProvider instance = new WeatherProvider();

	private WeatherProvider() {}

	public String getCurrentWeather(Coordinates p_coordinates) {
		int val = p_coordinates.getLatitude() + p_coordinates.getLongitude() + p_coordinates.getHeight();
		return weather[val % 4];
	}

	public static WeatherProvider getInstance(){
		return instance;
	}
}