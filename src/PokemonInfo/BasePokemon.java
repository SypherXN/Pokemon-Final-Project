package PokemonInfo;

import java.util.*;

/*
 * Created by Matthew 11/15/17
 */

public abstract class BasePokemon {

	private final int level, exp;
	private final int hp, attack, defense, speed;
	private final String name, type;
	
	/* Creates a reference to Pokemon that contains their stats and info
	 * @param name - name of the Pokemon
	 * @param type - type of the Pokemon
	 * @param hp - hp of the Pokemon when caught
	 * @param attack - attack of the Pokemon when caught
	 * @param defense - defense of the Pokemon when caught
	 * @param speed - speed of the Pokemon when caught
	 * @param level - level of the Pokemon when caught
	 * @param exp - exp of the Pokemon when caught
	 */
	public BasePokemon(String name, String type, int hp, int attack, int defense, int speed, int level, int exp) {
		
		//Pokemon Info
		this.name = name;
		this.type = type;
		
		//Pokemon Stats
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		
		//Pokemon Progression
		this.level = level;
		this.exp = exp;
		
	}
	
	public String getMoves() {
		
		String output = new String();
		
		output += "hi";
		
		return output;
		
	}
	
	public void changeMoves() {
		
	
		
	}
	
	public abstract void increaseHP(int hpIncrease);
	
	public abstract void increaseAttack(int attackIncrease);
	
	public abstract void increaseDefense(int defenseIncrease);
	
	public abstract void increaseSpeed(int speedIncrease);
	
	public abstract void increaseLevel(int levelIncrease);
	
	public abstract void increaseEXP(int expIncrease);
	
	
}
