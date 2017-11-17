package PokemonInfo;

public class Game {
	
	/*
	 * Created by Matthew 11/16/17
	 */

	/************* Pokemon Types *************/
	public static final Type
	
		Grass = new Type("Grass");
	
	/********** Base Pokemon Stats **********/
	public static final BasePokemon
	
		Bulbasaur = new BasePokemon("Bulbasaur", "Grass", null, 45, 49, 49, 45, 1);
	
	/************* Pokemon Moves *************/
	public static final Moves
		
		Tackle = new Moves("Tackle", 15, 5);
	
	
}
