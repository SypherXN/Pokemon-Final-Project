package Main;

import PokemonInfo.*;

public class Test {

	public static void main(String [] args) {
	
		Pokedex.initResistances();
		Pokedex.initWeaknesses();
		Pokedex.initNoEffect();
		
		Pokedex.Dragon.printInformation();
		
	}
	
}
