package Combat;

import PokemonInfo.*;

public class Battle {

	/*
	 * Created by William 12/1/17
	 */
	
	public static Pokemon enemy = EnemyStorage.storage[0];
	
	//Randomly picks a move for the opposing Pokemon
	public static Move usedMove() {
		
		int index = (int)(Math.random() * 4);
		return enemy.getMove(index);
		
	}
	
	//Randomly picks the next Pokemon to send out
	public static boolean nextPokemon() {
		
		int index = 0;
		
		if (enemy.hp <= 0) {
			
			do {
				
				index = (int)(Math.random() * EnemyStorage.storage.length);
				enemy = EnemyStorage.storage[index];
				if (enemy.hp > 0) {
					
					return true;
					
				}
				
			} while (enemy.hp <= 0);
		
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
		if (UI.pokemon.base.firstType.isEffective(usedMove.base.type)) { modifier *= 2; }
		if (UI.pokemon.base.secondType.isEffective(usedMove.base.type)) { modifier *= 2; }
		
		//Checks for resistances
		if (UI.pokemon.base.firstType.isResisted(usedMove.base.type)) { modifier /= 2; }
		if (UI.pokemon.base.secondType.isResisted(usedMove.base.type)) { modifier /= 2; }
		
		//Checks for nullification
		if (UI.pokemon.base.firstType.noEffect(usedMove.base.type)) { modifier = 0; }
		if (UI.pokemon.base.secondType.noEffect(usedMove.base.type)) { modifier = 0; }
			
		//Calculates damage dealt
		double damageDealt = (((((2 * (double)enemy.level) / 5) + 2) * (double)usedMove.getAttack() * ((double)enemy.attack / (double)UI.pokemon.defense) / 50 ) * (double)modifier);
		
		//Prints out information
		System.out.println("The enemy " + enemy.base.name + " used " + usedMove.base.name + " and dealt " + (int)damageDealt + " damage");
		
		//Deals damage to player Pokemon
		UI.pokemon.hp -= (int)damageDealt;
		
		//Simply sets any fainted Pokemon HP to zero
		if (UI.pokemon.hp < 0) {
			
			UI.pokemon.hp = 0;
			
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
		if (enemy.base.firstType.isEffective(usedMove.base.type)) { modifier *= 2; }
		if (enemy.base.secondType.isEffective(usedMove.base.type)) { modifier *= 2; }
		
		//Checks for resistances
		if (enemy.base.firstType.isResisted(usedMove.base.type)) { modifier /= 2; }
		if (enemy.base.secondType.isResisted(usedMove.base.type)) { modifier /= 2; }
		
		//Checks for nullification
		if (enemy.base.firstType.noEffect(usedMove.base.type)) { modifier = 0; }
		if (enemy.base.secondType.noEffect(usedMove.base.type)) { modifier = 0; }
		
		//Calculates damage dealt
		double damageDealt = (((((2 * (double)UI.pokemon.level) / 5) + 2) * (double)usedMove.getAttack() * ((double)UI.pokemon.attack / (double)enemy.defense) / 50 ) * (double)modifier);
	
		//Prints out information
		System.out.println("Your " + UI.pokemon.base.name + " used " + usedMove.base.name + " and dealt " + (int)damageDealt + " damage");
		
		//Deals damage to the enemy
		enemy.hp -= (int)damageDealt;
		
		//Simply sets any fainted Pokemon HP to zero
		if (enemy.hp < 0) {
			
			enemy.hp = 0;
			
		}
		
	}

}
