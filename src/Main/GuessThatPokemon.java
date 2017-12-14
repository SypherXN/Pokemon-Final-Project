package Main;
import java.util.Scanner;
import PokemonInfo.Pokedex;

public class GuessThatPokemon {
	
	/*
	 * Created by William 12/6/17
	 */
	
	public static String pokemonName, capName;
	public static Scanner input = new Scanner(System.in);
	public static int tries;
	public static boolean correct;
	
	//Returns an integer based on the state of the game
	public static int pokemonGuess() {
		
		pokemonName = Pokedex.basePokemons[(int)(Math.random() * Pokedex.basePokemons.length - 1) + 1].name;
		String upperPokemonName = pokemonName.toUpperCase();
		tries = pokemonName.length() * 2;
		int a = 0;
		
		String blank = "";
		
		do {
			
			blank += "*";
			a++;
			
		} while(a < pokemonName.length());
		
		System.out.println("The pokemon you are trying to guess has " + pokemonName.length() + " letters in its name.");
		
		for(int i = tries; i > 0; i--) {
			
			System.out.println("Enter a letter to guess: ");
			
			char charGuess = input.nextLine().charAt(0);
			
			char upperCharGuess = Character.toUpperCase(charGuess);
			
			if(upperPokemonName.indexOf(upperCharGuess) == -1) {
				
				System.out.println("The letter " + charGuess + " is not in the pokemon's name. Please try again.");
			
			} else {
			
				for(int x = 0; x < pokemonName.length(); x++) {
					
					if (upperCharGuess == upperPokemonName.charAt(x)) {
						
						if (x == pokemonName.length()) {
							
							blank = blank.substring(0, x) + upperCharGuess;
							
						} else {
							
							blank = blank.substring(0, x) + upperCharGuess + blank.substring(x + 1);
							
						}
						
					}
			
				}
				
				System.out.println(blank);
				
				if (blank.equals(upperPokemonName)) { return 1; }
				
			}
			
		}
		
		if (blank.equals(upperPokemonName)) { return 1; }
		
		return 0;
	}	
	
	//Runs the pokemonGuess method and determines the state of the game
	public static boolean switchProcessor() {
		
		switch(pokemonGuess()) {
		
		case 0:
			System.out.println("You failed");
			return false;
		
		case 1:
			System.out.println("Good job");
			return true;
			
		}
		
		return false;
		
	}
	
}
