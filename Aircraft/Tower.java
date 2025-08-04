package Aircraft;
import java.util.List;
import java.util.ArrayList;
import Method.FileWriting;

public class Tower {
	private List<Flyable> observers;

	public Tower() {
		observers = new ArrayList<Flyable>();
	}
	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
		FileWriting.writeToFile("Tower says : " + p_flyable.getType() + "#" + p_flyable.getName() + " registered to weather tower.");
	}
	public void unregister(Flyable p_Flyable) {
		observers.remove(p_Flyable);
		FileWriting.writeToFile("Tower says : " + p_Flyable.getType() + "#" + p_Flyable.getName() + " unregistered from weather tower.");
	}

	protected void conditionChanged(){
		for (Flyable ob : observers) {
			ob.updateConditions();
		}
	}

	public List<Flyable> getObservers() {
		return observers;
	}
}
