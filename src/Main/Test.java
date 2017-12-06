package Main;

import Combat.*;
import Player.PokemonStorage;
import PokemonInfo.*;

public class Test {

	/*
	 * Created by Matthew 11/15/17
	 */
	
	public static void main(String [] args) {
	
		Pokedex.initResistances();
		Pokedex.initWeaknesses();
		Pokedex.initNoEffect();
		
		Pokemon Bulbasaur = new Pokemon(Pokedex.basePokemons[1], 30);
		Pokemon Ivysaur = new Pokemon(Pokedex.basePokemons[2], 42);
		Pokemon Venasaur = new Pokemon(Pokedex.basePokemons[3], 100);
		Pokemon Venasaur2 = new Pokemon(Pokedex.basePokemons[3], 100);
		
		PokemonStorage.changePokemon(Bulbasaur,0);
		PokemonStorage.changePokemon(Ivysaur, 1);
		PokemonStorage.changePokemon(Venasaur, 2);
		
		Move move1 = new Move(Pokedex.baseMoves[(int)(Math.random() * (Pokedex.baseMoves.length - 1)) + 1]);
		Move move2 = new Move(Pokedex.baseMoves[(int)(Math.random() * (Pokedex.baseMoves.length - 1)) + 1]);
		Move move3 = new Move(Pokedex.baseMoves[(int)(Math.random() * (Pokedex.baseMoves.length - 1)) + 1]);
		Move move4 = new Move(Pokedex.baseMoves[(int)(Math.random() * (Pokedex.baseMoves.length - 1)) + 1]);
		
		Bulbasaur.changeMove(move1, 0);
		Bulbasaur.changeMove(move2, 1);
		Bulbasaur.changeMove(move3, 2);
		Bulbasaur.changeMove(move4, 3);
		
		Ivysaur.changeMove(move1, 0);
		Ivysaur.changeMove(move2, 1);
		Ivysaur.changeMove(move3, 2);
		Ivysaur.changeMove(move4, 3);
		
		Venasaur.changeMove(move1, 0);
		Venasaur.changeMove(move2, 1);
		Venasaur.changeMove(move3, 2);
		Venasaur.changeMove(move4, 3);
		
		Venasaur2.changeMove(move1, 0);
		Venasaur2.changeMove(move2, 1);
		Venasaur2.changeMove(move3, 2);
		Venasaur2.changeMove(move4, 3);
		
		Battle.setEnemy(Venasaur2);
		
		while (Battle.enemy.hp > 0) {
			
			UI.combatMenu();
			
			System.out.println("\nEnemy Health: " + Battle.enemy.hp);
			System.out.println("Your Health: " + UI.pokemon.hp + "\n");
		
		}
	}
	
}
