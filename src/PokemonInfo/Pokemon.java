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

		this.base = 	base;
		this.level = level;
		this.exp = 0;
		this.maxHP = base.getHP() + (base.getMaxHPMod() * level);
		this.attack = base.getAttack() + (base.getAttackMod() * level);
		this.defense = base.getDefense() + (base.getDefenseMod() * level);
		this.speed = base.getSpeed() + (base.getSpeedMod() * level);
		this.hp = this.maxHP;
		
	}
	
	public void changeMove(Move move, int index) { moves[index] = move; }
	
	public boolean attemptLevelUp() {
		
		int target = 0;
		
		if (exp >= target) {
			
			exp -= target;
			target += 30;
			level += 1;
			maxHP += base.getMaxHPMod();
			hp = maxHP;
			attack += base.getAttackMod();
			defense += base.getDefenseMod();
			speed += base.getSpeedMod();
			return true;
			
		}
		
		return false;
		
	}
	
	public boolean canEvolve() {
		
		int targetLevel = 0;
		
		if (level >= targetLevel) {
			
			return true;
			
		}
		
		return false;
		
	}
	
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

	public Move getMove(int index) { return moves[index]; }
	
	public Move[] getMoves() { return moves; }
	
	public String toString() {
		
		String output = "Name: " + base.getName() + "\nType: " + base.getFirstType().getName() + " " + base.getSecondType().getName() + 
				"\nMax HP: " + maxHP + "\nCurrent HP: " + hp + "\nAttack: " + attack + "\nDefense: " + defense + "\nSpeed: " + speed + 
				"\nLevel: " + level;
		
		return output;
		
	}
	
}
