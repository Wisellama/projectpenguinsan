import java.util.ArrayList;
import java.util.Hashtable;

import Power;
public class Player extends Character{
    Hashtable<String,Power> abilities = new Hashtable<String,Power>();
    public Player(){
    }
    
    public void addPower(String name, Power power){
	    abilities.put(name,power);
    }

    public Power fetchPower(String name){
	    if(abilities.containsKey(name)){
	    	return
	    	
	    }
	    return null;
    }
}

