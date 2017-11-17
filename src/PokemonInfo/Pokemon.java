package PokemonInfo;

public class Pokemon {

	public int hp, attack, defense, speed, level, exp;
	
	public Pokemon(int hp, int attack, int defense, int speed, int level, int exp) {
		
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.level = level;
		this.exp = exp;
		
	}
	
	
	
	public int getHP() { return hp; }
	
	public int getAttack() { return attack; }
	
	public int getDefense() { return defense; }
	
	public int getSpeed() { return speed; }
	
	public int getLevel() { return level; }
	
	public int getExp() { return exp; }
	
}
