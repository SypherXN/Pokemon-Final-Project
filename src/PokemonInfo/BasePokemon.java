package PokemonInfo;

import java.util.*;

/*
 * Created by Matthew 11/15/17
 */

public class BasePokemon {

	private final String name, firstType, secondType; 
	private final int hp, attack, defense, speed, number;
	
	/* Creates a reference to Pokemon that contains their stats and info
	 * @param name - name of the Pokemon
	 * @param type - type of the Pokemon
	 * @param hp - base hp of the Pokemon when caught
	 * @param attack - base attack of the Pokemon when caught
	 * @param defense - base defense of the Pokemon when caught
	 * @param speed - base speed of the Pokemon when caught
	 */
	public BasePokemon(String name, String firstType, String secondType, int hp, int attack, int defense, int speed, int number) {
		
		//Pokemon Info
		this.name = name;
		this.firstType = firstType;
		this.secondType = secondType;
		this.number = number;
		
		//Pokemon Base Stats
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		
	}
	
	
}
