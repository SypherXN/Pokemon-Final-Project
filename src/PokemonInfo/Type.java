package PokemonInfo;

import java.util.ArrayList;

public class Type {

	/*
	 * Created by Matthew 11/16/17
	 */
	
	private final int type;
	private final String name;
	private ArrayList<Type> weaknessList, resistanceList, noEffectList;
	
	/**
	 * Creates a reference for the types of the Pokemon
	 * 
	 * @param name name of the type
	 * @param type index of the type
	 */
	public Type(String name, int type) {
		
		this.name = name;
		this.type = type;
		this.weaknessList = new ArrayList<> ();
		this.resistanceList = new ArrayList<> ();
		this.noEffectList = new ArrayList<> ();
		
	}
	
	//Zero-Arg Constructor Meant for NoType
	public Type() {
		
		this.name = "";
		this.type = 0;
		this.weaknessList = new ArrayList<> ();
		this.resistanceList = new ArrayList<> ();
		this.noEffectList = new ArrayList<> ();
		
	}
	
	//Adds Weaknesses of Types to weaknessList
	public void addWeaknesses(Type...types) {
		
		int i = 0;
		
		do {
			
			this.weaknessList.add(types[i]);
			i++;
			
		} while (i < types.length);
		
	}
	
	//Overloaded method for if there is none for this list
	public void addWeaknesses() { this.weaknessList.add(Pokedex.NoType); }
	
	//Adds Resistances of Types to resistanceList
	public void addResistances(Type...types) {
		
		for(int i = 0; i < types.length; i++) {
			
			this.resistanceList.add(types[i]);
			
		}
		
	}
	
	//Overloaded method for if there is none for this list
	public void addResistances() { this.resistanceList.add(Pokedex.NoType); }
	
	//Adds Nullification of Types to noEffectList
	public void addNoEffect(Type...types) {
		
		for(int i = 0; i < types.length; i++) {
			
			this.noEffectList.add(types[i]);
			
		}
		
	}
	
	//Overloaded method for if there is none for this list
	public void addNoEffect() { this.noEffectList.add(Pokedex.NoType); }
	
	//Checks if otherType is found in weaknessList
	public boolean isEffective(Type otherType) {
		
		if (weaknessList.contains(otherType)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	//Checks if otherType is found in resistanceList
	public boolean isResisted(Type otherType) {
		
		if (resistanceList.contains(otherType)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	//Checks if otherType is found in noEffectList
	public boolean noEffect(Type otherType) {
		
		if (noEffectList.contains(otherType)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public int getType() { return type; }
	
	public String getName() { return name; }
	
	//Prints out the information for the Type
	public void printInformation() {
		
		System.out.println("Type Name: " + name + "\nWeaknesses: " + weaknessList + "\nResistances: " + resistanceList + "\nNo Effect: " + noEffectList);
		
	}
	
	//Used to display the name of the type
	public String toString() { return name; }
	
}
