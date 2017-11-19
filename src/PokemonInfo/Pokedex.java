package PokemonInfo;

public class Pokedex {
	
	/*
	 * Created by William 11/16/17
	 */

	/************* Pokemon Types *************/
	//Type Name, Type Index
	public static final Type
	
		Bug = 		new Type("Bug", 1),
		Dragon = 	new Type("Dragon", 2),
		Ice = 		new Type("Ice", 3),
		Fighting = 	new Type("Fighting", 4),
		Fire = 		new Type("Fire", 5),
		Flying = 	new Type("Flying", 6),
		Grass = 	new Type("Grass", 7),
		Ghost = 	new Type("Ghost", 8),
		Ground = 	new Type("Ground", 9),
		Electric = 	new Type("Electric", 10),
		Normal = 	new Type("Normal", 11),
		Poison = 	new Type("Poison", 12),
		Psychic = 	new Type("Psychic", 13),
		Rock = 		new Type("Rock", 14),
		Water = 	new Type("Water", 15);
	
	//Initializes the Weaknesses of the Types
	public static void initWeaknesses() {
		
		Bug.addWeaknesses();
		Dragon.addWeaknesses(Dragon, Ice);
		Ice.addWeaknesses();
		Fighting.addWeaknesses();
		Fire.addWeaknesses();
		Flying.addWeaknesses();
		Grass.addWeaknesses();
		Ghost.addWeaknesses();
		Ground.addWeaknesses(Water);
		Electric.addWeaknesses();
		Normal.addWeaknesses();
		Poison.addWeaknesses();
		Psychic.addWeaknesses();
		Rock.addWeaknesses();
		Water.addWeaknesses();
		
	}
	
	//Initializes the Resistances of the Types
	public static void initResistances() {
		
		Bug.addResistances();
		Dragon.addResistances(Fire, Grass);
		Ice.addResistances();
		Fighting.addResistances();
		Fire.addResistances();
		Flying.addResistances();
		Grass.addResistances();
		Ghost.addResistances();
		Ground.addResistances(Fire);
		Electric.addResistances();
		Normal.addResistances();
		Poison.addResistances();
		Psychic.addResistances();
		Rock.addResistances();
		Water.addResistances();
		
	}
	
	//Initializes the Nullification of the Types
	public static void initNoEffect() {
		
		Bug.addNoEffect();
		Dragon.addNoEffect();
		Ice.addNoEffect();
		Fighting.addNoEffect();
		Fire.addNoEffect();
		Flying.addNoEffect();
		Grass.addNoEffect();
		Ghost.addNoEffect();
		Ground.addNoEffect(Electric);
		Electric.addNoEffect();
		Normal.addNoEffect();
		Poison.addNoEffect();
		Psychic.addNoEffect();
		Rock.addNoEffect();
		Water.addNoEffect();
		
	}
	
	/********** Base Pokemon Stats **********/
	//Pokemon Name, First Type, Second Type, Base HP, Base Attack, Base Defense, Base Speed, ID Number 
	public static final BasePokemon
	
		Bulbasaur = 	new BasePokemon("Bulbasaur", Grass, null, 45, 49, 49, 45, 1),
		Ivysaur = 	new BasePokemon("Ivysaur", Grass, Poison, 60, 62, 63, 60, 2);
	
	/************** Base Moves **************/
	//Name, Move Type, Move Attack, Max PP
	public static final BaseMove
		
		Tackle = new BaseMove("Tackle", Normal, 15, 5);
	
	/***************** Items *****************/
	//Item Name, Item Value
	public static final Item
	
		Potion = new Item("Potion", 50);
	
	
	
}
