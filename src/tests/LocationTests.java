package tests;

import code.Location;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocationTests {
		

			
			@Test
			void testHasZipCodeForValidZip() {
				int zipCode = 63105;
				Location supposedToWork = new Location(zipCode);
				assertTrue(supposedToWork.hasZipCode());
			}
			
			@Test
			void testHasZipCodeForInvalidZip() {
				int zipCode = 763;
				Location notSupposedToWork = new Location(zipCode);
				assertTrue(notSupposedToWork.hasZipCode() == false);
			}
			
			@Test
			void testGetZipCodeForValidZip() {
				int zipCode = 63105;
				Location supposedToWork = new Location(zipCode);
				assertTrue(supposedToWork.getZipCode() == zipCode);
			}
			
			@Test
			void testGetZipCodeForInvalidValidZip() {
				int zipCode = 763;
				Location supposedToWork = new Location(zipCode);
				assertTrue(supposedToWork.getZipCode() == -1);
			}
			
			@Test
			void testNamesForLocations() {
				String locationName = "Clayton";
				Location whereMostOfWashUIs = new Location(locationName);
				assertTrue(whereMostOfWashUIs.getName().equals(locationName));
			}

}
