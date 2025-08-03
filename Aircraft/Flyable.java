package Aircraft;

import Method.WeatherProvider;

abstract class Flyable {
	protected WeatherProvider WeatherProvider;
	public abstract void updateConditions();
	public abstract String getName();
	public abstract Long getId();
	public abstract Coordinates getCoordinates();
	public void registerTower(Tower p_tower) {
		String name = this.getName();
		Long id = this.getId();
		Coordinates coordinates = this.getCoordinates();
		p_tower.register(this);
		System.out.println("Flyable " + name + "(" + id + ") registered to weather tower at coordinates: " +
			"Longitude: " + coordinates.getLongitude() +
			", Latitude: " + coordinates.getLatitude() +
			", Height: " + coordinates.getHeight());
	}
}