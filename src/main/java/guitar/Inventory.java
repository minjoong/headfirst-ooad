package guitar;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private List<Guitar> guitars;

	public Inventory() {
		guitars = new ArrayList<Guitar>();
	}

	public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
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
			if (guitar.getSpec().equals(searchSpec))
				machingGuitars.add(guitar);
		}
		return machingGuitars;
	}

}
