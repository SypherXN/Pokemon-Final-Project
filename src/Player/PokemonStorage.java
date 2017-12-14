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
		
		for (int b = 0; b < EnemyStorage.storage.length; b++) {
			
			if (storage[b].hp <= 0) {
				
				loss = true;
				
			} else if (storage[b].hp > 0) {
				
				return false;
				
			}
			
		}	
		
		return loss;
		
	}	
	
	//Fills the array storage with new random Pokemon
	public static void changeAll() {
		
		for (int i = 0; i < storage.length; i++) {
			
			storage[i] = new Pokemon(Pokedex.basePokemons[(int)(Math.random() * Pokedex.basePokemons.length - 1) + 1], (int)(Math.random() * 100) + 1);
			storage[i].changeAllMoves();
			
		}
		
	}
	
	//Heals all Pokemon to full
	public static void healAll() {
		
		for (int i = 0; i < storage.length; i++) {
			
			storage[i].healFull();
			
		}
		
	}	
	
}
