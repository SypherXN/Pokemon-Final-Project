package Main;

import Combat.EnemyStorage;
import Player.PokemonStorage;

public class Points {
		
	/*
	 * created by William 12/13/17
	 */
	
	public static int yourPoints, enemyPoints, currentScore, overallScore;
	
	
	//Calculates the number of points you have based on the difference of levels between you and your enemy.
	public static int pointCalculator() {
		
		yourPoints = 0;
		enemyPoints = 0;
		currentScore = 0;
		
		for (int i = 0; i < 6; i++) {
			
			yourPoints += PokemonStorage.getPokemon(i).getLevel();
			
		}
		
		for (int i = 0; i < 6; i++){
			
			enemyPoints += EnemyStorage.getPokemon(i).getLevel();
			
		}
				
		if (yourPoints >= enemyPoints) {
			
			currentScore += 1000;	
			currentScore -= (yourPoints - enemyPoints);
			overallScore += currentScore;
			return 1;
			
		} else if (yourPoints < enemyPoints) {
			
			currentScore += Math.pow(2*(yourPoints - enemyPoints), 2);
			overallScore += currentScore;
			return 1;
			
		} else {
			
			return 0;
			
		}
		
	}
	
	//Prints out results based on winning or losing, and the number of points received.
	public static void pointSwitch() {
		
		switch(pointCalculator()) {
		
		case 0:
			System.out.println("Sorry, you did not win.\nYou gain 0 points.");
			break;
			
		case 1:
			System.out.println("You have won! You have gained " + currentScore + " and you have " + overallScore + " points overall.");
			break;
			
		default:
			break;
			
		}
		
	}
	
}
