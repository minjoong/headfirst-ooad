package instrument;

public abstract class InstrumentSpec {

	protected Builder builder;
	protected String model;
	protected Type type;
	protected Wood backWood;
	protected Wood topWood;

	public InstrumentSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	public Builder getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public Type getType() {
		return type;
	}

	public Wood getBackWood() {
		return backWood;
	}

	public Wood getTopWood() {
		return topWood;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstrumentSpec other = (InstrumentSpec) obj;
		if (backWood != other.backWood)
			return false;
		if (builder != other.builder)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (topWood != other.topWood)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}