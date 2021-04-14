package code;

import java.util.Scanner;
import java.io.IOException;
import java.lang.InterruptedException;

public class Menu {
	
	private Scanner keyboardIn;
	private User currentUser;
	private boolean shouldExit;
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
		shouldExit = false;
	}

	public static void main(String[] args) throws IOException, InterruptedException{
		
		Menu masterMenu = new Menu();
		while(!masterMenu.shouldExit) {
			masterMenu.runMenu();
		}
		
	}

	private void runMenu() throws IOException, InterruptedException{
		this.displayMenu();
		
		int selectedOption = this.getNumInput();
		
		this.processMainMenu(selectedOption);
	}

	private void processMainMenu(int selectedOption) throws IOException, InterruptedException {
		if(selectedOption == 1) {
			this.askForZipCode();
			
			int opt = this.getNumInput();
			this.processZipCode(opt);
		} else if(selectedOption == 2){
			this.askForCityName();
			clearScanner();
			String opt = this.getStringInput();
			this.processCityName(opt);
		}else if(selectedOption == 3 && !signedIn()) {
			createUser();
		}
	}

	private void createUser() {
		System.out.println("Please enter a username");
		clearScanner();
		String newUserName = getStringInput();
		System.out.println("Please enter your favorite zip code");
		int favZip = getNumInput();
		currentUser = new User(newUserName, favZip);
	}
	
	private void processZipCode(int zip) throws IOException, InterruptedException{
		Location loc = new Location(zip);
		String weather = loc.getWeather();
		System.out.println("Current Weather: " + weather);
		
	}

	private void processCityName(String opt) throws IOException, InterruptedException {
		Location loc = new Location(opt);
		String weather = loc.getWeather();
		System.out.println("Current Weather: " + weather);
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
		if(!signedIn()) {
			System.out.println("3. Create an Account");
		}
	}
	
	private boolean signedIn() {
		return currentUser != null;
	}
	
	private int getNumInput() {
		int input = keyboardIn.nextInt();
		return input;
	}
	private String getStringInput() {
		String input = keyboardIn.nextLine();
		return input;
	}
	
	private void clearScanner() {
		String garbage = keyboardIn.next();
	}
}