package gameframework.unit;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestUnitGroup {

	private UnitGroup unitGroup;

	@Test
	public void testCreateUnitGroupFromUnitList() {
		List<Unit> units = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			units.add(new Unit(i));
		}
		unitGroup = new UnitGroup(units);
		assertEquals(units, unitGroup.getUnits());
	}

	@Test
	public void testAddUnit() {
		unitGroup = new UnitGroup();
		Unit unit = new Unit(100);
		unitGroup.addUnit(unit);
		assertEquals(unit, unitGroup.getUnit(100));
	}

	@Test
	public void testRemoveUnitById() {
		unitGroup = new UnitGroup();
		Unit unit = new Unit(100);
		unitGroup.addUnit(unit);
		unitGroup.removeUnit(100);
		assertThat(unitGroup.getUnits(), not(hasItem(unit)));
	}

	@Test
	public void testRemoveUnitByUnitInstance() {
		unitGroup = new UnitGroup();
		Unit unit = new Unit(100);
		unitGroup.addUnit(unit);
		unitGroup.removeUnit(unit);
		assertThat(unitGroup.getUnits(), not(hasItem(unit)));
	}

}
