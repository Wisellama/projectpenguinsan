import java.util.ArrayList;

public class Character {
    public enum Directions {NORTH,SOUTH,EAST,WEST,NORTHWEST,NORTHEAST,SOUTHWEST,SOUTHEAST};

    protected float xPosition, yPosition;
    protected boolean alive;
    protected float[] color;//temporary until we have graphics, just color of square
    protected float xVelocity, yVelocity;
    
    private static float[] defaultColor = {1,1,1};
    ArrayList<Character> charlist;
    ArrayList<Character> defaultlist = new ArrayList<Character>();
    
    public Character(float x, float y, float[] c, ArrayList<Character> chars) {
    	defaultlist.add(this);
		xPosition = x;
		yPosition = y;
		alive = true;
		color = c;
		xVelocity = 5;
		yVelocity = 5;
		charlist = chars;
    }

    public Character(float x, float y) {
	    this(x,y, defaultColor, null);
	    charlist = defaultlist;
    }

    public Character() {
	    this(100,100);
    }

    public boolean isAlive() {
	    return alive;
    }

    public void kill() {
	    alive = false;
    }

    public void move(float x, float y) {
		xPosition += x;
		yPosition += y;
    }
    
    public float[] getPosition(){
	    float[] result = {xPosition, yPosition};
	    return result;
    }
    
    public void move(Directions d) {
		switch(d) {
		case NORTH:
		    yPosition += yVelocity;
		    break;
		case WEST:
		    xPosition -= xVelocity;
		    break;
		case EAST:
		    xPosition += xVelocity;
		    break;
		case SOUTH:
		    yPosition -= yVelocity;
		    break;

		    //make velocity the same
		    //currently sqrt(x^2 + y^2) or sqrt(2)
		    //fix by dividing by sqrt(2)/2
		case NORTHEAST:
		    xPosition += xVelocity/(Math.sqrt(2));
		    yPosition += yVelocity/(Math.sqrt(2));
		    break;
		case NORTHWEST:
		    xPosition -= xVelocity/(Math.sqrt(2));
		    yPosition += yVelocity/(Math.sqrt(2));
		    break;
		case SOUTHEAST:
		    xPosition += xVelocity/(Math.sqrt(2));
		    yPosition -= yVelocity/(Math.sqrt(2));
		    break;
		case SOUTHWEST:
		    xPosition -= xVelocity/(Math.sqrt(2));
		    yPosition -= yVelocity/(Math.sqrt(2));
		    break;
		}
		System.out.println(Math.sqrt(xVelocity*xVelocity + yVelocity*yVelocity));
    }

    public float getXPos() {
    	return xPosition;
    }
    public float getYPos() {
    	return yPosition;
    }
    public float getXVel() {
    	return xVelocity;
    }
    public float getYVel() {
    	return yVelocity;
    }
    public float[] getColor() {
    	return color;
    }
    public void updateList(ArrayList<Character> clist){
    	charlist = clist;
    }
    public void attack(){
    	
    	for (int i = 0; i<charlist.size(); i++){
    		if (distance(charlist.get(i).getXPos(), xPosition, charlist.get(i).getYPos(), yPosition)<200 && charlist.get(i)!=this){
    			charlist.get(i).kill();
    		}
    	}
    }
    private double distance(float x1, float y1, float x2, float y2){
    	return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }
}