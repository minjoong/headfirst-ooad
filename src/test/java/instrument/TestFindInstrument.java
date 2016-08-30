package instrument;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestFindInstrument {

	Inventory inventory;

	@Before
	public void init() {
		inventory = new Inventory();
		initializeInventory();
	}

	@Test
	public void test() {
		Map<String, Object> properties = new HashMap<>();
		properties.put("builder",  Builder.GIBSON);
		properties.put("backWood",  Wood.MAPLE);
		InstrumentSpec clientSpec = new InstrumentSpec(properties);
		List<Instrument> instruments = inventory.search(clientSpec);
		assertThat(instruments, hasItems(inventory.get("70108276"), inventory.get("9019920"), inventory.get("8900231")));
	}

	private void initializeInventory() {
		Map<String, Object> properties = new HashMap<>();
		properties.put("instrumentType", InstrumentType.GUITAR);
		properties.put("builder", Builder.COLLINGS);
		properties.put("model", "CJ");
		properties.put("type", Type.ACOUSTIC);
		properties.put("numStrings", 6);
		properties.put("topWood", Wood.INDIAN_ROSEWOOD);
		properties.put("backWood", Wood.SITKA);
		inventory.addInstrument("11277", 3999.95, new InstrumentSpec(properties));

		properties.put("builder", Builder.MARTIN);
		properties.put("model", "D-18");
		properties.put("topWood", Wood.MAHOGANY);
		properties.put("backWood", Wood.ADIRONDACK);
		inventory.addInstrument("122784", 5495.95, new InstrumentSpec(properties));

		properties.put("builder", Builder.FENDER);
		properties.put("model", "Stratocastor");
		properties.put("type", Type.ELECTRIC);
		properties.put("topWood", Wood.ALDER);
		properties.put("backWood", Wood.ALDER);
		inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(properties));
		inventory.addInstrument("V9512", 1549.95, new InstrumentSpec(properties));

		properties.put("builder", Builder.GIBSON);
		properties.put("model", "Les Paul");
		properties.put("topWood", Wood.MAPLE);
		properties.put("backWood", Wood.MAPLE);
		inventory.addInstrument("70108276", 2295.95, new InstrumentSpec(properties));

		properties.put("model", "SG '61 Reissue");
		properties.put("topWood", Wood.MAHOGANY);
		properties.put("backWood", Wood.MAHOGANY);
		inventory.addInstrument("82765501", 1890.95, new InstrumentSpec(properties));

		properties.put("instrumentType", InstrumentType.MANDOLIN);
		properties.put("type", Type.ACOUSTIC);
		properties.put("model", "F-5G");
		properties.put("backWood", Wood.MAPLE);
		properties.put("topWood", Wood.MAPLE);
		properties.remove("numStrings");
		inventory.addInstrument("9019920", 5495.99, new InstrumentSpec(properties));

		properties.put("instrumentType", InstrumentType.BANJO);
		properties.put("model", "RB-3 Wreath");
		properties.remove("topWood");
		properties.put("numStrings", 5);
		inventory.addInstrument("8900231", 2945.95, new InstrumentSpec(properties));
	}

}
