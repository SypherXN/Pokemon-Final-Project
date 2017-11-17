package PokemonInfo;

/*
 * Created by Matthew 11/15/17
 */

public class Move {

	public final String name;
	private final int attack, pp;
	
	/* Creates a reference to Moves to store their information
	 * @param name - name of the move
	 * @param attack - attack of the move
	 * @param pp - amount of moves
	 */
	public Move(String name, int attack, int pp) {
		
		this.name = name;
		this.attack = attack;
		this.pp = pp;
		
	}
	
	
}
