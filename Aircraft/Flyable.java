package Aircraft;

import Method.WeatherProvider;
abstract class Flyable {
	protected WeatherProvider WeatherProvider;
	public abstract void updateConditions();
	public abstract String getName();
	public abstract Long getId();
	public abstract Coordinates getCoordinates();
	public abstract String getType();

	public void registerTower(Tower p_tower) {
		p_tower.register(this);
	}
}