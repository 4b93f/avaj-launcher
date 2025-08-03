package Aircraft;

public abstract class Aircraft extends Flyable {
	protected Long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(Long p_id, String p_name, Coordinates coordinates) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = coordinates;
	}

	public void printInfo() {
		System.out.println("");
		System.out.println("Aircraft ID: " + this.id);
		System.out.println("Aircraft Name: " + this.name);
		System.out.println("Longitude: " + this.coordinates.getLongitude());
		System.out.println("Latitude: " + this.coordinates.getLatitude());
		System.out.println("Height: " + this.coordinates.getHeight()); 
	}

	public abstract void updateConditions();
	public abstract void foggy();
	public abstract void sunny();
	public abstract void rainy();
	public abstract void snowy();
	public abstract boolean checkStatus();
}
