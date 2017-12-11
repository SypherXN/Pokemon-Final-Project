package Combat;

import java.util.InputMismatchException;
import java.util.Scanner;

import Player.PokemonStorage;
import PokemonInfo.*;

public class UI {
	
	/*
	 * Created by Matthew 11/19/17
	 */
	
	private static Scanner input = new Scanner(System.in);
	public static Pokemon pokemon = PokemonStorage.getPokemon(0);
	private static Item[] bag = {Pokedex.Potion, Pokedex.SuperPotion, Pokedex.HyperPotion, Pokedex.MaxPotion};
	
	//Overall menu for combat
	public static void combatMenu() {
		
		if (UI.pokemon.hp < 1) { System.out.println(pokemon.base.name + " has fainted"); pokemonMenu(); return;}
		
		String combatMenu = "What would you like to do?\n1. Attack\n2. Change Pokemon\n3. Use Item\n4. Run";
		System.out.println(combatMenu);
		int choice = 0;
		while (choice < 1 || choice > 4) {
			
			try {
				
				choice = input.nextInt();
				
				if (choice == 1) attackMenu(pokemon.getMoves());
				else if (choice == 2) pokemonMenu();
				else if (choice == 3) itemMenu();
				else if (choice == 4) run();
				else System.out.println("That is an invalid choice, try again");
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { if (choice < 1 || choice > 4) { input.nextLine(); } else { } }
			
		}
		
	}
	
	//Attack menu to choose attacks
	public static void attackMenu(Move[] moves) {
		
		String attackMenu = "Which move would you like to use?\n1. " + moves[0].base.getName() + "\n2. " + moves[1].base.getName() + "\n3. " + moves[2].base.getName() + "\n4. " + moves[3].base.getName() + "\n5. Cancel";
		System.out.println();
		System.out.println(attackMenu);
		int choice = 0;
		while (choice < 1 || choice > 5) {
			
			try {
				
				choice = input.nextInt();
				
				if (choice > 0 && choice < moves.length + 1) {
					
					if (!moves[choice - 1].attemptUseMove()) {
						
						System.out.println("Out of PP");
						attackMenu(moves);
						
					}
					
					Battle.dealDamage(moves[choice - 1]);
					Battle.enemyDealDamage();
					System.out.println("PP: " + moves[choice - 1].getPP());
					
				}
				
				else if (choice == 5) combatMenu();
				else System.out.println("That is an invalid choice, try again");
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { if (choice < 1 || choice > 5) { input.nextLine(); } else { } }
			
		}
		
	}
	
	//Pokemon menu to choose Pokemon to switch in
	public static void pokemonMenu() {
		
		String pokemonMenu = "Which Pokemon would you like to switch in?\n1. " + PokemonStorage.getPokemon(0).base.name + "\n2. " + PokemonStorage.getPokemon(1).base.name + "\n3. " + PokemonStorage.getPokemon(2).base.name + "\n4. " + PokemonStorage.getPokemon(3).base.name +
				"\n5. " + PokemonStorage.getPokemon(4).base.name + "\n6. " + PokemonStorage.getPokemon(5).base.name + "\n7. Cancel";
		System.out.println();
		System.out.println(pokemonMenu);
		int choice = 0;
		while (choice < 1 || choice > 7) {
			
			try {
				
				choice = input.nextInt();
				
				if (choice > 0 && choice < 7) {
					
					if (PokemonStorage.getPokemon(choice - 1).getHP() > 0) {
						
						pokemon = PokemonStorage.getPokemon(choice - 1);
						System.out.println("You sent out " + pokemon.base.name);
						
					} else {
						
						System.out.println("This Pokemon is out of HP");
						pokemonMenu();
						
					}
					
				} 
				
				else if (choice == 7) combatMenu();
				else System.out.println("That is an invalid choice, try again");
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { if (choice < 1 || choice > 7) { input.nextLine(); } else { } }
		
		}	
		
	}
	
	//Item menu to choose what item to use
	public static void itemMenu() {
		
		String itemMenu = "Which item would you like to use?\n1. " + bag[0].getName() + "\n2. " + bag[1].getName() + "\n3. " + bag[2].getName() + "\n4. " + bag[3].getName() + "\n5. Cancel";
		System.out.println();
		System.out.println(itemMenu);
		int choice = 0;
		while (choice < 0 || choice > 5) {
			
			try {
				
				choice = input.nextInt();
				
				if (choice > 0 && choice < 5) {
					
					if (!bag[choice].attemptUseItem()) System.out.println("You have no " + bag[choice].getName());
					else {
						
						System.out.println("Which Pokemon would you like to heal?");
						System.out.println(PokemonStorage.getPokemon(0).base.name + "\n2. " + PokemonStorage.getPokemon(1).base.name + "\n3. " + PokemonStorage.getPokemon(2).base.name + "\n4. " + PokemonStorage.getPokemon(3).base.name +
											"\n5. " + PokemonStorage.getPokemon(4).base.name + "\n6. " + PokemonStorage.getPokemon(5).base.name + "\n7. Cancel");
						
						
					}
					
				}
				
				else if (choice == 5) { combatMenu(); }
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { if (choice < 0 || choice > 5) { input.nextLine(); } else { } }
			
		}
		
	}
	
	//Option to run and leave the battle
	public static void run() {
		
		System.out.println("You have forfeited the battle...");
		
	}
	
	
}
