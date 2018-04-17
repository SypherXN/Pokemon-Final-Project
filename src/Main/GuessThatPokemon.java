package Main;
import java.util.Scanner;
import PokemonInfo.Pokedex;

public class GuessThatPokemon {
	
	/*
	 * Created by William 12/6/17
	 */
	
	private static String pokemonName, capName;
	private static Scanner input = new Scanner(System.in);
	private static int tries;
	private static boolean correct;
	
	//Returns an integer based on the state of the game
	public static int pokemonGuess() {
		
		pokemonName = Pokedex.basePokemons[(int)(Math.random() * Pokedex.basePokemons.length - 1) + 1].getName();
		String upperPokemonName = pokemonName.toUpperCase();
		tries = pokemonName.length() * 2;
		int a = 0;
		
		String blank = "";
		
		//Creates a string of asterisk to signify the length
		do {
			
			blank += "*";
			a++;
			
		} while(a < pokemonName.length());
		
		//Tells player how many letters are in the name
		System.out.println("The pokemon you are trying to guess has " + pokemonName.length() + " letters in its name.");
		
		//For-loop keeps track of how many tries the user has left
		for(int i = tries; i > 0; i--) {
			
			System.out.println("Enter a letter to guess: ");
			
			String next = input.nextLine();
			
			while (next.equals("")) {
				
				System.out.println("Enter a letter to guess");
				next = input.nextLine();
				
			}
			
			//Gets the first character of whatever they input
			char charGuess = next.charAt(0);
			
			//Changes it to upper case to keep compare it to the upper case string
			char upperCharGuess = Character.toUpperCase(charGuess);
			
			//Prints to tell user if their input was not in the String
			if(upperPokemonName.indexOf(upperCharGuess) == -1) {
				
				System.out.println("The letter " + charGuess + " is not in the pokemon's name. Please try again.");
			
			} else {
				
				//For-loop traverses the string and looks for matches
				for(int x = 0; x < pokemonName.length(); x++) {
					
					if (upperCharGuess == upperPokemonName.charAt(x)) {
						
						//Checks substrings if x is equal to the length
						if (x == pokemonName.length()) {
							
							blank = blank.substring(0, x) + upperCharGuess;
							
						//Checks substrings when x is not equal to length
						} else {
							
							blank = blank.substring(0, x) + upperCharGuess + blank.substring(x + 1);
							
						}
						
					}
			
				}
				
				//Shows the user the status of their guesses
				System.out.println(blank);
				
				//Will check if they have gotten the question right
				if (blank.equals(upperPokemonName)) { return 1; }
				
			}
			
		}
		
		//Secondary check if they have gotten the question right
		if (blank.equals(upperPokemonName)) { return 1; }
		
		return 0;
	}	
	
	//Runs the pokemonGuess method and determines the state of the game
	public static boolean switchProcessor() {
		
		switch(pokemonGuess()) {
		
		//Returns based on the completion of the game
		case 0:
			System.out.println("You failed and now lose points");
			return false;
		
		case 1:
			System.out.println("You correctly guessed the Pokemon and now gain extra points");
			return true;
			
		}
		
		return false;
		
	}
	
}
