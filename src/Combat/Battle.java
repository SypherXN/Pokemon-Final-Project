package Combat;
import PokemonInfo.*;
public class Battle {

	/*
	 * Created by William 12/1/17
	 */
	
	public static Pokemon enemy;
	
	//Used to set the opposing Pokemon
	public static void setEnemy(Pokemon other) { enemy = other; }
	
	//Randomly picks a move for the opposing Pokemon
	public static Move usedMove() {
		
		int index = (int)Math.random() * 4;
		return enemy.getMove(index);
		
	}
	
	//Opposing Pokemon dealing damage calculations
	public static void enemyDealDamage() {
		
		double modifier = 1;
		
		//50% chancce at a critical strike
		int critical = (int)(Math.random() * 2);
		
		if (critical == 1) {
			
			modifier *= 2;
		
		}
		
		//Checks for effectiveness
		if (UI.pokemon.base.firstType.isEffective(usedMove().base.type)) { modifier *= 2; }
		if (UI.pokemon.base.secondType.isEffective(usedMove().base.type)) { modifier *= 2; }
		
		//Checks for resistances
		if (UI.pokemon.base.firstType.isResisted(usedMove().base.type)) { modifier /= 2; }
		if (UI.pokemon.base.secondType.isResisted(usedMove().base.type)) { modifier /= 2; }
		
		//Checks for nullification
		if (UI.pokemon.base.firstType.noEffect(usedMove().base.type)) { modifier = 0; }
		if (UI.pokemon.base.secondType.noEffect(usedMove().base.type)) { modifier = 0; }
			
		//Calculates damage dealt
		double damageDealt = (((((2 * (double)enemy.level) / 5) + 2) * (double)usedMove().getAttack() * ((double)enemy.attack / (double)UI.pokemon.defense) / 50 ) * (double)modifier);
		
		System.out.println("The enemy " + enemy.base.name + " used " + usedMove().base.name + " and dealt " + (int)damageDealt + " damage");
		
		//Deals damage to player Pokemon
		UI.pokemon.hp -= (int)damageDealt;
		
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
	
		System.out.println("Your " + UI.pokemon.base.name + " used " + usedMove.base.name + " and dealt " + (int)damageDealt + " damage");
		
		//Deals damage to the enemy
		enemy.hp -= (int)damageDealt;
		
	}

}
