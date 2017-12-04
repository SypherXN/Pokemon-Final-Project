package Combat;
import PokemonInfo.*;
public class Battle {

	/*
	 * Created by William 12/1/17
	 */
	
	public static Pokemon enemy;
	
	public static void setEnemy(Pokemon other) {
		
		enemy = other;
		
	}
	
	public static Move usedMove() {
		
		int index = (int)Math.random()*4;
		return enemy.getMove(index);
		
	}
	
	public static void enemyDealDamage() {
		
		int modifier = 1;
		int critical = (int)(Math.random() * 2);
		
		if (critical == 1) {
			
			modifier *= 2;
		
		}	
			
		int damageDealt = (((((2 * enemy.level) / 5) + 2) * usedMove().getAttack() * (enemy.attack / UI.pokemon.defense) / 50 ) * modifier);
		
		UI.pokemon.hp -= damageDealt;
		
	}
	
	public static void dealDamage(Move usedMove) {
		
		int modifier = 1;
		int critical = (int)(Math.random() * 2);
		
		if (critical == 1) {
			
			modifier *= 2;
			
		}
		
		int damageDealt = (((((2 * UI.pokemon.level) / 5) + 2) * usedMove.getAttack() * (UI.pokemon.attack / enemy.defense) / 50 ) * modifier);
	
		enemy.hp -= damageDealt;
		
	}

}
