package PokemonInfo;

public class Type {

	/*
	 * Created by Matthew 11/16/17
	 */
	
	public final int type;
	
	/*Creates a reference for the types of the Pokemon
	 * @param type - name of the type
	 */
	public Type(int type) {
		
		this.type = type;
		
	}
	
	public int getType() {
		
		return type;
		
	}
	
	public void addWeaknesses(Type...types) {
		
		Type[] weaknessList = new Type[types.length];
		
		for(int i = 0; i < types.length; i++) {
			
			weaknessList[i] = types[i];
			
		}
		
	}
	
	public void addResistances(Type...types) {
		
		Type[] resistanceList = new Type[types.length];
		
		for(int i = 0; i < types.length; i++) {
			
			resistanceList[i] = types[i];
			
		}
		
	}
	
	public boolean isEffective(Type otherType) {
		
		return false;
		
	}
	
	public boolean isResisted(Type otherType) {
		
		return false;
		
	}
	
	public boolean noEffect(Type otherType) {
		
		return false;
		
	}
	
}
