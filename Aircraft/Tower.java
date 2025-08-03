package Aircraft;
import java.util.List;
import java.util.ArrayList;

public class Tower {
	private List<Flyable> observers;

	public Tower() {
		observers = new ArrayList<Flyable>();
	}
	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
	}
	public void unregister(Flyable p_Flyable) {
		observers.remove(p_Flyable);
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
