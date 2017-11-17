package PokemonInfo;

public class Pokemon {

	/*
	 * Created by Matthew 11/17/17
	 */
	
	public int hp, attack, defense, speed, level, exp;
	public final BasePokemon base;
	
	/* Creates a reference for Pokemon based off the BasePokemon
	 * @param base - basepokemon object
	 * @param level - level of the pokemon object
	 */
	public Pokemon(BasePokemon base, int level) {

		this.base = 	base;
		this.hp = base.getHP();
		this.attack = base.getAttack();
		this.defense = base.getDefense();
		this.speed = base.getSpeed();
		this.level = level;
		
	}
	
	public void increaseHP() {	}
	
	public void increaseAttack() {	}
	
	public void increaseDefense() {	}
	
	public void increaseSpeed() {	}
	
	public void increaseLevel() {	}
	
	public void increaseEXP() {	}
	
	public int getHP() 		{ return hp; }
	
	public int getAttack() 	{ return attack; }
	
	public int getDefense() 	{ return defense; }
	
	public int getSpeed() 	{ return speed; }
	
	public int getLevel() 	{ return level; }
	
	public int getExp() 		{ return exp; }
	
}
