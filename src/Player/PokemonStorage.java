package Player;

import PokemonInfo.Pokedex;
import PokemonInfo.Pokemon;

public class PokemonStorage {
	
	/*
	 * Created by William 11/17/17
	 */
	
	public static Pokemon[] storage = {Pokedex.NoPokemon, Pokedex.NoPokemon, Pokedex.NoPokemon, Pokedex.NoPokemon, Pokedex.NoPokemon, Pokedex.NoPokemon};
	
	public static void changePokemon(Pokemon pokemon, int index) {
		
		storage[index] = pokemon;
		
	}
	
	public static Pokemon getPokemon(int index) { return storage[index]; }
	
}
