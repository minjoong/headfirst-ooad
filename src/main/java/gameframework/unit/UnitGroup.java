package gameframework.unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitGroup {

	private Map<Integer, Unit> units;

	public UnitGroup(List<Unit> unitList) {
		units = new HashMap<>();
		for (Unit unit : unitList) {
			units.put(unit.getId(), unit);
		}
	}

	public UnitGroup() {
		this(new ArrayList<>());
	}

	public void addUnit(Unit unit) {
		units.put(unit.getId(), unit);
	}

	public void removeUnit(int id) {
		units.remove(id);
	}

	public void removeUnit(Unit unit) {
		removeUnit(unit.getId());
	}

	public Unit getUnit(int id) {
		return units.get(id);
	}

	public List<Unit> getUnits() {
		return new ArrayList<>(units.values());
	}

}
