package tests;

import code.User;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTests {
	
	@Test
	void testValidFavoriteZipCode() {
		User person = new User("Sarah", 06820.0);
		assertTrue(person.getFavoriteZip() == 06820.0);
	}

	@Test
	void testFalseFavoriteZipCode() {
		User person = new User("Sarah", 06820.0);
		assertTrue(person.getFavoriteZip() != 06820.0);
	}
	@Test
	void testValidFavoriteCity() {
		User person = new User("Sarah", "Seattle");
		assertTrue(person.getFavoriteCity() == "Seattle");
	}
	void testFavoriteCityZipCode() {
		User person = new User("Sarah", "Seattle");
		assertTrue(person.getFavoriteZip() == -1);
	}

	@Test
	void testFalseFavoriteCity() {
		User person = new User("Sarah", "Seattle");
		assertTrue(person.getFavoriteCity() != "Sailboatharbour");
	}
	
	@Test
	void testTrueName() {
		User person = new User("Sarah", 06820.0);
		assertTrue(person.getName() == "Sarah");
	}
	
	@Test
	void testFalseName() {
		User person = new User("Sarah", 06820.0);
		assertTrue(person.getName() == "Sam");
	}
	
	
	
	
}