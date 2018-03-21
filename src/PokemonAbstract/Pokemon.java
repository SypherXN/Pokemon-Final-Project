package PokemonAbstract;

import java.util.Scanner;

import Combat.UI;
import PokemonInfo.*;

public abstract class Pokemon {

	private Scanner input = new Scanner(System.in);
	
	private Type type;
	private String name;
	private int maxHP, hp, attack, defense, speed, level, exp;
	private Move[] moves = {Pokedex.NoMove, Pokedex.NoMove, Pokedex.NoMove, Pokedex.NoMove};
	private Move[] moveList = new Move[100];
	
	public Pokemon(Type type, String name, int maxHP, int hp, int attack, int defense, int speed, Move[] moves, int level, int exp) {
		
		this.type = type;
		this.name = name;
		this.moves = moves;
		this.level = level;
		this.exp = exp;
		this.maxHP = maxHP;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		
	}
	
	public void levelUp() {
		
		level++;
		exp = 0;
		
		if (moveList[level - 1] != null) {
			
			System.out.println("Would you like to learn " + moveList[level - 1].base.getName());
			int response = input.nextInt();
			
		}
		
	}
	
	public void setMoveList(Move[] moveList) { this.moveList = moveList; }
	public void changeMove(Move move, int index) { moves[index] = move; }
	
	public Type getType() { return type; }
	public String getName() { return name; }
	public Move[] getMoves() { return moves; }
	public Move getMove(int index) { return moves[index]; }
	public int getMaxHP() { return maxHP; }
	public int getHP() { return hp; }
	public int getAttack() { return attack; }
	public int getDefense() { return defense; }
	public int getSpeed() { return speed; }
	public int getLevel() { return level; }
	
}
