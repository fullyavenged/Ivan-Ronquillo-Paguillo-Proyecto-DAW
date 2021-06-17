package model;

public enum Status {

	WATCHING, COMPLETED, DROPPED;
	
	
	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase();
	}

}
