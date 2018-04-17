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
			
			for (int i = 0; i < (int)(Math.random() * 11); i++) {
				
				UI.bag[a].obtainItem();
				
			}
			
		}
		
		//While-loop that continues to run the game while the player has not lost
		while (!PokemonStorage.checkLoss()) {
			
			//Informs the Player of the different states and HP of the Pokemons
			System.out.println("\nEnemy " + Battle.getEnemy().getBase().getName() + " Health: " + Battle.getEnemy().getHP());
			System.out.println("Your " + UI.pokemon.getBase().getName() + " Health: " + UI.pokemon.getHP() + "\n");
			
			//Calls the Combat Menu from UI
			UI.combatMenu();
			
			//Will change out the Enemy Pokemon and will inform the Player of the new Pokemon
			if (!PokemonStorage.checkLoss() && !EnemyStorage.checkLoss() && Battle.nextPokemon()) {
				
				System.out.println();
				System.out.println("The enemy sends out " + Battle.getEnemy().getBase().getName());
				
			}
			
			//Checks if the Enemy has lost the battle
			if (EnemyStorage.checkLoss()) {
				
				System.out.println();
				System.out.println("You won the battle");
				
				//Resets battle for next 
				PokemonStorage.healAll();
				EnemyStorage.changeAll();
				//Gives player points
				Points.pointSwitch();
				System.out.println("You move on to the next battle");
				Battle.nextPokemon();
				System.out.println();
				System.out.println("The enemy sends out " + Battle.getEnemy().getBase().getName());
				
			}
			
			//Checks if the Player has lost the battle
			if (PokemonStorage.checkLoss()) {
				
				System.out.println();
				System.out.println("You lost the battle");
				System.out.println("You ended with " + Points.getOverallScore() + " points");
				System.exit(0);
				
			}
		
		}
		
	}
	
}
