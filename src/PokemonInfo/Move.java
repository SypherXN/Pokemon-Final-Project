package PokemonInfo;

public class Move {

	/*
	 * Created by Matthew 11/17/17
	 */
	
	private BaseMove base;
	private int pp;
	
	/** 
	 * Creates an reference to the Move
	 * 
	 * @param base - base stats of the move
	 */
	public Move(BaseMove base) {
		
		this.base = base;
		this.pp = base.getMaxPP();
		
	}
	
	//Attempts to use the move
	public boolean attemptUseMove() {
		
		if (pp > 0) {
			
			pp -= 1;
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	//Accessor methods to get instance variables
	public Type getType() { return base.getType(); }
	public int getAttack() { return base.getAttack(); }
	public int getPP() { return pp; }
	public BaseMove getBase() { return base; }
	
}
