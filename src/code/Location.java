package code;

public class Location {
	private int zipCode;
	private String locationName;
	private boolean hasZipCode;
	private boolean hasLocationName;

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

	public Location(String place, int zip){
		locationName = place;
		zipCode = zip;
		hasLocationName = true;
		hasZipCode = true;
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
