package PokemonInfo;

public class Pokedex {
	
	/*
	 * Created by William 11/16/17
	 */

	/************* Pokemon Types *************/
	//String type
	public static final Type
	
		Bug = 		new Type("Bug", 1),
		Dragon = 	new Type("Dragon", 2),
		Ice = 		new Type("Ice", 3),
		Fighting = 	new Type("Fighting", 4),
		Fire = 		new Type("Fire", 5),
		Flying = 	new Type("Flying", 6),
		Grass = 		new Type("Grass", 7),
		Ghost = 		new Type("Ghost", 8),
		Ground = 	new Type("Ground", 9),
		Electric = 	new Type("Electric", 10),
		Normal = 	new Type("Normal", 11),
		Poison = 	new Type("Poison", 12),
		Psychic = 	new Type("Psychic", 13),
		Rock = 		new Type("Rock", 14),
		Water = 		new Type("Water", 15);
	
	public void initWeaknesses() {
		
		Bug.addWeaknesses();
		Dragon.addWeaknesses();
		Ice.addWeaknesses();
		Fighting.addWeaknesses();
		Fire.addWeaknesses();
		Flying.addWeaknesses();
		Grass.addWeaknesses();
		Ghost.addWeaknesses();
		Ground.addWeaknesses();
		Electric.addWeaknesses();
		Normal.addWeaknesses();
		Poison.addWeaknesses();
		Psychic.addWeaknesses();
		Rock.addWeaknesses();
		Water.addWeaknesses();
		
	}
	
	public void initResistances() {
		
		Bug.addResistances();
		Dragon.addResistances();
		Ice.addResistances();
		Fighting.addResistances();
		Fire.addResistances();
		Flying.addResistances();
		Grass.addResistances();
		Ghost.addResistances();
		Ground.addResistances();
		Electric.addResistances();
		Normal.addResistances();
		Poison.addResistances();
		Psychic.addResistances();
		Rock.addResistances();
		Water.addResistances();
		
	}
	
	public void initNoEffect() {
		
		Bug.addNoEffect();
		Dragon.addNoEffect();
		Ice.addNoEffect();
		Fighting.addNoEffect();
		Fire.addNoEffect();
		Flying.addNoEffect();
		Grass.addNoEffect();
		Ghost.addNoEffect();
		Ground.addNoEffect();
		Electric.addNoEffect();
		Normal.addNoEffect();
		Poison.addNoEffect();
		Psychic.addNoEffect();
		Rock.addNoEffect();
		Water.addNoEffect();
		
	}
	
	/********** Base Pokemon Stats **********/
	//Name, First Type, Second Type, Base HP, Base Attack, Base Defense, Base Speed, ID Number 
	public static final BasePokemon
	
		Bulbasaur = 	new BasePokemon("Bulbasaur", Grass, null, 45, 49, 49, 45, 1),
		Ivysaur = 	new BasePokemon("Ivysaur", Grass, Poison, 60, 62, 63, 60, 2);
	
	/************* Pokemon Moves *************/
	public static final Move
	//Name, Move Type, Move Attack, Max PP
		
		Tackle = new Move("Tackle", Normal, 15, 5);
	
	
}
