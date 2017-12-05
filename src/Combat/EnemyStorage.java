package Combat;

import PokemonInfo.Pokedex;
import PokemonInfo.Pokemon;

public class EnemyStorage {

	/*
	 * Created by William 12/5/17
	 */
	
	public static Pokemon[] storage = {Pokedex.NoPokemon, Pokedex.NoPokemon, Pokedex.NoPokemon, Pokedex.NoPokemon, Pokedex.NoPokemon, Pokedex.NoPokemon};
	
	//Changes the Pokemon in the array at the index and inserts the new Pokemon
	public static void changePokemon(Pokemon pokemon, int index) {
		
		storage[index] = pokemon;
		
	}
	
	//Returns the Pokemon in the array at the index
	public static Pokemon getPokemon(int index) { return storage[index]; }
	
}
