package PokemonInfo;

public class Item {

	/*
	 * Created by William 11/17/17
	 */
	
	public final String name;
	public final int heal;
	
	/* Creates a reference for the item information
	 * @param name - name of the item
	 * @param value - healing amount
	 */
	public Item(String name, int heal) {
		
		this.name = name;
		this.heal = heal;
		
	}
	
	public String getName() { return name; }
	
	public int getHeal() { return heal; }
	
}
