package PokemonInfo;

import java.util.*;

/*
 * Created by Matthew 11/15/17
 */

public abstract class BasePokemon {

	private final int level, exp;
	private final int hp, attack, defense, spAttack, spDefense, speed;
	private final String name, type;
	
	public BasePokemon(String name, String type, int hp, int attack, int defense, int spAttack, int spDefense, int speed, int level, int exp) {
		
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.speed = speed;
		this.level = level;
		this.exp = exp;
		
	}
	
	
}
