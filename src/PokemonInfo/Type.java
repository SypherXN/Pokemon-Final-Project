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
		
	}
	
	public int getType() {
		
		return type;
		
	}
	
	public void addWeaknesses(Type...types) {
		
		for(int i = 0; i < types.length; i++) {
			
			this.weaknessList.add(types[i]);
			
		}
		
	}
	
	public void addResistances(Type...types) {
		
		for(int i = 0; i < types.length; i++) {
			
			this.resistanceList.add(types[i]);
			
		}
		
	}
	
	public void addNoEffect(Type...types) {
		
		for(int i = 0; i < types.length; i++) {
			
			this.noEffectList.add(types[i]);
			
		}
		
	}
	
	public boolean isEffective(Type otherType) {
		
		if(weaknessList.contains(otherType)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public boolean isResisted(Type otherType) {
		
		if(resistanceList.contains(otherType)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public boolean noEffect(Type otherType) {
		
		if(noEffectList.contains(otherType)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
}
