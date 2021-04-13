package code;

import java.io.IOException;
import java.lang.InterruptedException;

public class Location {
	private int zipCode;
	private String locationName;
	private boolean hasZipCode;
	private boolean hasLocationName;
	private WeatherData weatherGetter = new WeatherData();

	public Location(int zip){
		this.zipCode = zip;
		this.hasZipCode = true;
		this. hasLocationName = false;
		this.locationName = "";
		//weatherAtLocation = 
	}

	public Location(String place){
		this.locationName = place;
		this.hasZipCode = false;
		this.hasLocationName = true;
		this.zipCode = 0;
	}

	public String getWeather() throws IOException, InterruptedException{
		if(hasZipCode()) {
			System.out.println("has zip code");
			String ret = weatherGetter.makeRequest(String.valueOf(zipCode));
			return ret; 
		}
		return "no zip code";
	}
	
	public boolean hasZipCode() {
		if(zipCode == -1) {
			return false;
		}
		return true;
	}
}
