package PokemonInfo;

public class Item {

	/*
	 * Created by William 11/17/17
	 */
	
	private final String name;
	private final int heal;
	private int numberOwned = 0;
	
	/** Creates a reference for the item information
	 * 
	 * @param name - name of the item
	 * @param heal - healing amount
	 */
	public Item(String name, int heal) {
		
		this.name = name;
		this.heal = heal;
		
	}
	
	/** Increases the number of items owned by 1 */
	public void obtainItem() { numberOwned++; }
	
	/** Attempts the use of the item */
	public boolean attemptUseItem() {
		
		if (numberOwned > 0) {
			
			numberOwned--;
			return true;
			
		}
		
		return false;
		
	}
	
	//Accessor method to get instance variables
	public String getName() { return name; }
	public int getHeal() { return heal; }
	public int getNumberOwned() { return numberOwned; }
	
}
