package Main;

import Combat.UI;
import Player.PokemonStorage;
import PokemonInfo.*;

public class Test {

	/*
	 * Created by Matthew 11/15/17
	 */
	
	public static void main(String [] args) {
	
		Pokedex.initResistances();
		Pokedex.initWeaknesses();
		Pokedex.initNoEffect();
		
		Pokemon Ivysaur = new Pokemon(Pokedex.Ivysaur, 15);
		
		PokemonStorage storage = new PokemonStorage();
		
		storage.changePokemon(Ivysaur, 0);
		
		Move Tackle = new Move(Pokedex.Tackle);
		Move RazorLeaf = new Move(Pokedex.RazorLeaf);
		Ivysaur.changeMove(Tackle, 0);
		Ivysaur.changeMove(Pokedex.NoMove, 1);
		Ivysaur.changeMove(Tackle, 2);
		Ivysaur.changeMove(RazorLeaf, 3);
		UI.combatMenu();
		
	}
	
}
