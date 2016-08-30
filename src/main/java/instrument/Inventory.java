package instrument;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private List<Instrument> inventory;

	public Inventory() {
		inventory = new ArrayList<>();
	}

	public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
		Instrument instrument = null;
		if (spec instanceof GuitarSpec) {
			instrument = new Guitar(serialNumber, price, (GuitarSpec) spec);
		} else if (spec instanceof MandolinSpec) {
			instrument = new Mandolin(serialNumber, price, (MandolinSpec) spec);
		}
		inventory.add(instrument);
	}

	public Instrument get(String serialNumber) {
		for (Instrument instrument : inventory) {
			if (instrument.getSerialNumber().equals(serialNumber)) {
				return instrument;
			}
		}
		return null;
	}

	public List<Guitar> search(GuitarSpec searchSpec) {
		List<Guitar> machingGuitars = new ArrayList<Guitar>();
		for (Instrument instrument : inventory) {
			// 일련번호는 유일한 값이니까 무시
			// 가격은 유일한 값이니까 무시
			if (instrument.getSpec().equals(searchSpec))
				machingGuitars.add((Guitar) instrument);
		}
		return machingGuitars;
	}
	
	public List<Mandolin> search(Mandolin searchSpec) {
		List<Mandolin> machingMandolins = new ArrayList<Mandolin>();
		for (Instrument instrument : inventory) {
			// 일련번호는 유일한 값이니까 무시
			// 가격은 유일한 값이니까 무시
			if (instrument.getSpec().equals(searchSpec))
				machingMandolins.add((Mandolin) instrument);
		}
		return machingMandolins;
	}

}
