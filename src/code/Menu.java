package code;

import java.util.Hashtable;
import java.util.Scanner;
import java.io.IOException;
import java.lang.InterruptedException;


public class Menu {
	
	private Scanner keyboardIn;
	private User currentUser;
	private boolean shouldExit;
	private boolean firstTime;
	private Hashtable<String, User> users;
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
		shouldExit = false;
		firstTime = true;
		users = new Hashtable<String, User>();
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
		}else if(selectedOption == 4 && !signedIn()) {
			signIn();
		}else if(selectedOption == 3 && signedIn()) {
			processFavorite();
		}else if(selectedOption == 4 && signedIn()) {
			signOut();
		}
	}

	private void createUser() {
		System.out.println("Please enter a username");
		clearScanner();
		String newUserName = keyboardIn.nextLine();
		boolean useName = determineZipOrName();
		if(useName) {
			System.out.println("Please enter the name of your favorite city");
			String favCity = getStringInput();
			currentUser = new User(newUserName, favCity);
		}else {
			System.out.println("Please enter your favorite zip code");
			int favZip = getNumInput();
			currentUser = new User(newUserName, favZip);
		}
		users.put(newUserName, currentUser);
	}
	
	private void signIn(){
		System.out.println("Please enter your username");
		String userNameQuery = getStringInput();
		User currUser = users.get(userNameQuery);
		if(currUser == null) {
			System.out.println("That user was not found. Try again");
			signIn();
		}else {
			currentUser = currUser;
			System.out.println("Welcome " + currUser.getName() + "! You are all signed in");
		}
	}
	
	private void signOut() {
		currentUser = null;
		System.out.println("You have been signed out");
	}
	
	private boolean determineZipOrName() {
		System.out.println("Please select an option: ");
		System.out.println("1. Enter your favorite zip code");
		System.out.println("2. Enter your favorite city");
		int input = getNumInput();
		if(input == 1) {
			return false;
		}
		return true;
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
	
	private void processFavorite() throws IOException, InterruptedException {
		if(currentUser.favoriteIsZipCode()) {
			processCityName(currentUser.getFavoriteCity());
		}else {
			processZipCode(currentUser.getFavoriteZip());
		}
	}

	private void askForZipCode() {
		System.out.println("Please Enter a 6 digit zip code.");
	}

	private void askForCityName() {
		System.out.println("Please Enter a city name");
	}

	private void displayMenu() {
		if(firstTime) {
			System.out.println("Welcome to WonderfulWeatherApp!");
			firstTime = false;
		}
		System.out.println("Please select an option: ");
		
		System.out.println("1. Enter a zip code");
		System.out.println("2. Enter a City Name");
		if(!signedIn()) {
			System.out.println("3. Create an Account");
			System.out.println("4. Sign In");
		}else {
			System.out.println("3. Get the weather at your favorite place");
			System.out.println("4. Sign out");
		}
	}
	
	private boolean signedIn() {
		return currentUser != null;
	}
	
	private int getNumInput() {
		clearScanner();
		int input = keyboardIn.nextInt();
		return input;
	}
	private String getStringInput() {
		clearScanner();
		String input = keyboardIn.nextLine();
		return input;
	}
	
	private void clearScanner() {
		keyboardIn = new Scanner(System.in);
	}
}