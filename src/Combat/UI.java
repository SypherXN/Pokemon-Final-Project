package Combat;

import java.util.InputMismatchException;
import java.util.Scanner;
import Player.Story;

public class UI {
	
	private static Scanner input = new Scanner(System.in);
	
	public UI() {
		
	}
	
	public static void combatMenu() {
		
		String combatMenu = "What would you like to do?\n1. Attack\n2. Change Pokemon\n3. Use Item\n4. Run";
		System.out.println(combatMenu);
		int choice = 0;
		while (choice < 1 || choice > 4) {
			
			try {
				
				System.out.println("WHAT");
				
				choice = input.nextInt();
				
				if (choice == 1) attackMenu();
				else if (choice == 2) pokemonMenu();
				
			} catch(InputMismatchException e) { } finally { input.nextLine(); }
			
		}
		
	}
	
	public static int attackMenu() {
		
		String attackMenu = "Which move would you like to use?\n1. " /*+ MOVE 1 GOES HERE */ + "\n2. " /*+ MOVE 2 GOES HERE */ + "\n3. " /*+ MOVE 3 GOES HERE */ + "\n4. " /*+ MOVE 1 GOES HERE */ + "\n5. Cancel";
		System.out.println(attackMenu);
		int choice = 0;
		while (choice < 1 || choice > 5) {
			
			choice = input.nextInt();
			
		}
		
		return choice;
		
	}
	
	public static int pokemonMenu() {
		
		String pokemonMenu = "Which Pokemon would you like to switch in?\n1. " /*+ POKEMON 1 GOES HERE */ + "\n2. " /*+ POKEMON 2 GOES HERE */ + "\n3. " /*+ POKEMON 3 GOES HERE */ + "\n4. " /*+ POKEMON 4 GOES HERE */ +
				"\n5. " /*+ POKEMON 5 GOES HERE */ + "\n6. " /*+ POKEMON 6 GOES HERE */ + "/n7. Cancel";
		System.out.println(pokemonMenu);
		int choice = 0;
		while (choice < 1 || choice > 7) {
			
			choice = input.nextInt();
			
		}
		
		return choice;
		
	}
	
	
}
