package Main;

import Combat.*;
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
		
		Pokemon Bulbasaur = new Pokemon(Pokedex.Bulbasaur, 30);
		Pokemon Ivysaur = new Pokemon(Pokedex.Ivysaur, 42);
		Pokemon Venasaur = new Pokemon(Pokedex.Venasaur, 100);
		Pokemon Venasaur2 = new Pokemon(Pokedex.Venasaur, 100);
		
		System.out.println(Bulbasaur);
		System.out.println(Ivysaur);
		System.out.println(Venasaur);
		
		PokemonStorage.changePokemon(Bulbasaur,0);
		PokemonStorage.changePokemon(Ivysaur, 1);
		PokemonStorage.changePokemon(Venasaur, 2);
		
		Move Tackle = new Move(Pokedex.Tackle);
		Move RazorLeaf = new Move(Pokedex.RazorLeaf);
		
		Bulbasaur.changeMove(Tackle, 0);
		Bulbasaur.changeMove(RazorLeaf, 1);
		
		Ivysaur.changeMove(Tackle, 1);
		Ivysaur.changeMove(RazorLeaf, 2);
		
		Venasaur.changeMove(Tackle, 2);
		Venasaur.changeMove(RazorLeaf, 3);
		
		Venasaur.changeMove(Tackle, 0);
		Venasaur.changeMove(RazorLeaf, 1);
		Venasaur.changeMove(Tackle, 2);
		Venasaur.changeMove(RazorLeaf, 3);
		
		Battle.setEnemy(Venasaur2);
		
		while (Battle.enemy.hp > 0) {
			
			UI.combatMenu();
			System.out.println(Battle.enemy.hp);
			System.out.println(UI.pokemon.hp);
		
		}
	}
	
}
