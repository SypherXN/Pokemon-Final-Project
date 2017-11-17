package PokemonInfo;

/*
 * Created by Matthew 11/15/17
 */

public class Move {

	public final String name;
	public final Type type;
	public final int attack, maxPP;
	
	/* Creates a reference to Moves to store their information
	 * @param name - name of the move
	 * @param type - type of the move
	 * @param attack - attack of the move
	 * @param pp - amount of moves
	 */
	public Move(String name, Type type, int attack, int maxPP) {
		
		this.name = name;
		this.type = type;
		this.attack = attack;
		this.maxPP = maxPP;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public Type getType() {
		
		return type;
		
	}
	
	public int getAttack() {
		
		return attack;
		
	}
	
	public int getMaxPP() {
		
		return maxPP;
		
	}
	
	
}
