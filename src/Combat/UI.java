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
	public static Item[] bag = {Pokedex.Potion, Pokedex.SuperPotion, Pokedex.HyperPotion, Pokedex.MaxPotion};
	
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
		
		String attackMenu = "Which move would you like to use?"
							+ "\n1. " + moves[0].base.getName() + "\t" + moves[0].getPP() + "/" + moves[0].base.getMaxPP()
							+ "\n2. " + moves[1].base.getName() + "\t" + moves[1].getPP() + "/" + moves[1].base.getMaxPP()
							+ "\n3. " + moves[2].base.getName() + "\t" + moves[2].getPP() + "/" + moves[2].base.getMaxPP()
							+ "\n4. " + moves[3].base.getName() + "\t" + moves[3].getPP() + "/" + moves[3].base.getMaxPP()
							+ "\n5. Cancel";
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
						
					} else {
					
						Battle.dealDamage(moves[choice - 1]);
						Battle.enemyDealDamage();
					
					}
					
				}
				
				else if (choice == 5) combatMenu();
				else System.out.println("That is an invalid choice, try again");
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { if (choice < 1 || choice > 5) { input.nextLine(); } else { } }
			
		}
		
	}
	
	//Pokemon menu to choose Pokemon to switch in
	public static void pokemonMenu() {
		
		String pokemonMenu = "Which Pokemon would you like to switch in?"
							+ "\n1. " + PokemonStorage.getPokemon(0).base.name + "\t" + PokemonStorage.getPokemon(0).hp + "/" + PokemonStorage.getPokemon(0).maxHP
							+ "\n2. " + PokemonStorage.getPokemon(1).base.name + "\t" + PokemonStorage.getPokemon(1).hp + "/" + PokemonStorage.getPokemon(1).maxHP
							+ "\n3. " + PokemonStorage.getPokemon(2).base.name + "\t" + PokemonStorage.getPokemon(2).hp + "/" + PokemonStorage.getPokemon(2).maxHP
							+ "\n4. " + PokemonStorage.getPokemon(3).base.name + "\t" + PokemonStorage.getPokemon(3).hp + "/" + PokemonStorage.getPokemon(3).maxHP
							+ "\n5. " + PokemonStorage.getPokemon(4).base.name + "\t" + PokemonStorage.getPokemon(4).hp + "/" + PokemonStorage.getPokemon(4).maxHP
							+ "\n6. " + PokemonStorage.getPokemon(5).base.name + "\t" + PokemonStorage.getPokemon(5).hp + "/" + PokemonStorage.getPokemon(5).maxHP
							+ "\n7. Cancel";
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
		
		String itemMenu = "Which item would you like to use?"
						+ "\n1. " + bag[0].getName() + "\t" + bag[0].getNumberOwned()
						+ "\n2. " + bag[1].getName() + "\t" + bag[1].getNumberOwned()
						+ "\n3. " + bag[2].getName() + "\t" + bag[2].getNumberOwned()
						+ "\n4. " + bag[3].getName() + "\t" + bag[3].getNumberOwned()
						+ "\n5. Cancel";
		System.out.println();
		System.out.println(itemMenu);
		int choice = 0;
		while (choice < 1 || choice > 5) {
			
			try {
				
				choice = input.nextInt();
				
				if (choice > 0 && choice < 5) {
					
					if (!bag[choice - 1].attemptUseItem()) System.out.println("You have no " + bag[choice - 1].getName());
					
					else if (bag[choice - 1].attemptUseItem()) {
						
						System.out.println("Which Pokemon would you like to heal?");
						System.out.println("1. " + PokemonStorage.getPokemon(0).base.name + "\n2. " + PokemonStorage.getPokemon(1).base.name + "\n3. " + PokemonStorage.getPokemon(2).base.name + "\n4. " + PokemonStorage.getPokemon(3).base.name +
											"\n5. " + PokemonStorage.getPokemon(4).base.name + "\n6. " + PokemonStorage.getPokemon(5).base.name + "\n7. Cancel");
						
						try {
							
							 int choice2 = input.nextInt();
							
							if (choice2 > 0 && choice2 < 7) {
								
								if (PokemonStorage.getPokemon(choice2 - 1).getHP() > 0) {
									
									System.out.println("You healed " + pokemon.base.name + " for " + bag[choice - 1].heal);
									pokemon.heal(bag[choice - 1].heal);
									
								} else {
									
									System.out.println("This Pokemon is out of HP");
									itemMenu();
									
								}
								
							} 
							
							else if (choice2 == 7) itemMenu();
							else System.out.println("That is an invalid choice, try again");
							
						} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { if (choice < 1 || choice > 7) { input.nextLine(); } else { } }
						
					}
					
				}
				
				else if (choice == 5) { combatMenu(); }
				else System.out.println("That is an invalid choice, try again");
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { if (choice < 0 || choice > 5) { input.nextLine(); } else { } }
			
		}
		
	}
	
	//Option to run and leave the battle
	public static void run() {
		
		System.out.println("You have forfeited the battle...");
		System.exit(0);
		
	}
	
}
