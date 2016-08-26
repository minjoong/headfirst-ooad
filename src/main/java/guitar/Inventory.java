package guitar;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private List<Guitar> guitars;

	public Inventory() {
		guitars = new ArrayList<Guitar>();
	}

	public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood,
			Wood topWood) {
		GuitarSpec spec = new GuitarSpec(builder, model, type, backWood, topWood);
		Guitar guitar = new Guitar(serialNumber, price, spec);
		guitars.add(guitar);
	}

	public Guitar getGuitar(String serialNumber) {
		for (Guitar guitar : guitars) {
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;
	}

	public List<Guitar> search(GuitarSpec searchSpec) {
		List<Guitar> machingGuitars = new ArrayList<Guitar>();
		for (Guitar guitar : guitars) {
			// 일련번호는 유일한 값이니까 무시
			// 가격은 유일한 값이니까 무시

			GuitarSpec guitarSpec = guitar.getSpec();

			if (searchSpec.getBuilder() != guitarSpec.getBuilder())
				continue;
			String model = searchSpec.getModel().toLowerCase();
			if ((model != null) && (!model.equals("")) && (!model.equals(guitarSpec.getModel().toLowerCase())))
				continue;
			if (searchSpec.getType() != guitarSpec.getType())
				continue;
			if (searchSpec.getBackWood() != guitarSpec.getBackWood())
				continue;
			if (searchSpec.getTopWood() != guitarSpec.getTopWood())
				continue;
			machingGuitars.add(guitar);
		}
		return machingGuitars;
	}

}
