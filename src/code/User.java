package code;

public class User {
	
	private String name;
	private double favoriteZip;
	private String favoriteCity;
	
	public User(String name, double zip) {
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
	
	public double getFavoriteZip() {
		return favoriteZip;
	}

	public String getFavoriteCity() {
		return favoriteCity;
	}
}
