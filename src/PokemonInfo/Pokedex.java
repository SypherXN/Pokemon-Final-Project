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
	//Pokemon Name, First Type, Second Type, Base HP, Base Attack, Base Defense, Base Speed, ID Number, HP at LVL 100, Attack at LVL 100, Defense at LVL 100, Speed at LVL 100, Evolve Level
	public static final BasePokemon[] basePokemons = {
		
		new BasePokemon(),
		new BasePokemon("Bulbasaur", Grass, Poison, 45, 49, 49, 45, 1, 293, 196, 196, 188, 16),
		new BasePokemon("Ivysaur", Grass, Poison, 60, 62, 63, 60, 2, 323, 222, 224, 218, 32),
		new BasePokemon("Venasaur", Grass, Poison, 80, 82, 83, 80, 3, 363, 262, 264, 258, 101),
		new BasePokemon("Charmander", Fire, NoType, 39, 52, 43, 65, 4, 182, 202, 184, 228, 16),
		new BasePokemon("Charmeleon", Fire, NoType, 58, 64, 58, 80, 5, 319, 226, 214, 258, 36),
		new BasePokemon("Charizard", Fire, Flying, 78, 84, 78, 100, 6, 359, 266, 254, 298, 101),
		new BasePokemon("Squirtle", Water, NoType, 44, 48, 65, 43, 7, 291, 194, 228, 184, 16),
		new BasePokemon("Wartortle", Water, NoType, 59, 63, 80, 58, 8, 321, 224, 258, 214, 36),
		new BasePokemon("Blastoise", Water, NoType, 79, 83, 100, 78, 9, 361, 264, 298, 254, 101),
		new BasePokemon("Caterpie", Bug, NoType, 45, 30, 35, 45, 10, 293, 158, 168, 188, 7),
		new BasePokemon("Metapod", Bug, NoType, 50, 20, 55, 30, 11, 303, 138, 208, 158, 10),
		new BasePokemon("Butterfree", Bug, Flying, 60, 45, 50, 70, 12, 323, 188, 198, 238, 101),
		new BasePokemon("Weedle", Bug, Poison, 40, 35, 30, 50, 13, 283, 168, 158, 198, 7),
		new BasePokemon("Kakuna", Bug, Poison, 45, 25, 50, 35, 14, 293, 148, 198, 168, 10),
		new BasePokemon("Beedrill", Bug, Poison, 65, 80, 40, 75, 15, 333, 258, 178, 248, 101),
		new BasePokemon("Pidgey", Normal, Flying, 40, 45, 40, 56, 16, 283, 188, 178, 210, 18),
		new BasePokemon("Pidgeotto", Normal, Flying, 63, 60, 55, 71, 17, 329, 218, 208, 240, 36),
		new BasePokemon("Pidgeot", Normal, Flying, 83, 80, 75, 91, 18, 369, 258, 248, 280, 101),
		new BasePokemon("Rattata", Normal, NoType, 30, 56, 35, 72, 19, 263, 210, 168, 242, 20),
		new BasePokemon("Raticate", Normal, NoType, 55, 81, 60, 97, 20, 313, 260, 218, 292, 101),
		new BasePokemon("Spearow", Normal, Flying, 40, 60, 30, 70, 21, 283, 218, 158, 238, 20),
		new BasePokemon("Fearow", Normal, Flying, 65, 90, 65, 100, 22, 333, 278, 228, 298, 101),
		new BasePokemon("Ekans", Poison, NoType, 35, 60, 44, 55, 23, 273, 218, 186, 208, 22),
		new BasePokemon("Arbok", Poison, NoType, 60, 85, 69, 80, 24, 323, 268, 236, 258, 101),
		new BasePokemon("Pikachu", Electric, NoType, 35, 55, 30, 90, 25, 273, 208, 158, 278, 101),
		new BasePokemon("Raichu", Electric, NoType, 60, 90, 55, 100, 26, 323, 278, 208, 298, 101),
		new BasePokemon("Sandshrew", Ground, NoType, 50, 75, 85, 40, 27, 303, 248, 268, 178, 22),
		new BasePokemon("Sandslash", Ground, NoType, 75, 100, 110, 65, 28, 353, 298, 318, 228, 101),
		new BasePokemon("Nidoran F", Poison, NoType, 55, 47, 52, 41, 29, 313, 192, 202, 180, 16),
		new BasePokemon("Nidorina", Poison, NoType, 70, 62, 67, 56, 30, 343, 222, 232, 210, 101),
		new BasePokemon("Nidoqueen", Poison, Ground, 90, 82, 87, 76, 31, 383, 262, 272, 250, 101),
		new BasePokemon("Nidoran M", Poison, NoType, 46, 57, 40, 50, 32, 295, 212, 178, 198, 16),
		new BasePokemon("Nidorino", Poison, NoType, 61, 72, 57, 65, 33, 325, 242, 212, 228, 101),
		new BasePokemon("Nidoking", Poison, Ground, 81, 92, 77, 85, 34, 365, 282, 252, 268, 101),
		new BasePokemon("Clefairy", Normal, NoType, 70, 45, 48, 35, 35, 343, 188, 194, 168, 101),
		new BasePokemon("Clefable", Normal, NoType, 95, 70, 73, 60, 36, 393, 238, 244, 218, 101),
		new BasePokemon("Vulpix", Fire, NoType, 38, 41, 40, 65, 37, 279, 180, 178, 228, 101),
		new BasePokemon("Ninetales", Fire, NoType, 73, 76, 75, 100, 38, 349, 250, 248, 298, 101),
		new BasePokemon("Jigglypuff", Normal, NoType, 115, 45, 20, 20, 39, 433, 188, 138, 138, 101),
		new BasePokemon("Wigglytuff", Normal, NoType, 140, 70, 45, 45, 40, 483, 238, 188, 188, 101),
		new BasePokemon("Zubat", Poison, Flying, 40, 45, 35, 55, 41, 283, 188, 168, 208, 22),
		new BasePokemon("Golbat", Poison, Flying, 75, 80, 70, 90, 42, 353, 258, 238, 278, 101),
		new BasePokemon("Oddish", Grass, Poison, 45, 50, 55, 30, 43, 292, 198, 208, 158, 21),
		new BasePokemon("Gloom", Grass, Poison, 60, 65, 70, 40, 44, 323, 228, 238, 178, 101),
		new BasePokemon("Vileplume", Grass, Poison, 75, 80, 85, 50, 45, 353, 258, 268, 198, 101),
		new BasePokemon("Paras", Bug, Grass, 35, 70, 55, 25, 46, 273, 238, 208, 148, 24),
		new BasePokemon("Parasect", Bug, Grass, 60, 95, 80, 30, 47, 323, 288, 258, 158, 101),
		new BasePokemon("Venonant", Bug, Poison, 60, 55, 50, 45, 48, 323, 208, 198, 188, 31),
		new BasePokemon("Venomoth", Bug, Poison, 70, 65, 60, 90, 49, 343, 228, 218, 278, 101),
		new BasePokemon("Diglett", Ground, NoType, 10, 55, 25, 95, 50, 223, 208, 148, 288, 26),
		new BasePokemon("Dugtrio", Ground, NoType, 35, 80, 50, 120, 51, 273, 258, 198, 338, 101)


		
	};	
	
	
	/************** Base Moves **************/
	//Name, Move Type, Move Attack, Max PP
	public static final BaseMove[] baseMoves = {
		
		new BaseMove("", NoType, 0, 0),
		new BaseMove("Absorb", Grass, 20, 25),
		new BaseMove("Acid", Poison, 40, 30),
		new BaseMove("Aurora Beam", Ice, 65, 20),
		new BaseMove("Barrage", Normal, 15, 20),
		new BaseMove("Bind", Normal, 15, 20),
		new BaseMove("Blizzard", Ice, 110, 5),
		new BaseMove("Body Slam", Normal, 85, 15),
		new BaseMove("Bone Club", Ground, 65, 20),
		new BaseMove("Bonemerange", Ground, 50, 10),
		new BaseMove("Bubble", Water, 40, 30),
		new BaseMove("Bubble Beam", Water, 65, 20),
		new BaseMove("Clamp", Water, 35, 10),
		new BaseMove("Comet Punch", Normal, 18, 15),
		new BaseMove("Confusion", Psychic, 50, 25),
		new BaseMove("Constrict", Normal, 10, 35),
		new BaseMove("Crabhammer", Water, 100, 10),
		new BaseMove("Cut", Normal, 50, 30),
		new BaseMove("Dig", Ground, 80, 10),
		new BaseMove("Dizzy Punch", Normal, 70, 10),
		new BaseMove("Double Kick", Fighting, 30, 30),
		new BaseMove("Double Slap", Normal, 15, 10),
		new BaseMove("Double Edge", Normal, 120, 15),
		new BaseMove("Dragon Rage", Dragon, 40, 10),
		new BaseMove("Dream Eater", Psychic, 100, 15),
		new BaseMove("Drill Peck", Flying, 80, 20),
		new BaseMove("Earthquake", Ground, 100, 10),
		new BaseMove("Egg Bomb", Normal, 100, 10),
		new BaseMove("Ember", Fire, 40, 25),
		new BaseMove("Explosion", Normal, 250, 5),
		new BaseMove("Fire Blast", Fire, 110, 5),
		new BaseMove("Fire Punch", Fire, 75, 15),
		new BaseMove("Fire Spin", Fire, 35, 15),
		new BaseMove("Flamethrower", Fire, 90, 15),
		new BaseMove("Fly", Flying, 90, 15),
		new BaseMove("Fury Attack", Normal, 15, 20),
		new BaseMove("Fury Swipes", Normal, 18, 15),
		new BaseMove("Gust", Flying, 40, 35),
		//new BaseMove("GG", Dragon, 999999999, 999999999),
		new BaseMove("Headbutt", Normal, 70, 15),
		new BaseMove("High Jump Kick", Fighting, 130, 10), 
		new BaseMove("Horn Attack", Normal, 65, 25),
		new BaseMove("Hydro Pump", Water, 110, 5),
		new BaseMove("Hyper Beam", Normal, 150, 5),
		new BaseMove("Hyper Fang", Normal, 80, 15),
		new BaseMove("Ice Beam", Ice, 90, 10),
		new BaseMove("Ice Punch", Ice, 75, 15),
		new BaseMove("Jump Kick", Fighting, 100, 10),
		new BaseMove("Karate Chop", Fighting, 50, 25),
		new BaseMove("Leech Life", Bug, 80, 10),
		new BaseMove("Lick", Ghost, 30, 30),
		new BaseMove("Mega Drain", Grass, 40, 15),
		new BaseMove("Mega Kick", Normal, 120, 5),
		new BaseMove("Mega Punch", Normal, 80, 20),
		new BaseMove("Pay Day", Normal, 40, 20),
		new BaseMove("Peck", Flying, 35, 35),
		new BaseMove("Petal Dance", Grass, 120, 10),
		new BaseMove("Pin Missile", Bug, 25, 20),
		new BaseMove("Poison Sting", Poison, 15, 35),
		new BaseMove("Pound", Normal, 40, 35),
		new BaseMove("Psybeam", Psychic, 65, 20),
		new BaseMove("Psychic", Psychic, 90, 10),
		new BaseMove("Quick Attack", Normal, 40, 30),
		new BaseMove("Rage", Normal, 20, 20),
		new BaseMove("Razor Leaf", Grass, 55, 25),
		new BaseMove("Razor Wind", Normal, 80, 10),
		new BaseMove("Rock Slide", Rock, 75, 10),
		new BaseMove("Rock Throw", Rock, 50, 15),
		new BaseMove("Rolling Kick", Fighting, 60, 15),
		new BaseMove("Scratch", Normal, 40, 35),
		new BaseMove("Self Destruct", Normal, 200, 5),
		new BaseMove("Skull Bash", Normal, 130, 10),
		new BaseMove("Sky Attack", Flying, 140, 5),
		new BaseMove("Slam", Normal, 80, 20),
		new BaseMove("Slash", Normal, 70, 20),
		new BaseMove("Sludge", Poison, 65, 20),
		new BaseMove("Smog", Poison, 30, 20),
		new BaseMove("Solar Beam", Grass, 120, 10),
		new BaseMove("Spike Cannon", Normal, 20, 10),
		new BaseMove("Stomp", Normal, 65, 20),
		new BaseMove("Strength", Normal, 80, 15),
		//new BaseMove("Struggle", Normal, 50, 0),
		new BaseMove("Submission", Fighting, 80, 20),
		new BaseMove("Surf", Water, 90, 15),
		new BaseMove("Swift", Normal, 60, 20),
		new BaseMove("Tackle", Normal, 15, 35),
		new BaseMove("Take Down", Normal, 90, 20),
		new BaseMove("Thrash", Normal, 120, 10),
		new BaseMove("Thunder", Electric, 110, 10),
		new BaseMove("Thunder Punch", Electric, 75, 15),
		new BaseMove("Thunder Shock", Electric, 40, 30),
		new BaseMove("Thunder Bolt", Electric, 90, 15),
		new BaseMove("Tri Attack", Normal, 80, 10),
		new BaseMove("Twineedle", Bug, 25, 20),
		new BaseMove("Vice Grip", Normal, 55, 30),
		new BaseMove("Vine Whip", Grass, 45, 25),
		new BaseMove("Water Gun", Water, 40, 25),
		new BaseMove("Waterfall", Water, 80, 15),
		new BaseMove("Wing Attack", Flying, 60, 35),
		new BaseMove("Wrap", Normal, 15, 20)
	
	};
	
	/***************** Items *****************/
	//Item Name, Item Value
	public static final Item
	
		Potion = new Item("Potion", 20),
		SuperPotion = new Item("Super Potion", 50),
		HyperPotion = new Item("Hyper Potion", 200),
		MaxPotion = new Item("Max Potion", 999);
	
	/*************** Pokemon ****************/
	//PLACE HOLDER POKEMON WHEN THERE IS NOTHING
	public static final Pokemon NoPokemon = new Pokemon(basePokemons[0], 0);
	
	/***************** Move *****************/
	//PLACE HOLDER POKEMON MOVE WHEN THERE IS NONE
	public static final Move NoMove = new Move(baseMoves[0]);
	
}
