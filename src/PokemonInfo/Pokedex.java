package PokemonInfo;

public class Pokedex {
	
	/*
	 * Created by William 11/16/17
	 */

	/************* Pokemon Types *************/
	//Type Name, Type Index
	public static final Type
		
		NoType = 	new Type("", 0),
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
	//Pokemon Name, First Type, Second Type, Base HP, Base Attack, Base Defense, Base Speed, ID Number, HP Modifier, Attack Modifier, Defense Modifier, Speed Modifier, Evolve Level
	public static final BasePokemon
		
		NoBasePokemon = new BasePokemon("", NoType, NoType, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
		Bulbasaur = 	new BasePokemon("Bulbasaur", Grass, Poison, 45, 49, 49, 45, 1, 2, 1, 1, 1, 16),
		Ivysaur = 		new BasePokemon("Ivysaur", Grass, Poison, 60, 62, 63, 60, 2, 2, 2, 2, 2, 32),
		Venasaur =		new BasePokemon("Venasaur", Grass, Poison, 80, 82, 83, 80, 3, 3, 2, 2, 2, 101);
	
	/************** Base Moves **************/
	//Name, Move Type, Move Attack, Max PP
	public static final BaseMove
		
		NoBaseMove = new BaseMove("", NoType, 0, 0),
		Absorb = new BaseMove("Absorb", Grass, 20, 25),
		Acid = new BaseMove("Acid", Poison,40, 30),
		AuroraBeam = new BaseMove("Aurora Beam", Ice, 65, 20),
		Barrage = new BaseMove("Barrage", Normal, 15, 20),
		Bind = new BaseMove("Bind", Normal, 15, 20),
		Tackle = new BaseMove("Tackle", Normal, 15, 5),
		RazorLeaf = new BaseMove("Razor Leaf", Grass, 35, 15);
	
	/***************** Items *****************/
	//Item Name, Item Value
	public static final Item
	
		Potion = new Item("Potion", 20),
		SuperPotion = new Item("Super Potion", 50),
		HyperPotion = new Item("Hyper Potion", 200),
		MaxPotion = new Item("Max Potion", 9999999);
	
	/*************** Pokemon ****************/
	//PLACE HOLDER POKEMON WHEN THERE IS NOTHING
	public static final Pokemon NoPokemon = new Pokemon(NoBasePokemon, 0);
	
	/***************** Move *****************/
	//PLACE HOLDER POKEMON MOVE WHEN THERE IS NONE
	public static final Move NoMove = new Move(NoBaseMove);
	
	
	
}
