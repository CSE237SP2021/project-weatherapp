package code;

public class User {
	
	private String name;
	private int favoriteZip;
	private String favoriteCity;
	
	public User(String name, int zip) {
		this.name = name;
		this.favoriteZip = zip;
		this.favoriteCity = "";
		
	}
	public User(String name, String city) {
		this.name = name;
		this.favoriteZip = -1;
		this.favoriteCity = city;
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getFavoriteZip() {
		return favoriteZip;
	}

	public String getFavoriteCity() {
		return favoriteCity;
	}
	
	public boolean favoriteIsZipCode() {
		if(favoriteZip == -1) {
			return false;
		}
		return true;
	}
}
