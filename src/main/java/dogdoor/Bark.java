package dogdoor;

public class Bark {
	
	private String sound;
	
	public Bark(String sound) {
		this.sound = sound;
	}
	
	public String getSound() {
		return sound;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bark other = (Bark) obj;
		if (sound == null) {
			if (other.sound != null)
				return false;
		} else if (!sound.equals(other.sound))
			return false;
		return true;
	}
	
	

}
