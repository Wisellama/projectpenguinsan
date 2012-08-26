public class NPC extends Character{
    String power;
    int xp;
    
    public NPC(String ability, int xp){
	    power = ability;
	    this.xp = xp;
    }
    
    public int getXP(){
	return xp;
    }
    
    public String getPower(){
	    return power;
    }
}