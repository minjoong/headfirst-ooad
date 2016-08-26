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
		Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
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
	
	public List<Guitar> search(Guitar searchGuitar) {
		List<Guitar> machingGuitars = new ArrayList<Guitar>();
		for (Guitar guitar : guitars) {
			// 일련번호는 유일한 값이니까 무시
			// 가격은 유일한 값이니까 무시
			
			if (searchGuitar.getBuilder() != guitar.getBuilder())
				continue;
			String model = searchGuitar.getModel().toLowerCase();
			if ((model != null) && (!model.equals("")) && (!model.equals(guitar.getModel().toLowerCase())))
				continue;
			if (searchGuitar.getType() != guitar.getType())
				continue;
			if (searchGuitar.getBackWood() != guitar.getBackWood())
				continue;
			if (searchGuitar.getTopWood() != guitar.getTopWood())
				continue;
			machingGuitars.add(guitar);
		}
		return machingGuitars;
	}

}
