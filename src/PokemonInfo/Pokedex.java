package PokemonInfo;

public class Pokedex {
	
	/*
	 * Created by William 11/16/17
	 */

	/************* Pokemon Types *************/
	//String type
	public static final Type
	
		Bug = new Type(1),
		Dragon = new Type(2),
		Ice = new Type(3),
		Fighting = new Type(4),
		Fire = new Type(5),
		Flying = new Type(6),
		Grass = new Type(7),
		Ghost = new Type(8),
		Ground = new Type(9),
		Electric = new Type(10),
		Normal = new Type(11),
		Poison = new Type(12),
		Psychic = new Type(13),
		Rock = new Type(14),
		Water = new Type(15);
	
	/********** Base Pokemon Stats **********/
	//String name, String firstType, String secondType, int hp, int attack, int defense, int speed, int number
	public static final BasePokemon
	
		Bulbasaur = new BasePokemon("Bulbasaur", "Grass", null, 45, 49, 49, 45, 1);
	
	/************* Pokemon Moves *************/
	public static final Move
	//String name, int attack, int pp
		
		Tackle = new Move("Tackle", 15, 5);
	
	
}