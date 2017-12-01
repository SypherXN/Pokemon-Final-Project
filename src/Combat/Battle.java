package Combat;
import PokemonInfo.*;
public class Battle {

	/*
	 * Created by William 12/1/17
	 */
	
	private Pokemon enemy;
	
	public Battle(Pokemon enemy) {
		
		this.enemy = enemy;
		
	}
	
	public Move usedMove() {
		
		int index = (int)Math.random()*4;
		return enemy.getMove(index);
		
	}
	
	public void dealDamage() {
		
		int damageDealt;
		
		int modifier = 1;
		
		int critical = (int)(Math.random() * 2);
		
		if(critical == 1) {
			
			modifier *= 2;
		
		}	
			
		damageDealt = (((((2 * enemy.level) / 5) + 2) * usedMove().getAttack() * (enemy.attack / UI.pokemon.defense) / 50 ) * modifier);
		
		
	}

}
