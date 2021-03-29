package tests;

import code.Location;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocationTests {
		

			@Test
			void testZipCodesForLocations() {
				int goodZipCodeToTest = 63105;
				Location supposedToWork = new Location(goodZipCodeToTest);
				assertTrue(supposedToWork.hasZipCode()); //check for correctness
				assertTrue(supposedToWork.getZipCode() == goodZipCodeToTest);
				int badZipCodeToTest = 763;
				Location notSupposedToWork = new Location(badZipCodeToTest);
				assertTrue(notSupposedToWork.hasZipCode() == false);
				assertTrue(notSupposedToWork.getZipCode() == -1);
			}
			
			@Test
			void testNamesForLocations() {
				String locationName = "Clayton, MO";
				Location whereMostOfWashUIs = new Location(locationName);
				assertTrue(whereMostOfWashUIs.getName().equals(locationName));
			}

}
