package Method;
import Aircraft.Aircraft;
import Aircraft.Tower;

import java.util.List;

public class Flying {
	public static void fly(String weatherCount, List<Aircraft> aircrafts) {
		int wcount = Integer.parseInt(weatherCount);
		if (wcount <= 0)
			throw new IllegalArgumentException("Weather count must be a positive integer.");
		if (aircrafts == null || aircrafts.isEmpty()) {
			System.out.println("No aircrafts to fly.");
			return;
		}
		Tower tower = new Tower();
		for (Aircraft air: aircrafts)
			air.registerTower(tower);
		for (int i = 0; i < wcount; i++)
		{
			for (Aircraft air: aircrafts)
			{
				if (tower.getObservers().contains(air) == false)
					continue;
				air.updateConditions();
				if (air.checkStatus()) {
					tower.unregister(air);
					
				}
			}
		}
	}
}
