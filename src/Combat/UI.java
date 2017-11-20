package Combat;

import java.util.InputMismatchException;
import java.util.Scanner;
import Player.Story;
import PokemonInfo.Move;
import PokemonInfo.Pokemon;

public class UI {
	
	/*
	 * Created by Matthew 11/19/17
	 */
	
	private static Scanner input = new Scanner(System.in);
	private static Pokemon pokemon;
	
	public UI(Pokemon pokemon) {
		
		this.pokemon = pokemon;
		
	}
	
	public static void combatMenu() {
		
		String combatMenu = "What would you like to do?\n1. Attack\n2. Change Pokemon\n3. Use Item\n4. Run";
		System.out.println(combatMenu);
		int choice = 0;
		while (choice < 1 || choice > 4) {
			
			try {
				
				choice = input.nextInt();
				
				if (choice == 1) attackMenu(pokemon.getMove(0), pokemon.getMove(1), pokemon.getMove(2), pokemon.getMove(3));
				else if (choice == 2) pokemonMenu();
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { input.nextLine(); }
			
		}
		
	}
	
	public static void attackMenu(Move move1, Move move2, Move move3, Move move4) {
		
		String attackMenu = "Which move would you like to use?\n1. " + move1.base.getName() + "\n2. " + move2.base.getName() + "\n3. " + move3.base.getName() + "\n4. " + move4.base.getName() + "\n5. Cancel";
		System.out.println(attackMenu);
		int choice = 0;
		while (choice < 1 || choice > 5) {
			
			try {
				
				choice = input.nextInt();
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { input.nextLine(); }
			
		}
		
		if (choice == 5) {
			
			combatMenu();
			
		}
		
	}
	
	public static void pokemonMenu() {
		
		String pokemonMenu = "Which Pokemon would you like to switch in?\n1. " /*+ POKEMON 1 GOES HERE */ + "\n2. " /*+ POKEMON 2 GOES HERE */ + "\n3. " /*+ POKEMON 3 GOES HERE */ + "\n4. " /*+ POKEMON 4 GOES HERE */ +
				"\n5. " /*+ POKEMON 5 GOES HERE */ + "\n6. " /*+ POKEMON 6 GOES HERE */ + "\n7. Cancel";
		System.out.println(pokemonMenu);
		int choice = 0;
		while (choice < 1 || choice > 7) {
			
			try {
				
				choice = input.nextInt();
				
			} catch(InputMismatchException e) { System.out.println("That is an invalid choice, try again"); } finally { input.nextLine(); }
			
		}
		
		if (choice == 7) {
			
			combatMenu();
			
		}
		
	}
	
	public static void itemMenu() {
		
		String itemMenu = "Which item would you like to use?\n1. " /*+POTION NAME*/ + "\n2. " /*+SUPER POTION*/ + "\n3. " /*+HYPER POTION*/ + "\n4. " /*+MAX POTION*/ + "\n5. Cancel";
		
	}
	
	
}
