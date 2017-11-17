package PokemonInfo;

public class Game {
	
	/*
	 * Created by William 11/16/17
	 */

	/************* Pokemon Types *************/
	//String type
	public static final Type
	
		Grass = new Type("Grass");
	
	/********** Base Pokemon Stats **********/
	//String name, String firstType, String secondType, int hp, int attack, int defense, int speed, int number
	public static final BasePokemon
	
		Bulbasaur = new BasePokemon("Bulbasaur", "Grass", null, 45, 49, 49, 45, 1);
	
	/************* Pokemon Moves *************/
	public static final Moves
	//String name, int attack, int pp
		
		Tackle = new Moves("Tackle", 15, 5);
	
	
}
