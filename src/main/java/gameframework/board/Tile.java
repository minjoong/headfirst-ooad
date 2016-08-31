package gameframework.board;

import java.util.ArrayList;
import java.util.List;

import gameframework.unit.Unit;

public class Tile {

	private List<Unit> units;

	public Tile() {
		units = new ArrayList<>();
	}

	protected void addUnit(Unit unit) {
		units.add(unit);
	}

	protected void removeUnit(Unit unit) {
		units.remove(unit);
	}

	protected void removeUnits() {

	}

	protected List<Unit> getUnits() {
		return units;
	}

}
