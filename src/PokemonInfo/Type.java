package PokemonInfo;

public class Type {

	public final String type;
	
	/*Creates a reference for the types of the Pokemon
	 * @param type - name of the type
	 */
	public Type(String type) {
		
		this.type = type;
		
	}
	
	public boolean isEffective() {
		
		return false;
		
	}
	
	public boolean isResisted() {
		
		return false;
		
	}
	
}
