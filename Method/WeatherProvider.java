package Method;
import Aircraft.Coordinates;

public class WeatherProvider {
	private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
	private static final WeatherProvider instance = new WeatherProvider();

	public String getCurrentWeather(Coordinates p_coordinates) {
		int val = p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude();
		return weather[val % 4];
	}

	private WeatherProvider() {}

	public static WeatherProvider getInstance(){
		return instance;
	}
}