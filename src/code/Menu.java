package code;

import java.util.Scanner;
import java.io.IOException;
import java.lang.InterruptedException;

public class Menu {
	
	private Scanner keyboardIn;
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
	}

	public static void main(String[] args) throws IOException, InterruptedException{
		
		Menu masterMenu = new Menu();
		masterMenu.runMenu();
		
	}

	private void runMenu() throws IOException, InterruptedException{
		this.displayMenu();
		
		int selectedOption = this.getNumInput();
		
		this.processMainMenu(selectedOption);
		this.keyboardIn.close();
	}

	private void processMainMenu(int selectedOption) throws IOException, InterruptedException {
		if(selectedOption == 1) {
			this.askForZipCode();
			
			int opt = this.getNumInput();
			this.processZipCode(opt);
		} else {
			this.askForCityName();
			
			String opt = this.getStringInput();
			this.processCityName(opt);
		}
	}

	private void processZipCode(int zip) throws IOException, InterruptedException{
		Location loc = new Location(zip);
		String weather = loc.getWeather();
		System.out.println("Current Weather: " + weather);
		
	}

	private void processCityName(String opt) {
		System.out.println("Not yet implemented");
		
	}

	private void askForZipCode() {
		System.out.println("Please Enter a 6 digit zip code.");
	}

	private void askForCityName() {
		System.out.println("Please Enter a city name");
	}

	private void displayMenu() {
		System.out.println("Welcome to WonderfulWeatherApp!");
		System.out.println("Please select an option: ");
		
		System.out.println("1. Enter a zip code");
		System.out.println("2. Enter a City Name");
	}
	
	private int getNumInput() {
		return keyboardIn.nextInt();
	}
	private String getStringInput() {
		return keyboardIn.nextLine();
	}
}