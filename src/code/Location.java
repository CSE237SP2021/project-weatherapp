package code;

import java.io.IOException;
import java.lang.InterruptedException;

public class Location {
	private int zipCode;
	private String locationName;
<<<<<<< HEAD
	private WeatherData weatherGetter = new WeatherData();
=======
	private boolean hasZipCode;
	private boolean hasLocationName;
>>>>>>> 10eb60e0d2e6529b4bb80395fdc464df38974913

	public Location(int zip){
		zipCode = zip;
		hasZipCode = true;
		hasLocationName = false;
		//weatherAtLocation = 
	}

	public Location(String place){
		locationName = place;
		hasZipCode = false;
		hasLocationName = true;
	}

<<<<<<< HEAD
	public String getWeather() throws IOException, InterruptedException{
		if(hasZipCode()) {
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
=======
	public Location(String place, int zip){
		locationName = place;
		zipCode = zip;
		hasLocationName = true;
		hasZipCode = true;
>>>>>>> 10eb60e0d2e6529b4bb80395fdc464df38974913
	}

	public String getWeather(){
		if(hasZipCode){
			//return weatherGetter.getWeather();
			return "This is not yet implemented";
		}else if(hasLocationName){
			return "This is not yet implemented";
		}
		return null;
	}
}
