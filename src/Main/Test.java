package Main;

import Combat.UI;
import PokemonInfo.*;

public class Test {

	/*
	 * Created by Matthew 11/15/17
	 */
	
	public static void main(String [] args) {
	
		Pokedex.initResistances();
		Pokedex.initWeaknesses();
		Pokedex.initNoEffect();
		
		Pokedex.Dragon.printInformation();
		
		Pokemon Ivysaur = new Pokemon(Pokedex.Ivysaur, 15);
		
		System.out.println();
		System.out.println(Ivysaur);
		
		Move Tackle = new Move(Pokedex.Tackle);
		Move Nothing = new Move(Pokedex.NoBaseMove);
		Ivysaur.changeMove(Tackle, 0);
		Ivysaur.changeMove(Nothing, 1);
		Ivysaur.changeMove(Tackle, 2);
		Ivysaur.changeMove(Nothing, 3);
		
		UI ui = new UI(Ivysaur);
		UI.combatMenu();
		
	}
	
}
