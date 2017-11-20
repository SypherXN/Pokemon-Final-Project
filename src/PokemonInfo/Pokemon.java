package PokemonInfo;

public class Pokemon {

	/*
	 * Created by Matthew 11/17/17
	 */
	
	public int maxHP, hp, attack, defense, speed, level, exp;
	public final BasePokemon base;
	public Move[] moves = new Move[4];
	
	/* Creates a reference for Pokemon based off the BasePokemon
	 * @param base - basepokemon object
	 * @param one - move in slot 1
	 * @param two - move in slot 2
	 * @param three - move in slot 3
	 * @param four - move in slot 4
	 * @param level - level of the pokemon object
	 */
	public Pokemon(BasePokemon base, int level) {

		this.base = 	base;
		this.maxHP = base.getHP();
		this.hp = base.getHP();
		this.attack = base.getAttack();
		this.defense = base.getDefense();
		this.speed = base.getSpeed();
		this.level = level;
		
	}
	
	public void changeMove(Move move, int moveIndex) { moves[moveIndex] = move; }
	
	public Move getMove(int index) { return moves[index]; }
	
	public void increaseMaxHP() {	}

	public void increaseHP() {	}
	
	public void increaseAttack() {	}
	
	public void increaseDefense() {	}
	
	public void increaseSpeed() {	}
	
	public void increaseLevel() {	}
	
	public void increaseEXP() {	}
	
	public int getMaxHP() 	{ return maxHP; }
	
	public int getHP() 		{ return hp; }
	
	public int getAttack() 	{ return attack; }
	
	public int getDefense() 	{ return defense; }
	
	public int getSpeed() 	{ return speed; }
	
	public int getLevel() 	{ return level; }
	
	public int getExp() 		{ return exp; }
	
	public String toString() {
		
		String output = "Name: " + base.getName() + "\nType: " + base.getFirstType().getName() + " " + base.getSecondType().getName() + 
				"\nMax HP: " + maxHP + "\nCurrent HP: " + hp + "\nAttack: " + attack + "\nDefense: " + defense + "\nSpeed: " + speed + 
				"\nLevel: " + level;
		
		return output;
		
	}
	
}
