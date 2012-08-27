import java.util.ArrayList;
import java.util.Hashtable;

public class Player extends Character{
    Hashtable<String,Power> abilities = new Hashtable<String,Power>();
    
    private int speed, armor;//size is in Character

    public Player(float x, float y){
    	super(x,y);
    	
    	//attributes:
    	//size makes you bigger and more easily hit by enemies
    	//speed makes you faster and more easy to dodge/accidently run into enemies.
    	//armor reduces the damage you take.
    	size = 5;
    	speed = 5;
    	armor = 0;
    	shape = Character.Shapes.TRIANGLE;
    }
    
    public int getSize() {
    	return size;
    }
    
    public void addPower(String name, Power power){
	    abilities.put(name,power);
    }

    public Power fetchPower(String name){
	    if(abilities.containsKey(name)){
	    	return abilities.get(name);
	    }
	    return null;
    }
}

