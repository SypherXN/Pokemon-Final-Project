package Main;

import PokemonInfo.*;

public class Test {

	public static void main(String [] args) {
	
		Pokedex.initResistances();
		Pokedex.initWeaknesses();
		Pokedex.initNoEffect();
		
		Pokedex.Dragon.printInformation();
		
		Pokemon Ivysaur = new Pokemon(Pokedex.Ivysaur, 15);
		
		System.out.println();
		System.out.println(Ivysaur);
		
	}
	
}
