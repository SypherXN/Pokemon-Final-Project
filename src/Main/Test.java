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
		
		Pokemon Pokemon1 = new Pokemon(Pokedex.basePokemons[(int)(Math.random() * (Pokedex.basePokemons.length - 1) + 1)], (int)(Math.random() * 100 + 1));
		Pokemon Pokemon2 = new Pokemon(Pokedex.basePokemons[(int)(Math.random() * (Pokedex.basePokemons.length - 1) + 1)], (int)(Math.random() * 100 + 1));
		Pokemon Pokemon3 = new Pokemon(Pokedex.basePokemons[(int)(Math.random() * (Pokedex.basePokemons.length - 1) + 1)], (int)(Math.random() * 100 + 1));
		Pokemon EPokemon1 = new Pokemon(Pokedex.basePokemons[(int)(Math.random() * (Pokedex.basePokemons.length - 1) + 1)], (int)(Math.random() * 100 + 1));
		
		System.out.println("---------Pokemon 1---------");
		System.out.println(Pokemon1);
		System.out.println("---------Pokemon 2---------");
		System.out.println(Pokemon2);
		System.out.println("---------Pokemon 3---------");
		System.out.println(Pokemon3);
		System.out.println("------Enemy Pokemon 1------");
		System.out.println(EPokemon1);
		
		
		PokemonStorage.changePokemon(Pokemon1,0);
		PokemonStorage.changePokemon(Pokemon2, 1);
		PokemonStorage.changePokemon(Pokemon3, 2);
		
		Move move1 = new Move(Pokedex.baseMoves[(int)(Math.random() * (Pokedex.baseMoves.length - 1)) + 1]);
		Move move2 = new Move(Pokedex.baseMoves[(int)(Math.random() * (Pokedex.baseMoves.length - 1)) + 1]);
		Move move3 = new Move(Pokedex.baseMoves[(int)(Math.random() * (Pokedex.baseMoves.length - 1)) + 1]);
		Move move4 = new Move(Pokedex.baseMoves[(int)(Math.random() * (Pokedex.baseMoves.length - 1)) + 1]);
		
		Pokemon1.changeMove(move1, 0);
		Pokemon1.changeMove(move2, 1);
		Pokemon1.changeMove(move3, 2);
		Pokemon1.changeMove(move4, 3);
		
		Pokemon2.changeMove(move1, 0);
		Pokemon2.changeMove(move2, 1);
		Pokemon2.changeMove(move3, 2);
		Pokemon2.changeMove(move4, 3);
		
		Pokemon3.changeMove(move1, 0);
		Pokemon3.changeMove(move2, 1);
		Pokemon3.changeMove(move3, 2);
		Pokemon3.changeMove(move4, 3);
		
		EPokemon1.changeMove(move1, 0);
		EPokemon1.changeMove(move2, 1);
		EPokemon1.changeMove(move3, 2);
		EPokemon1.changeMove(move4, 3);
		
		Battle.setEnemy(EPokemon1);
		
		while (Battle.enemy.hp > 0) {
			
			UI.combatMenu();
			
			System.out.println("\nEnemy Health: " + Battle.enemy.hp);
			System.out.println("Your Health: " + UI.pokemon.hp + "\n");
			
			if (PokemonStorage.checkLoss()) {
				
				System.out.println("You lost");
				System.exit(1);
				
			}
		
		}
		
		System.out.println("You Won!!");
	}
	
}
