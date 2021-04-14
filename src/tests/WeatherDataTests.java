package tests;

import code.WeatherData;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class WeatherDataTests {

	@Test
	void makeRequestTest() throws IOException, InterruptedException {
		WeatherData weatherGetter = new WeatherData();
		String ret = weatherGetter.makeRequest("63105", true);
		assertTrue(ret != "no response");
	}

}
