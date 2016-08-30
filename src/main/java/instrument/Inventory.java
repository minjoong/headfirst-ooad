package instrument;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private List<Instrument> inventory;

	public Inventory() {
		inventory = new ArrayList<>();
	}

	public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
		Instrument instrument = new Instrument(serialNumber, price, spec);
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
	
	public List<Instrument> search(InstrumentSpec searchSpec) {
		List<Instrument> machingInstruments = new ArrayList<Instrument>();
		for (Instrument instrument : inventory) {
			// 일련번호는 유일한 값이니까 무시
			// 가격은 유일한 값이니까 무시
			if (instrument.getSpec().matches(searchSpec))
				machingInstruments.add(instrument);
		}
		return machingInstruments;
	}

}
