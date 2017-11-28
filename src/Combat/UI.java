package Combat;

import java.util.InputMismatchException;
import java.util.Scanner;

import Player.PokemonStorage;
import Player.Story;
import PokemonInfo.Item;
import PokemonInfo.Move;
import PokemonInfo.Pokedex;
import PokemonInfo.Pokemon;

public class UI {
	
	/*
	 * Created by Matthew 11/19/17
	 */
	
	private static Scanner input = new Scanner(System.in);
	private static PokemonStorage storage;
	private static Pokemon pokemon;
	private static Item[] bag = {Pokedex.Potion, Pokedex.SuperPotion, Pokedex.HyperPotion, Pokedex.MaxPotion};
	
	public UI(PokemonStorage storage) {
		
		this.storage = storage;
		this.pokemon = storage.getPokemon(0);
		
	}
	
	public static void combatMenu() {
		
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
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { input.nextLine(); }
			
		}
		
	}
	
	public static void attackMenu(Move[] moves) {
		
		String attackMenu = "Which move would you like to use?\n1. " + moves[0].base.getName() + "\n2. " + moves[1].base.getName() + "\n3. " + moves[2].base.getName() + "\n4. " + moves[3].base.getName() + "\n5. Cancel";
		System.out.println(attackMenu);
		int choice = 0;
		while (choice < 1 || choice > 5) {
			
			try {
				
				choice = input.nextInt() - 1;
				
				if (choice >= 0 && choice < moves.length) {
					
					if (!moves[choice].attemptUseMove()) {
						
						System.out.println("Out of PP");
						attackMenu(moves);
						
					}
					
					System.out.println("PP: " + moves[choice].getPP());
					
				}
				
				else if (choice == 4) combatMenu();
				else System.out.println("That is an invalid choice, try again");
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { input.nextLine(); }
			
		}
		
	}
	
	public static void pokemonMenu() {
		
		String pokemonMenu = "Which Pokemon would you like to switch in?\n1. " + storage.getPokemon(0).base.getName() + "\n2. " + storage.getPokemon(1).base.getName() + "\n3. " + storage.getPokemon(2).base.getName() + "\n4. " + storage.getPokemon(3).base.getName() +
				"\n5. " + storage.getPokemon(4).base.getName() + "\n6. " + storage.getPokemon(5).base.getName() + "\n7. Cancel";
		System.out.println(pokemonMenu);
		int choice = 0;
		while (choice < 1 || choice > 7) {
			
			try {
				
				choice = input.nextInt() - 1;
				
				if (choice >= 0 && choice < 6) {
					
					if (storage.getPokemon(choice).getHP() > 0) {
						
						pokemon = storage.getPokemon(choice);
						System.out.println("You sent out " + pokemon.base.getName());
						
					} else {
						
						System.out.println("This Pokemon is out of HP");
						pokemonMenu();
						
					}
					
				} 
				
				else if (choice == 6) combatMenu();
				else System.out.println("That is an invalid choice, try again");
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { input.nextLine(); }
		
		}	
		
	}
	
	public static void itemMenu() {
		
		String itemMenu = "Which item would you like to use?\n1. " + bag[0].getName() + "\n2. " + bag[1].getName() + "\n3. " + bag[2].getName() + "\n4. " + bag[3].getName() + "\n5. Cancel";
		System.out.println(itemMenu);
		int choice = 0;
		while (choice < 0 || choice > 4) {
			
			try {
				
				choice = input.nextInt() - 1;
				
				if (choice >= 0 && choice < 4) {
					
					if (!bag[choice].attemptUseItem()) System.out.println("You have no " + bag[choice].getName());
					else {
						
						System.out.println("Which Pokemon would you like to heal?");
						System.out.println(storage.getPokemon(0).base.getName() + "\n2. " + storage.getPokemon(1).base.getName() + "\n3. " + storage.getPokemon(2).base.getName() + "\n4. " + storage.getPokemon(3).base.getName() +
											"\n5. " + storage.getPokemon(4).base.getName() + "\n6. " + storage.getPokemon(5).base.getName() + "\n7. Cancel");
						
						
					}
					
				}
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { input.nextLine(); }
			
		}
		
	}
	
	public static void run() {
		
		System.out.println("You have fled the battle");
		
	}
	
	
}
