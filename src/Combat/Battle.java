package Combat;

import PokemonInfo.*;

public class Battle {

	/*
	 * Created by William 12/1/17
	 */
	
	private static Pokemon enemy = EnemyStorage.getStorage()[0];
	
	//Accessor methods to get instance variables
	public static Pokemon getEnemy() { return enemy; }
	
	//Randomly picks a move for the opposing Pokemon
	public static Move usedMove() {
		
		int index = (int)(Math.random() * 4);
		return enemy.getMove(index);
		
	}
	
	//Randomly picks the next Pokemon to send out
	public static boolean nextPokemon() {
		
		int index = 0;
		
		if (enemy.getHP() <= 0) {
			
			do {
				
				index = (int)(Math.random() * EnemyStorage.getStorage().length);
				enemy = EnemyStorage.getStorage()[index];
				if (enemy.getHP() > 0) {
					
					return true;
					
				}
				
			} while (enemy.getHP() <= 0);
		
		}
		
		return false;
		
	}
	
	//Opposing Pokemon dealing damage calculations
	public static void enemyDealDamage() {
		
		double modifier = 1;
		
		//50% chancce at a critical strike
		int critical = (int)(Math.random() * 2);
		
		if (critical == 1) {
			
			modifier *= 2;
		
		}
		
		//Placeholder variable to hold the Move chosen
		Move usedMove = usedMove();
		
		//Checks for effectiveness
		if (UI.pokemon.getBase().getFirstType().isEffective(usedMove.getBase().getType())) { modifier *= 2; }
		if (UI.pokemon.getBase().getSecondType().isEffective(usedMove.getBase().getType())) { modifier *= 2; }
		
		//Checks for resistances
		if (UI.pokemon.getBase().getFirstType().isResisted(usedMove.getBase().getType())) { modifier /= 2; }
		if (UI.pokemon.getBase().getSecondType().isResisted(usedMove.getBase().getType())) { modifier /= 2; }
		
		//Checks for nullification
		if (UI.pokemon.getBase().getFirstType().noEffect(usedMove.getBase().getType())) { modifier = 0; }
		if (UI.pokemon.getBase().getSecondType().noEffect(usedMove.getBase().getType())) { modifier = 0; }
			
		//Calculates damage dealt
		double damageDealt = (((((2 * (double)enemy.getLevel()) / 5) + 2) * (double)usedMove.getAttack() * ((double)enemy.getAttack() / (double)UI.pokemon.getDefense()) / 50 ) * (double)modifier);
		
		//Prints out information
		System.out.println("The enemy " + enemy.getBase().getName() + " used " + usedMove.getBase().getName() + " and dealt " + (int)damageDealt + " damage");
		
		//Deals damage to player Pokemon
		UI.pokemon.changeHP(-(int)damageDealt);
		
		//Simply sets any fainted Pokemon HP to zero
		if (UI.pokemon.getHP() < 0) {
			
			UI.pokemon.setHPZero();
			
		}
		
	}
	
	//Player Pokemon dealing damage calculations
	public static void dealDamage(Move usedMove) {
		
		double modifier = 1;
		
		//50% chance at a critical strike
		int critical = (int)(Math.random() * 2);
		
		if (critical == 1) {
			
			modifier *= 2;
			
		}
		
		//Checks for effectiveness
		if (enemy.getBase().getFirstType().isEffective(usedMove.getBase().getType())) { modifier *= 2; }
		if (enemy.getBase().getSecondType().isEffective(usedMove.getBase().getType())) { modifier *= 2; }
		
		//Checks for resistances
		if (enemy.getBase().getFirstType().isResisted(usedMove.getBase().getType())) { modifier /= 2; }
		if (enemy.getBase().getSecondType().isResisted(usedMove.getBase().getType())) { modifier /= 2; }
		
		//Checks for nullification
		if (enemy.getBase().getFirstType().noEffect(usedMove.getBase().getType())) { modifier = 0; }
		if (enemy.getBase().getSecondType().noEffect(usedMove.getBase().getType())) { modifier = 0; }
		
		//Calculates damage dealt
		double damageDealt = (((((2 * (double)UI.pokemon.getLevel()) / 5) + 2) * (double)usedMove.getAttack() * ((double)UI.pokemon.getAttack() / (double)enemy.getDefense()) / 50 ) * (double)modifier);
	
		//Prints out information
		System.out.println("Your " + UI.pokemon.getBase().getName() + " used " + usedMove.getBase().getName() + " and dealt " + (int)damageDealt + " damage");
		
		//Deals damage to the enemy
		enemy.changeHP(-(int)damageDealt);
		
		//Simply sets any fainted Pokemon HP to zero
		if (enemy.getHP() < 0) {
			
			enemy.setHPZero();
			
		}
		
	}
	
	public static boolean isFaster() {
		
		if (enemy.getSpeed() > UI.pokemon.getSpeed()) {
			
			return false;
			
		}
		
		return true;
		
	}

}
