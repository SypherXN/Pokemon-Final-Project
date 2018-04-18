package PokemonInfo;

public class Pokemon {

	/*
	 * Created by Matthew 11/17/17
	 */
	
	private int maxHP, hp, attack, defense, speed, level, exp;
	private final BasePokemon base;
	private Move[] moves = {Pokedex.NoMove, Pokedex.NoMove, Pokedex.NoMove, Pokedex.NoMove};
	
	/** Creates a reference for Pokemon based off the BasePokemon
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
	
	/** Randomizes the Pokemon's moves */
	public void changeAllMoves() {
		
		for(int i = 0; i < moves.length; i++) {
			
			moves[i] = new Move(Pokedex.baseMoves[(int)(Math.random() * Pokedex.baseMoves.length - 1) + 1]);
			
		}
		
	}
	
	/** Changes the Move at index to move
	 * 
	 * @param move - The Move to change to
	 * @param index - The index which to change at
	 */
	public void changeMove(Move move, int index) { moves[index] = move; }
	
	/** Attempts to level up Pokemon
	 * 
	 * @return - true if it can level up, false if not
	 */
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
	
	/** Checks to see if Pokemon can evolve */
	public boolean canEvolve() {
		
		if (level >= base.getEvolveLevel()) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	/** Increases hp and checks if it exceeds maxHP
	 * 
	 * @param healAmount - Amount to heal
	 */
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
	
	/** Sets hp to equal maxHP */
	public void healFull() { hp = maxHP; }
	
	//-----Accessor methods to get instance variables-----//
	public BasePokemon getBase() { return base; }
	public int getMaxHP() 	{ return maxHP; }
	public int getHP() 		{ return hp; }
	public int getAttack() 	{ return attack; }
	public int getDefense() 	{ return defense; }
	public int getSpeed() 	{ return speed; }
	public int getLevel() 	{ return level; }
	public int getExp() 		{ return exp; }
	public Move getMove(int index) { return moves[index]; }
	public Move[] getMoves() { return moves; }
	
	//-----Modifier methods to change instance variables-----//
	/** Changes hp by modifier
	 * 
	 * @param modifier - Amount to change hp by
	 */
	public void changeHP(int modifier) { hp += modifier; }
	/** Sets hp to zero */
	public void setHPZero() { hp = 0; }
	
	/** Used to print information about Pokemon */
	public String toString() {
		
		String output = "Name: " + base.getName() + "\nType: " + base.getFirstType().getName() + " " + base.getSecondType().getName() + 
				"\nMax HP: " + maxHP + "\nCurrent HP: " + hp + "\nAttack: " + attack + "\nDefense: " + defense + "\nSpeed: " + speed + 
				"\nLevel: " + level;
		
		return output;
		
	}
	
}
