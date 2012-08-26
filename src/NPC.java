public class NPC extends Character{
    String power;
    int xp;
    
    public NPC(String ability, int xp){
	    power = ability;
	    this.xp = xp;
    }
    
    public NPC(String ability, int xp, float x, float y){
		power = ability;
		this.xp = xp;
		super.xPosition = x;
		super.yPosition = y;
    }
    
    public int getXP(){
	    return xp;
    }
    
    public String getPower(){
	    return power;
    }


}