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
	
	public static void pokemonGuess() {
		
		pokemonName = Pokedex.basePokemons[(int)(Math.random() * Pokedex.basePokemons.length - 1) + 1].name;
		tries = pokemonName.length();
		correct = false;
		
		do {
			
			switch(guessLetter(pokemonName)) {
			
			case 0:
				tries--;
				break;
				
			case 1:
				tries--;
				break;
				
			case 2:
				correct = true;
				break;
				
			}
			
		} while (!correct);
		
	}
	
	public static int guessLetter(String pokemon) {
		
		int a = 0;
		
		do {
			
			pokemon += "*";
			a++;
			
		} while (a < pokemonName.length());
		
		for (int i = 0; i < pokemonName.length(); i++) {
			
			for (int x = 0; i < pokemonName.length(); x++) {
				
				System.out.println("Guess a letter in the pokemon's name: ");
				char userInput = input.nextLine().charAt(0);
				
				if (pokemonName.indexOf(userInput) == -1) {
					
					return 0;
					
				} else if (pokemonName.indexOf(userInput) != -1) {
					
					pokemon.replace(pokemon.charAt(x), userInput);
					return 1;
					
				}
				
			}
			
			if(pokemon.equals(pokemonName.substring(0, pokemonName.length()))) {
				
				System.out.println("\nThe pokemon is " + pokemonName + ", which took you " + (pokemon.length() - tries) + " time(s) to guess.");
				return 3;
				
			}
			
		}
		
		return 1;
		
		/*
		 * For-loop that gives certain amount of tries
		 * Ask for input
		 * Do indexOf and if = -1 return 0
		 * Do .equals to check if they are equal and if so return 2
		 * Nested For-loop inside to traverse the word for matching character
		 * Checks different indexes of word to find matching
		 * Changes overall guess string
		 * return 1
		 * 
		 */
	}
}
