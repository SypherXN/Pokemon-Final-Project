package PokemonInfo;

import java.util.ArrayList;

public class Type {

	/*
	 * Created by Matthew 11/16/17
	 */
	
	public final int type;
	public final String name;
	public ArrayList<Type> weaknessList, resistanceList, noEffectList;
	
	/*Creates a reference for the types of the Pokemon
	 * @param name - name of the type
	 * @param type - index of the type
	 */
	public Type(String name, int type) {
		
		this.name = name;
		this.type = type;
		this.weaknessList = new ArrayList<> ();
		this.resistanceList = new ArrayList<> ();
		this.noEffectList = new ArrayList<> ();
		
	}
	
	//Adds Weaknesses of Types to weaknessList
	public void addWeaknesses(Type...types) {
		
		for(int i = 0; i < types.length; i++) {
			
			this.weaknessList.add(types[i]);
			
		}
		
	}
	
	//Adds Resistances of Types to resistanceList
	public void addResistances(Type...types) {
		
		for(int i = 0; i < types.length; i++) {
			
			this.resistanceList.add(types[i]);
			
		}
		
	}
	
	//Adds Nullification of Types to noEffectList
	public void addNoEffect(Type...types) {
		
		for(int i = 0; i < types.length; i++) {
			
			this.noEffectList.add(types[i]);
			
		}
		
	}
	
	//Checks if otherType is found in weaknessList
	public boolean isEffective(Type otherType) {
		
		if(weaknessList.contains(otherType)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	//Checks if otherType is found in resistanceList
	public boolean isResisted(Type otherType) {
		
		if(resistanceList.contains(otherType)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	//Checks if otherType is found in noEffectList
	public boolean noEffect(Type otherType) {
		
		if(noEffectList.contains(otherType)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public int getType() { return type; }
	
	public String getName() { return name; }
	
	public void printInformation() {
		
		System.out.println("Type Name: " + name + "\nWeaknesses: " + weaknessList + "\nResistances: " + resistanceList + "\nNo Effect: " + noEffectList);
		
	}
	
	public String toString() { return name; }
	
}
