package PokemonInfo;

import java.util.*;

/*
 * Created by Matthew 11/15/17
 */

public class BasePokemon {

	public final String name;
	public final Type firstType, secondType;
	public final int hp, attack, defense, speed, number;
	public final int hpMod, attackMod, defenseMod, speedMod;
	public final int evolveLevel;
	
	/* Creates a reference to Pokemon that contains their stats and info
	 * @param name - name of the Pokemon
	 * @param firstType - first type of the Pokemon
	 * @param secondType - second type of the Pokemon
	 * @param number - pokedex number of the Pokemon
	 * @param evolveLevel - level the Pokemon can evolve at
	 * @param hp - base hp of the Pokemon when caught
	 * @param attack - base attack of the Pokemon when caught
	 * @param defense - base defense of the Pokemon when caught
	 * @param speed - base speed of the Pokemon when caught
	 * @param hpMod - hp modifier for leveling up
	 * @param attackMod - attack modifier for leveling up
	 * @param defenseMod - defense modifier for leveling up
	 * @param speedMod - speed modifier for leveling up
	 */
	public BasePokemon(String name, Type firstType, Type secondType, int hp, int attack, int defense, int speed, int number, int hpMod, int attackMod, int defenseMod, int speedMod, int evolveLevel) {
		
		//Pokemon Info
		this.name = name;
		this.firstType = firstType;
		this.secondType = secondType;
		this.number = number;
		this.evolveLevel = evolveLevel;
		
		//Pokemon Base Stats
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		
		//Pokemon Stats Modifiers
		this.hpMod = hpMod;
		this.attackMod = attackMod;
		this.defenseMod = defenseMod;
		this.speedMod = speedMod;
		
	}
	
	//Zero-Arg Constructor for NoBasePokemon
	public BasePokemon() {
		
		//Pokemon Info
		this.name = "";
		this.firstType = Pokedex.NoType;
		this.secondType = Pokedex.NoType;
		this.number = 0;
		this.evolveLevel = 101;
		
		//Pokemon Base Stats
		this.hp = 0;
		this.attack = 0;
		this.defense = 0;
		this.speed = 0;
		
		//Pokemon Stats Modifiers
		this.hpMod = 0;
		this.attackMod = 0;
		this.defenseMod = 0;
		this.speedMod = 0;
		
	}
	
	//Test print to make sure BasePokemon objects work
	public String toString() {
		
		String output = new String();
		
		output = "Name: " + name + "\nType: " + firstType.getName() + "," + secondType.getName() + "\nHP: " + hp + 
				"\nAttack: " + attack + "\nDefense: " + defense + "\nSpeed: " + speed + "\nNumber: " + number;
		
		return output;
		
	}
	
}
