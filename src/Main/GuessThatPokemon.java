package Main;
import java.util.Scanner;
/*
 * Created by William 12/6/17
 */

import PokemonInfo.Pokedex;

public class GuessThatPokemon {
	
	public void pokemonGuess() {
		String pokemon = Pokedex.basePokemons[(int)(Math.random()*Pokedex.basePokemons.length - 1)].name;
		int guess = pokemon.length();
		char[] userGuess = new char[guess];
		int tries = 0;
		boolean correct = false;
		
		do {
			
			switch(guessLetter(pokemon, userGuess)) {
			case 0:
				tries++;
				break;
			case 1:
				break;
			case 2:
				correct = true;
				break;
			}
			
		}while(!correct);
		System.out.println("\nThe pokemon is " + pokemon + ", which took you " + tries + " time(s) to guess.");
		}
	
	public int guessLetter(String pokemon, char[] userGuess) {
		
		for(int i = 0; i < pokemon.length(); i++) {
			System.out.println("Guess a letter in the pokemon's name: ");
			Scanner input = new Scanner (System.in);
			char userInput = input.nextLine().charAt(0);
			if(userInput == pokemon.charAt(i)) {
				return 1;
				userGuess[i] = userInput;
			}
			else if(userInput != pokemon.charAt(i)) {
				return 0;
			}
		}
		return 1;
	}
}
