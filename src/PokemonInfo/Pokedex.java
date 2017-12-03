package PokemonInfo;

public class Pokedex {
	
	/*
	 * Created by William 11/16/17
	 */

	/************* Pokemon Types *************/
	//Type Name, Type Index
	public static final Type
		
		NoType = 	new Type(),
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
		
		Bug.addWeaknesses(Flying, Poison, Rock, Fire);
		Dragon.addWeaknesses(Dragon, Ice);
		Ice.addWeaknesses(Fighting, Rock, Fire);
		Fighting.addWeaknesses(Flying, Psychic);
		Fire.addWeaknesses(Ground, Rock, Water);
		Flying.addWeaknesses(Rock, Electric, Ice);
		Grass.addWeaknesses(Flying, Poison, Bug, Fire, Ice);
		Ghost.addWeaknesses(Ghost);
		Ground.addWeaknesses(Water, Grass, Ice);
		Electric.addWeaknesses(Ground);
		Normal.addWeaknesses(Fighting);
		Poison.addWeaknesses(Ground, Bug);
		Psychic.addWeaknesses(Bug);
		Rock.addWeaknesses(Fighting, Ground, Water, Grass);
		Water.addWeaknesses(Grass, Electric);
		
	}
	
	//Initializes the Resistances of the Types
	public static void initResistances() {
		
		Bug.addResistances(Fighting, Ground, Grass);
		Dragon.addResistances(Fire, Water, Grass, Electric);
		Ice.addResistances(Ice);
		Fighting.addResistances(Rock, Bug);
		Fire.addResistances(Bug, Fire, Grass);
		Flying.addResistances(Fighting, Bug, Grass);
		Grass.addResistances(Ground, Water, Grass, Electric);
		Ghost.addResistances(Poison, Bug);
		Ground.addResistances(Poison, Rock);
		Electric.addResistances(Flying, Electric);
		Normal.addResistances();
		Poison.addResistances(Fighting, Poison, Grass);
		Psychic.addResistances(Fighting, Psychic);
		Rock.addResistances(Normal, Flying, Poison, Fire);
		Water.addResistances(Fire, Water, Ice);
		
	}
	
	//Initializes the Nullification of the Types
	public static void initNoEffect() {
		
		Bug.addNoEffect();
		Dragon.addNoEffect();
		Ice.addNoEffect();
		Fighting.addNoEffect();
		Fire.addNoEffect();
		Flying.addNoEffect(Ground);
		Grass.addNoEffect();
		Ghost.addNoEffect(Normal, Fighting);
		Ground.addNoEffect(Electric);
		Electric.addNoEffect();
		Normal.addNoEffect(Ghost);
		Poison.addNoEffect();
		Psychic.addNoEffect(Ghost);
		Rock.addNoEffect();
		Water.addNoEffect();
		
	}
	
	/********** Base Pokemon Stats **********/
	//Pokemon Name, First Type, Second Type, Base HP, Base Attack, Base Defense, Base Speed, ID Number, HP Modifier, Attack Modifier, Defense Modifier, Speed Modifier, Evolve Level
	public static final BasePokemon
		
		NoBasePokemon = new BasePokemon(),
		Bulbasaur = 	new BasePokemon("Bulbasaur", Grass, Poison, 45, 49, 49, 45, 1, 2, 1, 1, 1, 16),
		Ivysaur = 		new BasePokemon("Ivysaur", Grass, Poison, 60, 62, 63, 60, 2, 2, 2, 2, 2, 32),
		Venasaur =		new BasePokemon("Venasaur", Grass, Poison, 80, 82, 83, 80, 3, 3, 2, 2, 2, 101),
		Charmander =	new BasePokemon("Charmander", Fire, NoType, 39, 52, 43, 65, 4, 2, 2, 2, 2, 16),
		Charmeleon =	new BasePokemon("Charmeleon", Fire, NoType, 58, 64, 58, 80, 5, 3, 2, 2, 2, 36),
		Charizard =		new BasePokemon("Charizard", Fire, Flying, 78, 84, 78, 100, 6, 3, 2, 2, 2, 101),
		Squirtle = 		new BasePokemon("Squirtle", Water, NoType, 44, 48, 65, 43, 7, 2, 2, 2, 2, 16),
		Wartortle = 	new BasePokemon("Wartortle", Water, NoType, 59, 63, 80, 58, 8, 3, 2, 2, 2, 36),
		Blastoise = 	new BasePokemon("Blastoise", Water, NoType, 79, 83, 100, 78, 9, 3, 2, 2, 2, 101),
		Caterpie = 		new BasePokemon("Caterpie", Bug, NoType, 45, 30, 35, 45, 10, 2, 1, 2, 2, 7),
		Metapod = 		new BasePokemon("Metapod", Bug, NoType, 50, 20, 55, 30, 11, 3, 1, 2, 1, 10),
		Butterfree = 	new BasePokemon("Butterfree", Bug, Flying, 60, 45, 50, 70, 12, 3, 2, 2, 2, 101),
		Weedle = 		new BasePokemon("Weedle", Bug, Poison, 40, 35, 30, 50, 13, ),
		Kakuna = 		new BasePokemon("Kakuna", Bug, Poison, 45, 25, 50, 35, 25, 14),
		Beedrill = 		new BasePokemon("Beedrill", Bug, Poison, 65, 80, 40, 75, 15),
		Pidgey = 		new BasePokemon("Pidgey", Normal, Flying, 40, 45, 40, 56, 16),
		Pidgeotto = 	new BasePokemon("Pidgeotto", Normal, Flying, 63, 60, 55, 71, 17),
		Pidgeot = 		new BasePokemon("Pidgeot", Normal, Flying, 83, 80, 75, 91, 18),
		Rattata = 		new BasePokemon("Rattata", Normal, NoType, 30, 56, 35, 72, 19),
		Raticate = 		new BasePokemon("Raticate", Normal, NoType, 55, 81, 60, 97, 20),
		Spearow = 		new BasePokemon("Spearow", Normal, Flying, 40, 60, 30, 70, 21),
		Fearow = 		new BasePokemon("Fearow", Normal, Flying, 65, 90, 65, 100, 22),
		Ekans = 		new BasePokemon("Ekans", Poison, NoType, 35, 60, 44, 55, 23),
		Arbok = 		new BasePokemon("Arbok", Poison, NoType, 60, 85, 69, 80, 24),
		Pikachu = 		new BasePokemon("Pikachu", Electric, NoType, 35, 55, 30, 90, 25),
		Raichu = 		new BasePokemon("Raichu", Electric, NoType, 60, 90, 55, 100, 26),
		Sandshrew = 	new BasePokemon("Sandshrew", Ground, NoType, 50, 75, 85, 40, 27),
		Sandslash = 	new BasePokemon("Sandslash", Ground, NoType, 75, 100, 110, 65, 28),
		NidoranF = 	new BasePokemon("Nidoran F", Poison, NoType, 55, 47, 52, 41, 29),
		Nidorina = 		new BasePokemon("Nidorina", Poison, NoType, 70, 62, 67, 56, 30),
		Nidoqueen = 	new BasePokemon("Nidoqueen", Poison, Ground, 90, 82, 87, 76, 31),
		NidoranM = 	new BasePokemon("Nidoran M", Poison, NoType, 46, 57, 40, 50, 32),
		Nidorino = 		new BasePokemon("Nidorino", Poison, NoType, 61, 72, 57, 65, 33),
		Nidoking = 		new BasePokemon("Nidoking", Poison, Ground, 81, 92, 77, 85, 34),
		Clefairy = 		new BasePokemon("Clefairy", Normal, NoType, 70, 45, 48, 35, 35),
		Clefable = 		new BasePokemon("Clefable", Normal, NoType, 95, 70, 73, 60, 36),
		Vulpix = 		new BasePokemon("Vulpix", Fire, NoType, 38, 41, 40, 65, 37),
		Ninetales = 	new BasePokemon("Ninetales", Fire, NoType, 73, 76, 75, 100, 38),
		Jigglypuff = 	new BasePokemon("Jigglypuff", Normal, NoType, 115, 45, 20, 20, 39),
		Wigglytuff = 	new BasePokemon("Wigglytuff", Normal, NoType, 140, 70, 45, 45, 40),
		Zubat = 		new BasePokemon("Zubat", Poison, Flying, 40, 45, 35, 55, 41),
		Goldbat = 		new BasePokemon("Golbat", Poison, Flying, 75, 80, 70, 90, 42),
		Oddish = 		new BasePokemon("Oddish", Grass, Poison, 45, 50, 55, 30, 43),
		Gloom  = 		new BasePokemon("Gloom", Grass, Poison, 60, 65, 70, 40, 44),
		Vileplume = 	new BasePokemon("Vileplume", Grass, Poison, 75, 80, 85, 50, 45),
		Paras = 		new BasePokemon("Paras", Bug, Grass, 35, 70, 55, 25, 46),
		Parasect = 		new BasePokemon("Parasect", Bug, Grass, 60, 95, 80, 30, 47),
		Venonat = 		new BasePokemon("Venonant", Bug, Poison, 60, 55, 50, 45, 40, 48),
		Venomoth = 		new BasePokemon("Venomoth", Bug, Poison, 70, 65, 60, 90, 49),
		Diglett = 		new BasePokemon("Diglett", Ground, NoType, 10, 55, 25, 95, 50),
		Dugtrio = 		new BasePokemon("Dugtrio", Ground, NoType, 35, 80, 50, 120, 51);
	
	
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
