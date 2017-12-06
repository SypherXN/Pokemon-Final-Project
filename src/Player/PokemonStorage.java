package Player;

import PokemonInfo.Pokedex;
import PokemonInfo.Pokemon;
import Combat.EnemyStorage;

public class PokemonStorage {
	
	/*
	 * Created by William 11/17/17
	 */
	
	public static Pokemon[] storage = {Pokedex.NoPokemon, Pokedex.NoPokemon, Pokedex.NoPokemon, Pokedex.NoPokemon, Pokedex.NoPokemon, Pokedex.NoPokemon};
	
	//Changes the Pokemon in the array at the index and inserts the new Pokemon
	public static void changePokemon(Pokemon pokemon, int index) {
		
		storage[index] = pokemon;
		
	}
	
	//Returns the Pokemon in the array at the index
	public static Pokemon getPokemon(int index) { return storage[index]; }
	
	//Checks if all Pokemon have fainted
	public static boolean checkLoss() {
		
		boolean loss = false;
		
		for (int a = 0; a < storage.length; a++) {
			
			for (int b = 0; b < EnemyStorage.storage.length; b++) {
				
				if (storage[b].hp <= 0) {
					
					loss = true;
					
				} else if (storage[b].hp > 0) {
					
					loss = false;
					
				}
				
			}	
			
		}
		
		return loss;
		
	}	
	
}
