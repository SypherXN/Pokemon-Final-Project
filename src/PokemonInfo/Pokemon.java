package PokemonInfo;

public class Pokemon {

	/*
	 * Created by Matthew 11/17/17
	 */
	
	private int maxHP, hp, attack, defense, speed, level, exp;
	private final BasePokemon base;
	private Move[] moves = {Pokedex.NoMove, Pokedex.NoMove, Pokedex.NoMove, Pokedex.NoMove};
	
	/** 
	 * Creates a reference for Pokemon based off the BasePokemon
	 * 
	 * @param base - basepokemon object
	 * @param one - move in slot 1
	 * @param two - move in slot 2
	 * @param three - move in slot 3
	 * @param four - move in slot 4
	 * @param level - level of the pokemon object
	 */
	public Pokemon(BasePokemon base, int level) {

		this.base = base;
		this.level = level;
		this.exp = 0;
		this.maxHP = base.getHP() + (base.getHPMod() * level);
		this.attack = base.getAttack() + (base.getAttackMod() * level);
		this.defense = base.getDefense() + (base.getDefenseMod() * level);
		this.speed = base.getSpeed() + (base.getHPMod() * level);
		this.hp = this.maxHP;
		
	}
	
	//Changes all moves in the array
	public void changeAllMoves() {
		
		for(int i = 0; i < moves.length; i++) {
			
			moves[i] = new Move(Pokedex.baseMoves[(int)(Math.random() * Pokedex.baseMoves.length - 1) + 1]);
			
		}
		
	}
	
	//Changes the element in the array at index to Move move
	public void changeMove(Move move, int index) { moves[index] = move; }
	
	//Attempts to level up the Pokemon
	public boolean attemptLevelUp() {
		
		int target = 0;
		
		if (exp >= target) {
			
			exp -= target;
			target += 30;
			level += 1;
			maxHP += base.getHPMod();
			hp = maxHP;
			attack += base.getAttackMod();
			defense += base.getDefenseMod();
			speed += base.getSpeedMod();
			return true;
			
		}
		
		return false;
		
	}
	
	//Checks to see if the Pokemon can evolve
	public boolean canEvolve() {
		
		if (level >= base.getEvolveLevel()) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	//Increases hp and checks if it exceeds the max hp
	public void heal(int healAmount) {
		
		int printer = maxHP - hp;
		
		this.hp += healAmount;
		
		if (this.hp >= maxHP) {
			
			System.out.println("You healed " + base.getName() + " " + printer);
			hp = maxHP; 
			
		} else {
			
			System.out.println(healAmount);
			
		}
		
	}
	
	//Sets current HP to max HP
	public void healFull() { hp = maxHP; }
	
	//Accessor methods to get instance variables
	public BasePokemon getBase() { return base; }
	public int getMaxHP() 	{ return maxHP; }
	public int getHP() 		{ return hp; }
	public int getAttack() 	{ return attack; }
	public int getDefense() 	{ return defense; }
	public int getSpeed() 	{ return speed; }
	public int getLevel() 	{ return level; }
	public int getExp() 		{ return exp; }
	
	//Modifier methods to change instance variables
	public void changeHP(int modifier) { hp += modifier; }
	public void setHPZero() { hp = 0; }
	
	//Returns the specific element in the array
	public Move getMove(int index) { return moves[index]; }
	
	//Returns the array of moves
	public Move[] getMoves() { return moves; }
	
	//Uses to print the information of the Pokemon
	public String toString() {
		
		String output = "Name: " + base.getName() + "\nType: " + base.getFirstType().getName() + " " + base.getSecondType().getName() + 
				"\nMax HP: " + maxHP + "\nCurrent HP: " + hp + "\nAttack: " + attack + "\nDefense: " + defense + "\nSpeed: " + speed + 
				"\nLevel: " + level;
		
		return output;
		
	}
	
}
