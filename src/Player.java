import java.util.ArrayList;
import java.util.Hashtable;

public class Player extends Character{
    Hashtable<String,Power> abilities = new Hashtable<String,Power>();

    public Player(float x, float y){
    	super(x,y);

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

