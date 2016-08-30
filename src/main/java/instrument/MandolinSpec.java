package instrument;

public class MandolinSpec extends InstrumentSpec {
	
	private Style style;

	public MandolinSpec(Builder builder, String model, Type type, Style style, Wood backWood, Wood topWood) {
		super(builder, model, type, backWood, topWood);
		this.style = style;
	}

	public Style getStyle() {
		return style;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MandolinSpec other = (MandolinSpec) obj;
		if (style != other.style)
			return false;
		return true;
	}

}
