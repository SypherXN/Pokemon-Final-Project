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
	public static String[] pokeNames = {PokemonStorage.getPokemon(0).getBase().getName(), PokemonStorage.getPokemon(1).getBase().getName(), PokemonStorage.getPokemon(2).getBase().getName(), PokemonStorage.getPokemon(3).getBase().getName(), PokemonStorage.getPokemon(4).getBase().getName(), PokemonStorage.getPokemon(5).getBase().getName()};
	public static String[] moveNames = {pokemon.getMove(0).getBase().getName(), pokemon.getMove(1).getBase().getName(), pokemon.getMove(2).getBase().getName(), pokemon.getMove(3).getBase().getName()};
	
	//Overall menu for combat
	public static void combatMenu() {
		
		//Makes the formatiing of the Pokemon Names line up
		for (int i = 0; i < pokeNames.length; i++) {
			
			if (PokemonStorage.getPokemon(i).getBase().getName().length() < 6) {
				
				pokeNames[i] = PokemonStorage.getPokemon(i).getBase().getName() + "\t\t";
				
			} else if (PokemonStorage.getPokemon(i).getBase().getName().length() > 13){
				
				pokeNames[i] = PokemonStorage.getPokemon(i).getBase().getName();
				
			} else {
				
				pokeNames[i] = PokemonStorage.getPokemon(i).getBase().getName() + "\t";
				
			}
			
		}
		
		//Makes the formatiing of the Move Names line up
		for(int i = 0; i < moveNames.length; i++) {
			
			if (pokemon.getMove(i).getBase().getName().length() < 6) {
				
				moveNames[i] = pokemon.getMove(i).getBase().getName() + "\t\t";
				
			} else if (pokemon.getMove(i).getBase().getName().length() > 13){
				
				moveNames[i] = pokemon.getMove(i).getBase().getName();
				
			} else {
				
				moveNames[i] = pokemon.getMove(i).getBase().getName() + "\t";
				
			}
			
		}
		
		//Simply forces the player to choose another Pokemon to send when one has fainted
		if (UI.pokemon.getHP() < 1) { System.out.println(pokemon.getBase().getName() + " has fainted"); pokemonMenu(); return;}
		
		//Prints out the combat menu text
		String combatMenu = "What would you like to do?\n1. Attack\n2. Change Pokemon\n3. Use Item\n4. Run";
		System.out.println(combatMenu);
		int choice = 0;
		
		//Makes sure that the player types in a valid input
		while (choice < 1 || choice > 4) {
			
			try {
				
				choice = input.nextInt();
				
				//Chooses which menu to open
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
		
		//Prints out the attack menu text
		String attackMenu = "Which move would you like to use?"
							+ "\n1. " + moveNames[0] + "\t" + moves[0].getPP() + "/" + moves[0].getBase().getMaxPP()
							+ "\n2. " + moveNames[1] + "\t" + moves[1].getPP() + "/" + moves[1].getBase().getMaxPP()
							+ "\n3. " + moveNames[2] + "\t" + moves[2].getPP() + "/" + moves[2].getBase().getMaxPP()
							+ "\n4. " + moveNames[3] + "\t" + moves[3].getPP() + "/" + moves[3].getBase().getMaxPP()
							+ "\n5. Cancel";
		System.out.println();
		System.out.println(attackMenu);
		int choice = 0;
		
		//Makes sure that the player input is valid
		while (choice < 1 || choice > 5) {
			
			try {
				
				choice = input.nextInt();
				
				//Checks to see if they want to use a move
				if (choice > 0 && choice < moves.length + 1) {
					
					//If there is no more PP
					if (!moves[choice - 1].attemptUseMove()) {
						
						System.out.println("Out of PP");
						attackMenu(moves);
						
					//Otherwise it attacks
					} else {
					
						if (Battle.isFaster()) {
							
							Battle.dealDamage(moves[choice - 1]);
							
							if (Battle.getEnemy().getHP() > 0) {
								
								Battle.enemyDealDamage();
								
							}
							
						}
						
						if (!Battle.isFaster()) {
							
							Battle.enemyDealDamage();
							
							if (UI.pokemon.getHP() > 0) {
								
								Battle.dealDamage(moves[choice - 1]);
								
							}
							
						}
					
					}
					
				}
				
				//If they choose to cancel they return to combat menu
				else if (choice == 5) combatMenu();
				else System.out.println("That is an invalid choice, try again");
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { if (choice < 1 || choice > 5) { input.nextLine(); } else { } }
			
		}
		
	}
	
	//Pokemon menu to choose Pokemon to switch in
	public static void pokemonMenu() {
		
		//Prints out the pokemon menu text
		String pokemonMenu = "Which Pokemon would you like to switch in?"
							+ "\n1. " + pokeNames[0] + "\t" + PokemonStorage.getPokemon(0).getHP() + "/" + PokemonStorage.getPokemon(0).getMaxHP() + "\tLevel: " + PokemonStorage.getPokemon(0).getLevel()
							+ "\n2. " + pokeNames[1] + "\t" + PokemonStorage.getPokemon(1).getHP() + "/" + PokemonStorage.getPokemon(1).getMaxHP() + "\tLevel: " + PokemonStorage.getPokemon(1).getLevel()
							+ "\n3. " + pokeNames[2] + "\t" + PokemonStorage.getPokemon(2).getHP() + "/" + PokemonStorage.getPokemon(2).getMaxHP() + "\tLevel: " + PokemonStorage.getPokemon(2).getLevel()
							+ "\n4. " + pokeNames[3] + "\t" + PokemonStorage.getPokemon(3).getHP() + "/" + PokemonStorage.getPokemon(3).getMaxHP() + "\tLevel: " + PokemonStorage.getPokemon(3).getLevel()
							+ "\n5. " + pokeNames[4] + "\t" + PokemonStorage.getPokemon(4).getHP() + "/" + PokemonStorage.getPokemon(4).getMaxHP() + "\tLevel: " + PokemonStorage.getPokemon(4).getLevel()
							+ "\n6. " + pokeNames[5] + "\t" + PokemonStorage.getPokemon(5).getHP() + "/" + PokemonStorage.getPokemon(5).getMaxHP() + "\tLevel: " + PokemonStorage.getPokemon(5).getLevel()
							+ "\n7. Cancel";
		System.out.println();
		System.out.println(pokemonMenu);
		int choice = 0;
		
		//Checks to see if the user input is valid
		while (choice < 1 || choice > 7) {
			
			try {
				
				choice = input.nextInt();
				
				//Checks to see if the player is attempting to switch in a Pokemon
				if (choice > 0 && choice < 7) {
					
					
					//As long as hp of pokemon is greater than 0 then it can be sent in
					if (PokemonStorage.getPokemon(choice - 1).getHP() > 0) {
						
						pokemon = PokemonStorage.getPokemon(choice - 1);
						System.out.println("You sent out " + pokemon.getBase().getName());
						
					//If Pokemon has fainted then they return back to the pokemon menu
					} else {
						
						System.out.println("This Pokemon is out of HP");
						pokemonMenu();
						
					}
					
				} 
				
				//If user chooses to cancel then they return to the combat menu
				else if (choice == 7) combatMenu();
				else System.out.println("That is an invalid choice, try again");
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { if (choice < 1 || choice > 7) { input.nextLine(); } else { } }
		
		}	
		
	}
	
	//Item menu to choose what item to use
	public static void itemMenu() {
		
		//Prints out the item menu text
		String itemMenu = "Which item would you like to use?"
						+ "\n1. " + bag[0].getName() + "\t" + bag[0].getNumberOwned()
						+ "\n2. " + bag[1].getName() + "\t" + bag[1].getNumberOwned()
						+ "\n3. " + bag[2].getName() + "\t" + bag[2].getNumberOwned()
						+ "\n4. " + bag[3].getName() + "\t" + bag[3].getNumberOwned()
						+ "\n5. Cancel";
		System.out.println();
		System.out.println(itemMenu);
		int choice = 0;
		
		//Checks to see if the player input is valid
		while (choice < 1 || choice > 5) {
			
			try {
				
				choice = input.nextInt();
				
				//Checks to see if the user wants to use an item
				if (choice > 0 && choice < 5) {
					
					//If there are no more of the chosen item then return to item menu
					if (!bag[choice - 1].attemptUseItem()) {
						
						System.out.println("You have no " + bag[choice - 1].getName());
						bag[choice - 1].obtainItem();
						itemMenu();
						
					}
					
					//If there are items then it uses 1 and prints out the text for the pokemon choice menu
					else if (bag[choice - 1].attemptUseItem()) {
						
						bag[choice - 1].obtainItem();
						
						System.out.println("Which Pokemon would you like to heal?"
											+ "\n1. " + pokeNames[0] + "\t" + PokemonStorage.getPokemon(0).getHP() + "/" + PokemonStorage.getPokemon(0).getMaxHP() + "\tLevel: " + PokemonStorage.getPokemon(0).getLevel()
											+ "\n2. " + pokeNames[1] + "\t" + PokemonStorage.getPokemon(1).getHP() + "/" + PokemonStorage.getPokemon(1).getMaxHP() + "\tLevel: " + PokemonStorage.getPokemon(1).getLevel()
											+ "\n3. " + pokeNames[2] + "\t" + PokemonStorage.getPokemon(2).getHP() + "/" + PokemonStorage.getPokemon(2).getMaxHP() + "\tLevel: " + PokemonStorage.getPokemon(2).getLevel()
											+ "\n4. " + pokeNames[3] + "\t" + PokemonStorage.getPokemon(3).getHP() + "/" + PokemonStorage.getPokemon(3).getMaxHP() + "\tLevel: " + PokemonStorage.getPokemon(3).getLevel()
											+ "\n5. " + pokeNames[4] + "\t" + PokemonStorage.getPokemon(4).getHP() + "/" + PokemonStorage.getPokemon(4).getMaxHP() + "\tLevel: " + PokemonStorage.getPokemon(4).getLevel()
											+ "\n6. " + pokeNames[5] + "\t" + PokemonStorage.getPokemon(5).getHP() + "/" + PokemonStorage.getPokemon(5).getMaxHP() + "\tLevel: " + PokemonStorage.getPokemon(5).getLevel()
											+ "\n7. Cancel");
						
						//Checks to see if the input is valid
						try {
							
							int choice2 = 0;
							choice2 = input.nextInt();
							
							//Checks to see that they want to heal a pokemon
							if (choice2 > 0 && choice2 < 7) {
								
								//Checks to see if they have not fainted
								if (PokemonStorage.getPokemon(choice2 - 1).getHP() > 0) {
									
									pokemon.heal(bag[choice - 1].getHeal());
									
								//Checks to see if the Pokemon has fainted already
								} else {
									
									System.out.println("This Pokemon is out of HP");
									bag[choice - 1].obtainItem();
									itemMenu();
									
								}
								
							} 
							
							//If they choose to cancel and returns back to item menu
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
				
				//If user chooses to cancel returns to combat menu
				else if (choice == 5) { combatMenu(); }
				else System.out.println("That is an invalid choice, try again");
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { if (choice < 0 || choice > 5) { input.nextLine(); } else { } }
			
		}
		
	}
	
	//Option to run and leave the battle
	public static void run() {
		
		//Prints out the total score and ends the program
		System.out.println("You have forfeited the battle...");
		System.out.println("You ended with " + Points.getOverallScore() + " points");
		System.exit(0);
		
	}
	
}
