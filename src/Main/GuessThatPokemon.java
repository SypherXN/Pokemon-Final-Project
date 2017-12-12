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
	
	public static int pokemonGuess() {
		
		pokemonName = Pokedex.basePokemons[(int)(Math.random() * Pokedex.basePokemons.length - 1) + 1].name;
		String upperPokemonName = pokemonName.toUpperCase();
		tries = pokemonName.length();
		int a = 0;
		
		System.out.println(pokemonName);
		
		String blank = "";
		
		do {
			
			blank += "*";
			a++;
			
		} while(a < tries);
		
		
		for(int i = tries; i > 0; i--) {
			
			System.out.println("The pokemon you are trying to guess has " + tries + " letters in its name.");
			System.out.println("Enter a letter to guess: ");
			
			char charGuess = input.nextLine().charAt(0);
			
			char upperCharGuess = Character.toUpperCase(charGuess);
			
			if (blank.equals(upperPokemonName)) { return 1; }
			
			if(upperPokemonName.indexOf(upperCharGuess) == -1) {
				
				System.out.println("The letter " + charGuess + " is not in the pokemon's name. Please try again.");
			
			} else {
			
				for(int x = 0; x < pokemonName.length(); x++) {
					
					if (upperCharGuess == upperPokemonName.charAt(x)) {
						
						blank = blank.substring(0, i) + upperCharGuess + blank.substring(i);
						System.out.println(blank);
						
					}
			
				}
				
			}
			
		}
		
		if (blank.equals(upperPokemonName)) { return 1; }
		
		return 0;
	}	
	
	public static void switchProcessor() {
		
		switch(pokemonGuess()) {
		
		case 0:
			System.out.println("You failed");
			break;
		
		case 1:
			System.out.println("Good job");
			break;
			
		default:
			break;
		}
		
	}
	
	
		/*
		 * For-loop that gives certain amount of tries
		 * Ask for input
		 * Do indexOf and if = -1 return 0
		 * Do .equals to check if they are equal 
		 * Nested For-loop inside to traverse the word for matching character
		 * Checks different indexes of word to find matching
		 * Changes overall guess string
		 * 
		 */
	
}
