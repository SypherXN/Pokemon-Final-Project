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
		
		double modifier = 1;
		int critical = (int)(Math.random() * 2);
		
		if (critical == 1) {
			
			modifier *= 2;
		
		}
		
		if (UI.pokemon.base.firstType.isEffective(usedMove().base.type)) { modifier *= 2; }
		if (UI.pokemon.base.secondType.isEffective(usedMove().base.type)) { modifier *= 2; }
		
		if (UI.pokemon.base.firstType.isResisted(usedMove().base.type)) { modifier /= 2; }
		if (UI.pokemon.base.secondType.isResisted(usedMove().base.type)) { modifier /= 2; }
		
		if (UI.pokemon.base.firstType.noEffect(usedMove().base.type)) { modifier = 0; }
		if (UI.pokemon.base.secondType.noEffect(usedMove().base.type)) { modifier = 0; }
			
		double damageDealt = (((((2 * (double)enemy.level) / 5) + 2) * (double)usedMove().getAttack() * ((double)enemy.attack / (double)UI.pokemon.defense) / 50 ) * (double)modifier);
		
		UI.pokemon.hp -= (int)damageDealt;
		
	}
	
	public static void dealDamage(Move usedMove) {
		
		double modifier = 1;
		int critical = (int)(Math.random() * 2);
		
		if (critical == 1) {
			
			modifier *= 2;
			
		}
		
		if (enemy.base.firstType.isEffective(usedMove.base.type)) { modifier *= 2; }
		if (enemy.base.secondType.isEffective(usedMove.base.type)) { modifier *= 2; }
		
		if (enemy.base.firstType.isResisted(usedMove.base.type)) { modifier /= 2; }
		if (enemy.base.secondType.isResisted(usedMove.base.type)) { modifier /= 2; }
		
		if (enemy.base.firstType.noEffect(usedMove.base.type)) { modifier = 0; }
		if (enemy.base.secondType.noEffect(usedMove.base.type)) { modifier = 0; }
		
		double damageDealt = (((((2 * (double)UI.pokemon.level) / 5) + 2) * (double)usedMove.getAttack() * ((double)UI.pokemon.attack / (double)enemy.defense) / 50 ) * (double)modifier);
	
		enemy.hp -= (int)damageDealt;
		
	}

}
