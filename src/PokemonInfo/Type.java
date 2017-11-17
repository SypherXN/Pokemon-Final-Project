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
	
	public boolean isEffective(Type otherType) {
		
		if(this.type == 1) { //Bug
			
			switch(otherType.getType()) {
			
				case 5:
				case 6:
				case 14:
					return true;
			
			}
			
		} else if(this.type == 2) { //Dragon
			
			switch(otherType.getType()) {
			
				case 2:
				case 3:
					return true;
			
			}
			
		} else if(this.type == 3) { //Ice
			
			switch(otherType.getType()) {
			
				case 4:
				case 5:
				case 14:
					return true;
			
			}
			
		} else if(this.type == 4) { //Fighting
			
			switch(otherType.getType()) {
			
				case 6:
				case 13:
					return true;
			
			}
			
		} else if(this.type == 5) { //Fire
			
			switch(otherType.getType()) {
			
				case 9:
				case 14:
				case 15:
					return true;
			
			}
			
		} else if(this.type == 6) { //Flying
			
			switch(otherType.getType()) {
			
				case 3:
				case 10:
				case 14:
					return true;
			
			}
			
		} else if(this.type == 7) { //Grass
			
			switch(otherType.getType()) {
			
				case 1:
				case 3:
				case 5:
				case 6:
				case 12:
					return true;
			
			}
			
		} else if(this.type == 8) { //Ghost
			
			switch(otherType.getType()) {
			
				case 8:
					return true;
			
			}
			
		} else if(this.type == 9) { //Ground
			
			switch(otherType.getType()) {
			
				case 3:
				case 7:
				case 15:
					return true;
			
			}
			
		} else if(this.type == 10) { //Electric
			
			switch(otherType.getType()) {
			
				case 9:
					return true;
			
			}
			
		} else if(this.type == 11) { //Normal
			
			switch(otherType.getType()) {
			
				case 4:
					return true;
			
			}
			
		} else if(this.type == 12) { //Poison
			
			switch(otherType.getType()) {
			
				case 9:
				case 13:
					return true;
			
			}
			
		} else if(this.type == 13) { //Psychic
			
			switch(otherType.getType()) {
			
				case 1:
				case 8:
					return true;
			
			}
			
		} else if(this.type == 14) { //Rock
			
			switch(otherType.getType()) {
			
				case 4:
				case 7:
				case 9:
				case 15:
					return true;
			
			}
			
		} else if(this.type == 15) { //Water
			
			switch(otherType.getType()) {
			
				case 7:
				case 10:
					return true;
			
			}
			
		}
		
		return false;
		
	}
	
	public boolean isResisted(Type otherType) {
		
		return false;
		
	}
	
	public boolean noEffect(Type otherType) {
		
		return false;
		
	}
	
}
