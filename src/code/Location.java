package code;

public class Location {
	private int zipCode;
	private String locationName;
	//private WeatherData weatherGetter = new WeatherData();

	public Location(int zip){
		if(zip / 10000 != 0){
			zipCode = zip;
		}else {
			zipCode = -1;
		}
		locationName = null;
	}

	public Location(String place){
		locationName = place;
		zipCode = -1;
	}

//	public String getWeather(){
//		if(hasZipCode()) {
//			weatherGetter.
//		}
//	}
	
	public boolean hasZipCode() {
		if(zipCode == -1) {
			return false;
		}
		return true;
	}
	
	public boolean hasName() {
		if(locationName != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return the zipCode or -1 if there is not a valid zip code
	 */
	public int getZipCode() {
		return zipCode;
	}
	
	/**
	 * @return the name of the location or null if there is not a valid name.
	 */
	public String getName() {
		return locationName;
	}
}
