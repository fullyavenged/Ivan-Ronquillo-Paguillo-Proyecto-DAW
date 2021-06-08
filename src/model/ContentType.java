package model;


public enum ContentType {

	ANIME, MANGA;
	
	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase();
	}

}
