package Main;

import Combat.*;
import Player.PokemonStorage;
import PokemonInfo.*;
import java.util.*;

public class MainGame {

	/*
	 * Created by Matthew 11/15/17
	 */
	
	public static void main(String [] args) {
		
		//Initializes the Resistances/Weaknesses/No Effects of the Types
		Pokedex.initResistances();
		Pokedex.initWeaknesses();
		Pokedex.initNoEffect();
		
		//Creates the initial Player Pokemon
		PokemonStorage.changeAll();
		
		//Creates the initial Enemy Pokemon
		EnemyStorage.changeAll();
		
		//Gives Player random number of Items
		for (int a = 0; a < UI.bag.length; a++) {
			
			for (int i = 0; i < (int)(Math.random() * 11); i++)
			
		}
		
		//Prints out the information of Player Pokemon
		System.out.println("---------Pokemon 1---------");
		System.out.println(PokemonStorage.storage[0]);
		System.out.println("---------Pokemon 2---------");
		System.out.println(PokemonStorage.storage[1]);
		System.out.println("---------Pokemon 3---------");
		System.out.println(PokemonStorage.storage[2]);
		System.out.println("---------Pokemon 4---------");
		System.out.println(PokemonStorage.storage[3]);
		System.out.println("---------Pokemon 5---------");
		System.out.println(PokemonStorage.storage[4]);
		System.out.println("---------Pokemon 6---------");
		System.out.println(PokemonStorage.storage[5]);
		
		System.out.println();
		
		//Prints out the information for the Enemy Pokemon
		System.out.println("------Enemy Pokemon 1------");
		System.out.println(EnemyStorage.storage[0]);
		System.out.println("------Enemy Pokemon 2------");
		System.out.println(EnemyStorage.storage[1]);
		System.out.println("------Enemy Pokemon 3------");
		System.out.println(EnemyStorage.storage[2]);
		System.out.println("------Enemy Pokemon 4------");
		System.out.println(EnemyStorage.storage[3]);
		System.out.println("------Enemy Pokemon 5------");
		System.out.println(EnemyStorage.storage[4]);
		System.out.println("------Enemy Pokemon 6------");
		System.out.println(EnemyStorage.storage[5]);
		
		System.out.println();
		
		while (!PokemonStorage.checkLoss() && !EnemyStorage.checkLoss()) {
			
			//Informs the Player of the different states and HP of the Pokemons
			System.out.println("\nEnemy " + Battle.enemy.base.name + " Health: " + Battle.enemy.hp);
			System.out.println("Your " + UI.pokemon.base.name + " Health: " + UI.pokemon.hp + "\n");
			
			//Calls the Combat Menu from UI
			UI.combatMenu();
			
			//Checks if the Enemy has lost the battle
			if (EnemyStorage.checkLoss()) {
				
				System.out.println();
				System.out.println("You won the battle");
				System.exit(0);
				
			}
			
			//Checks if the Player has lost the battle
			if (PokemonStorage.checkLoss()) {
				
				System.out.println();
				System.out.println("You lost the battle");
				System.exit(0);
				
			}
			
			//Will change out the Enemy Pokemon and will inform the Player of the new Pokemon
			if (!PokemonStorage.checkLoss() && !EnemyStorage.checkLoss() && Battle.nextPokemon()) {
				
				System.out.println();
				System.out.println("The enemy sends out " + Battle.enemy.base.name);
				
			}
		
		}
		
	}
	
}
