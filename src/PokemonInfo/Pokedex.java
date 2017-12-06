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
		Butterfree = 	new BasePokemon("Butterfree", Bug, Flying, 60, 45, 50, 70, 12, 3, 2, 2, 2, 101);/*,
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
		Dugtrio = 		new BasePokemon("Dugtrio", Ground, NoType, 35, 80, 50, 120, 51);*/
	
	
	/************** Base Moves **************/
	//Name, Move Type, Move Attack, Max PP
	public static final BaseMove
		
		NoBaseMove = new BaseMove("", NoType, 0, 0),
		absorb = new BaseMove("Absorb", Grass, 20, 25),
		acid = new BaseMove("Acid", Poison, 40, 30),
		auroraBeam = new BaseMove("Aurora Beam", Ice, 65, 20),
		barrage = new BaseMove("Barrage", Normal, 15, 20),
		bind = new BaseMove("Bind", Normal, 15, 20),
		blizzard = new BaseMove("Blizzard", Ice, 110, 5),
		bodySlam = new BaseMove("Body Slam", Normal, 85, 15),
		boneClub = new BaseMove("Bone Club", Ground, 65, 20),
		bonemerang = new BaseMove("Bonemerange", Ground, 50, 10),
		bubble = new BaseMove("Bubble", Water, 40, 30),
		bubbleBeam = new BaseMove("Bubble Beam", Water, 65, 20),
		clamp = new BaseMove("Clamp", Water, 35, 10),
		cometPunch = new BaseMove("Comet Punch", Normal, 18, 15),
		confusion = new BaseMove("Confusion", Psychic, 50, 25),
		constrict = new BaseMove("Constrict", Normal, 10, 35),
		crabhammer = new BaseMove("Crabhammer", Water, 100, 10),
		cut = new BaseMove("Cut", Normal, 50, 30),
		dig = new BaseMove("Dig", Ground, 80, 10),
		dizzyPunch = new BaseMove("Dizzy Punch", Normal, 70, 10),
		doubleKick = new BaseMove("Double Kick", Fighting, 30, 30),
		doubleSlap = new BaseMove("Double Slap", Normal, 15, 10),
		doubleEdge = new BaseMove("Double Edge", Normal, 120, 15),
		dragonRage = new BaseMove("Dragon Rage", Dragon, 40, 10),
		dreamEater = new BaseMove("Dream Eater", Psychic, 100, 15),
		drillPeck = new BaseMove("Drill Peck", Flying, 80, 20),
		earthquake = new BaseMove("Earthquake", Ground, 100, 10),
		eggBomb = new BaseMove("Egg Bomb", Normal, 100, 10),
		ember = new BaseMove("Ember", Fire, 40, 25),
		explosion = new BaseMove("Explosion", Normal, 250, 5),
		fireBlast = new BaseMove("Fire Blast", Fire, 110, 5),
		firePunch = new BaseMove("Fire Punch", Fire, 75, 15),
		fireSpin = new BaseMove("Fire Spin", Fire, 35, 15),
		flamethrower = new BaseMove("Flamethrower", Fire, 90, 15),
		fly = new BaseMove("Fly", Flying, 90, 15),
		furyAttack = new BaseMove("Fury Attack", Normal, 15, 20),
		furySwipes = new BaseMove("Fury Swipes", Normal, 18, 15),
		gust = new BaseMove("Gust", Flying, 40, 35),
		GG = new BaseMove("GG", Dragon, 999999999, 999999999),
		headbutt = new BaseMove("Headbutt", Normal, 70, 15),
		highJumpKick = new BaseMove("High Jump Kick", Fighting, 130, 10), 
		hornAttack = new BaseMove("Horn Attack", Normal, 65, 25),
		hydroPump = new BaseMove("Hydro Pump", Water, 110, 5),
		hyperBeam = new BaseMove("Hyper Beam", Normal, 150, 5),
		hyperFang = new BaseMove("Hyper Fang", Normal, 80, 15),
		iceBeam = new BaseMove("Ice Beam", Ice, 90, 10),
		icePunch = new BaseMove("Ice Punch", Ice, 75, 15),
		jumpKick = new BaseMove("Jump Kick", Fighting, 100, 10),
		karateChop = new BaseMove("Karate Chop", Fighting, 50, 25),
		leechLife = new BaseMove("Leech Life", Bug, 80, 10),
		lick = new BaseMove("Lick", Ghost, 30, 30),
		megaDrain = new BaseMove("Mega Drain", Grass, 40, 15),
		megaKick = new BaseMove("Mega Kick", Normal, 120, 5),
		megaPunch = new BaseMove("Mega Punch", Normal, 80, 20),
		payDay = new BaseMove("Pay Day", Normal, 40, 20),
		peck = new BaseMove("Peck", Flying, 35, 35),
		petalDance = new BaseMove("Petal Dance", Grass, 120, 10),
		pinMissile = new BaseMove("Pin Missile", Bug, 25, 20),
		poisonSting = new BaseMove("Poison Sting", Poison, 15, 35),
		pound = new BaseMove("Pound", Normal, 40, 35),
		psybeam = new BaseMove("Psybeam", Psychic, 65, 20),
		psychic = new BaseMove("Psychic", Psychic, 90, 10),
		quickAttack = new BaseMove("Quick Attack", Normal, 40, 30),
		rage = new BaseMove("Rage", Normal, 20, 20),
		razorLeaf = new BaseMove("Razor Leaf", Grass, 55, 25),
		razorWind = new BaseMove("Razor Wind", Normal, 80, 10),
		rockSlide = new BaseMove("Rock Slide", Rock, 75, 10),
		rockThrow = new BaseMove("Rock Throw", Rock, 50, 15),
		rollingKick = new BaseMove("Rolling Kick", Fighting, 60, 15),
		scratch = new BaseMove("Scratch", Normal, 40, 35),
		selfDestruct = new BaseMove("Self Destruct", Normal, 200, 5),
		skullBash = new BaseMove("Skull Bash", Normal, 130, 10),
		skyAttack = new BaseMove("Sky Attack", Flying, 140, 5),
		slam = new BaseMove("Slam", Normal, 80, 20),
		slash = new BaseMove("Slash", Normal, 70, 20),
		sludge = new BaseMove("Sludge", Poison, 65, 20),
		smog = new BaseMove("Smog", Poison, 30, 20),
		solarBeam = new BaseMove("Solar Beam", Grass, 120, 10),
		spikeCannon = new BaseMove("Spike Cannon", Normal, 20, 10),
		stomp = new BaseMove("Stomp", Normal, 65, 20),
		strength = new BaseMove("Strength", Normal, 80, 15),
		struggle = new BaseMove("Struggle", Normal, 50, 0),
		submission = new BaseMove("Submission", Fighting, 80, 20),
		surf = new BaseMove("Surf", Water, 90, 15),
		swift = new BaseMove("Swift", Normal, 60, 20),
		tackle = new BaseMove("Tackle", Normal, 15, 5),
		takeDown = new BaseMove("Take Down", Normal, 90, 20),
		thrash = new BaseMove("Thrash", Normal, 120, 10),
		thunder = new BaseMove("Thunder", Electric, 110, 10),
		thunderPunch = new BaseMove("Thunder Punch", Electric, 75, 15),
		thunderShock = new BaseMove("Thunder Shock", Electric, 40, 30),
		thunderBolt = new BaseMove("Thunder Bolt", Electric, 90, 15),
		triAttack = new BaseMove("Tri Attack", Normal, 80, 10),
		twineedle = new BaseMove("Twineedle", Bug, 25, 20),
		viceGrip = new BaseMove("Vice Grip", Normal, 55, 30),
		vineWhip = new BaseMove("Vine Whip", Grass, 45, 25),
		waterGun = new BaseMove("Water Gun", Water, 40, 25),
		waterfall = new BaseMove("Waterfall", Water, 80, 15),
		wingAttack = new BaseMove("Wing Attack", Flying, 60, 35),
		wrap = new BaseMove("Wrap", Normal, 15, 20);
	
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
	
	//temp
	
	
	
}
