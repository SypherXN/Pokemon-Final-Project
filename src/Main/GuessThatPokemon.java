package Main;
/*
 * Created by William 12/6/17
 */

import PokemonInfo.Pokedex;

public class GuessThatPokemon {
	
	public void guessAndCheck() {
		String guess = Pokedex.basePokemons[(int)(Math.random()*Pokedex.basePokemons.length - 1)].name;
		String pokemon = "";
		int a = (int)Math.random()*guess.length();
		
		pokemon += guess.substring(0, 2);
	}
	
}
