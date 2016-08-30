package instrument;

import java.util.HashMap;
import java.util.Map;

public class InstrumentSpec {

	private Map<String, Object> properties;

	public InstrumentSpec(Map<String, Object> properties) {
		if (properties == null) {
			this.properties = new HashMap<>();
		} else {
			this.properties = new HashMap<>(properties);
		}
	}

	public Object getProperty(String propertyName) {
		return properties.get(propertyName);
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public boolean matches(InstrumentSpec otherSpec) {
		for (String propertyName : otherSpec.getProperties().keySet()) {
			if (!properties.get(propertyName).equals(otherSpec.getProperty(propertyName)))
				return false;
		}
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof InstrumentSpec))
			return false;
		InstrumentSpec other = (InstrumentSpec) obj;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		return true;
	}

}