package PokemonInfo;

public class Pokemon {

	/*
	 * Created by Matthew 11/17/17
	 */
	
	public int maxHP, hp, attack, defense, speed, level, exp;
	public final BasePokemon base;
	public Move[] moves = {Pokedex.NoMove, Pokedex.NoMove, Pokedex.NoMove, Pokedex.NoMove};
	
	/* Creates a reference for Pokemon based off the BasePokemon
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
		this.maxHP = base.hp + (base.hpMod * level);
		this.attack = base.attack + (base.attackMod * level);
		this.defense = base.defense + (base.defenseMod * level);
		this.speed = base.speed + (base.speedMod * level);
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
			maxHP += base.hpMod;
			hp = maxHP;
			attack += base.attackMod;
			defense += base.defenseMod;
			speed += base.speedMod;
			return true;
			
		}
		
		return false;
		
	}
	
	//Checks to see if the Pokemon can evolve
	public boolean canEvolve() {
		
		if (level >= base.evolveLevel) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	//Increases hp and checks if it exceeds the max hp
	public void heal(int healAmount) {
		
		this.hp += healAmount;
		if (this.hp >= maxHP)
			hp = maxHP;
		
	}
	
	public void increaseMaxHP() {	}
	
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

	//Returns the specific element in the array
	public Move getMove(int index) { return moves[index]; }
	
	//Returns the array of moves
	public Move[] getMoves() { return moves; }
	
	//Uses to print the information of the Pokemon
	public String toString() {
		
		String output = "Name: " + base.name + "\nType: " + base.firstType.getName() + " " + base.secondType.getName() + 
				"\nMax HP: " + maxHP + "\nCurrent HP: " + hp + "\nAttack: " + attack + "\nDefense: " + defense + "\nSpeed: " + speed + 
				"\nLevel: " + level;
		
		return output;
		
	}
	
}
