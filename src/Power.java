public class Power{
    int level;
    String name;
    public Power(String name){
	this.name=name;
	level = 1;
    }
    
    public void levelUp(int amount){
	level+=amount;
    }
    public String name(){
	return name;
    }
    public int level(){
	return level;
    }
}