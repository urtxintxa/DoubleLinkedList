package org.minakdev.DoubleLinkedList;

public class Pertsona implements Comparable<Pertsona> {
	
	// atributuak
	private String name;
        private String na;
	
	public Pertsona(String pName, String pNa) { // Eraikitzailea
		name = pName;
		na = pNa;
	}
	
	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getNA() { return NA; }

	public void setNa(String na) { this.na = na; }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (na == null) {
			if (other.na != null)
				return false;
		} else if (!na.equals(other.na))
			return false;
		return true;
	}
			
	@Override
	public int compareTo(Pertsona arg0) {
		return name.compareToIgnoreCase(arg0.name);
	}

	public String toString() {
		return name + " " + na;
	}
	
} // end Pertsona
