package gameframework.unit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestUnit {

	private Unit unit;

	@Before
	public void init() {
		unit = new Unit(1000);
	}

	/**
	 * Testing getting the id property.
	 */
	@Test
	public void testId() {
		assertEquals(1000, unit.getId());
	}

	/**
	 * Testing setting/getting the type property.
	 */
	@Test
	public void testType() {
		unit.setType("infantry");
		assertEquals("infantry", unit.getType());
	}

	/**
	 * Testing setting/getting the weapons property.
	 */
	@Test
	public void testWeapons() {
		Weapon axe = new Weapon();
		unit.addWeapon(axe);
		assertThat(unit.getWeapons(), is(notNullValue()));
		assertThat(unit.getWeapons(), hasItem(axe));
	}

	/**
	 * Testing setting/getting a unit-specific property.
	 * 
	 * @throws IllegalAccessException
	 */
	@Test
	public void testUnitSpecificProperty() throws IllegalAccessException {
		unit.setProperty("hitPoints", 25);
		assertEquals(25, unit.getProperty("hitPoints"));
	}

	/**
	 * Testing changing an existing property's value.
	 * 
	 * @throws IllegalAccessException
	 */
	@Test
	public void testChangeProperty() throws IllegalAccessException {
		unit.setProperty("hitPoints", 25);
		unit.setProperty("hitPoints", 15);
		assertEquals(15, unit.getProperty("hitPoints"));
	}

	/**
	 * Testing getting a non-existent property's value.
	 * 
	 * @throws IllegalAccessException
	 */
	@Test(expected = IllegalAccessException.class)
	public void testNonExistentProperty() throws IllegalAccessException {
		unit.getProperty("strength");
	}

}
