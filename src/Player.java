import java.util.ArrayList;
import Power;
public class Player extends Character{
    ArrayList<Power> abilities = new ArrayList<Power>();
    public Player(){
    }
    
    public void addPower(Power power){
	abilities.add(power);
    }

    public Power fetchPower(String name){
	int length = abilities.size();
	for (int i = 0; i < length; i++){
	    if (abilities.get(i).name() == name){
		return abilities.get(i);
	    }
	}
	return null;
    }
}

