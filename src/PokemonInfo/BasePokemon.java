package PokemonInfo;

import java.util.*;

/*
 * Created by Matthew 11/15/17
 */

public abstract class BasePokemon {

	private final int level, exp;
	private final int hp, attack, defense, spAttack, spDefense, speed;
	private final String name, type;
	
	/* Creates a reference to Pokemon that contains their stats and info
	 * @param name - name of the Pokemon
	 * @param type - type of the Pokemon
	 * @param hp - hp of the Pokemon when caught
	 * @param attack - attack of the Pokemon when caught
	 * @param defense - defense of the Pokemon when caught
	 * @param spAttack - special attack of the Pokemon when caught
	 * @param spDefense - special defense of the Pokemon when caught
	 * @param speed - speed of the Pokemon when caught
	 * @param level - level of the Pokemon when caught
	 * @param exp - exp of the Pokemon when caught
	 */
	public BasePokemon(String name, String type, int hp, int attack, int defense, int spAttack, int spDefense, int speed, int level, int exp) {
		
		//Pokemon Info
		this.name = name;
		this.type = type;
		
		//Pokemon Stats
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.speed = speed;
		
		//Pokemon Progression
		this.level = level;
		this.exp = exp;
		
	}
	
	public String getMoves() {
		
		String output = new String();
		
		return output;
		
	}
	
	public void changeMoves() {
		
	
		
	}
	
	
}
