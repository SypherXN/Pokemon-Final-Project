package Combat;

import java.util.InputMismatchException;
import java.util.Scanner;

import Main.Points;
import Player.PokemonStorage;
import PokemonInfo.*;

public class UI {
	
	/*
	 * Created by Matthew 11/19/17
	 */
	
	private static Scanner input = new Scanner(System.in);
	public static Pokemon pokemon = PokemonStorage.getPokemon(0);
	public static Item[] bag = {Pokedex.Potion, Pokedex.SuperPotion, Pokedex.HyperPotion, Pokedex.MaxPotion};
	public static String[] pokeNames = {PokemonStorage.getPokemon(0).base.name, PokemonStorage.getPokemon(1).base.name, PokemonStorage.getPokemon(2).base.name, PokemonStorage.getPokemon(3).base.name, PokemonStorage.getPokemon(4).base.name, PokemonStorage.getPokemon(5).base.name};
	public static String[] moveNames = {pokemon.getMove(0).base.name, pokemon.getMove(1).base.name, pokemon.getMove(2).base.name, pokemon.getMove(3).base.name};
	
	//Overall menu for combat
	public static void combatMenu() {
		
		for (int i = 0; i < pokeNames.length; i++) {
			
			if (pokeNames[i].length() < 4) {
				
				pokeNames[i] = PokemonStorage.getPokemon(i).base.name + "\t\t";
				
			} else if (pokeNames[i].length() < 8) {
				
				pokeNames[i] = PokemonStorage.getPokemon(i).base.name + "\t";
				
			} else if (pokeNames[i].length() > 12){
				
				pokeNames[i] = PokemonStorage.getPokemon(i).base.name;
				
			} else {
				
				pokeNames[i] = PokemonStorage.getPokemon(i).base.name + "\t";
				
			}
			
		}
		
		for(int i = 0; i < moveNames.length; i++) {
			
			if (moveNames[i].length() < 4) {
				
				moveNames[i] = pokemon.getMove(i).base.name + "\t\t";
				
			} else if (moveNames[i].length() < 8) {
				
				moveNames[i] = pokemon.getMove(i).base.name + "\t";
				
			} else if (moveNames[i].length() > 12){
				
				moveNames[i] = pokemon.getMove(i).base.name;
				
			} else {
				
				moveNames[i] = pokemon.getMove(i).base.name + "\t";
				
			}
			
		}
		
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
							+ "\n1. " + moveNames[0] + "\t" + moves[0].getPP() + "/" + moves[0].base.getMaxPP()
							+ "\n2. " + moveNames[1] + "\t" + moves[1].getPP() + "/" + moves[1].base.getMaxPP()
							+ "\n3. " + moveNames[2] + "\t" + moves[2].getPP() + "/" + moves[2].base.getMaxPP()
							+ "\n4. " + moveNames[3] + "\t" + moves[3].getPP() + "/" + moves[3].base.getMaxPP()
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
							+ "\n1. " + pokeNames[0] + "\t" + PokemonStorage.getPokemon(0).hp + "/" + PokemonStorage.getPokemon(0).maxHP + "\tLevel: " + PokemonStorage.getPokemon(0).level
							+ "\n2. " + pokeNames[1] + "\t" + PokemonStorage.getPokemon(1).hp + "/" + PokemonStorage.getPokemon(1).maxHP + "\tLevel: " + PokemonStorage.getPokemon(1).level
							+ "\n3. " + pokeNames[2] + "\t" + PokemonStorage.getPokemon(2).hp + "/" + PokemonStorage.getPokemon(2).maxHP + "\tLevel: " + PokemonStorage.getPokemon(2).level
							+ "\n4. " + pokeNames[3] + "\t" + PokemonStorage.getPokemon(3).hp + "/" + PokemonStorage.getPokemon(3).maxHP + "\tLevel: " + PokemonStorage.getPokemon(3).level
							+ "\n5. " + pokeNames[4] + "\t" + PokemonStorage.getPokemon(4).hp + "/" + PokemonStorage.getPokemon(4).maxHP + "\tLevel: " + PokemonStorage.getPokemon(4).level
							+ "\n6. " + pokeNames[5] + "\t" + PokemonStorage.getPokemon(5).hp + "/" + PokemonStorage.getPokemon(5).maxHP + "\tLevel: " + PokemonStorage.getPokemon(5).level
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
					
					if (!bag[choice - 1].attemptUseItem()) {
						
						System.out.println("You have no " + bag[choice - 1].getName());
						bag[choice - 1].obtainItem();
						
					}
					
					else if (bag[choice - 1].attemptUseItem()) {
						
						bag[choice - 1].obtainItem();
						
						System.out.println("Which Pokemon would you like to heal?"
											+ "\n1. " + pokeNames[0] + "\t" + PokemonStorage.getPokemon(0).hp + "/" + PokemonStorage.getPokemon(0).maxHP + "\tLevel: " + PokemonStorage.getPokemon(0).level
											+ "\n2. " + pokeNames[1] + "\t" + PokemonStorage.getPokemon(1).hp + "/" + PokemonStorage.getPokemon(1).maxHP + "\tLevel: " + PokemonStorage.getPokemon(1).level
											+ "\n3. " + pokeNames[2] + "\t" + PokemonStorage.getPokemon(2).hp + "/" + PokemonStorage.getPokemon(2).maxHP + "\tLevel: " + PokemonStorage.getPokemon(2).level
											+ "\n4. " + pokeNames[3] + "\t" + PokemonStorage.getPokemon(3).hp + "/" + PokemonStorage.getPokemon(3).maxHP + "\tLevel: " + PokemonStorage.getPokemon(3).level
											+ "\n5. " + pokeNames[4] + "\t" + PokemonStorage.getPokemon(4).hp + "/" + PokemonStorage.getPokemon(4).maxHP + "\tLevel: " + PokemonStorage.getPokemon(4).level
											+ "\n6. " + pokeNames[5] + "\t" + PokemonStorage.getPokemon(5).hp + "/" + PokemonStorage.getPokemon(5).maxHP + "\tLevel: " + PokemonStorage.getPokemon(5).level
											+ "\n7. Cancel");
						
						try {
							
							int choice2 = 0;
							choice2 = input.nextInt();
							
							if (choice2 > 0 && choice2 < 7) {
								
								if (PokemonStorage.getPokemon(choice2 - 1).getHP() > 0) {
									
									pokemon.heal(bag[choice - 1].heal);
									
								} else {
									
									System.out.println("This Pokemon is out of HP");
									bag[choice - 1].obtainItem();
									itemMenu();
									
								}
								
							} 
							
							else if (choice2 == 7) { 
								
								bag[choice - 1].obtainItem();
								itemMenu();
								
							} else { 
								
								System.out.println("That is an invalid choice, try again");
								bag[choice - 1].obtainItem();
								
							}
							
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
		System.out.println("You ended with " + Points.overallScore + " points");
		System.exit(0);
		
	}
	
}
