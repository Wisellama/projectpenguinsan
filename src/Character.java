public class Character {
    public enum Directions {NORTH,SOUTH,EAST,WEST,NORTHWEST,NORTHEAST,SOUTHWEST,SOUTHEAST};

    protected float xPosition, yPosition;
    protected boolean alive;
    protected float[] color;//temporary until we have graphics, just color of square
    protected float xVelocity, yVelocity;
    
    private static float[] defaultColor = {1,1,1};
    Character[] charlist;
    Character[] defaultlist = {this};
    public Character(float x, float y, float[] c, Character[] chars) {
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
		case NORTHEAST:
		    xPosition += xVelocity;
		    yPosition += yVelocity;
		    break;
		case NORTHWEST:
		    xPosition -= xVelocity;
		    yPosition += yVelocity;
		    break;
		case SOUTHEAST:
		    xPosition += xVelocity;
		    yPosition -= yVelocity;
		    break;
		case SOUTHWEST:
		    xPosition -= xVelocity;
		    yPosition -= yVelocity;
		    break;
		}
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
    public void updateList(Character[] clist){
    	charlist = clist;
    }
    public void attack(){
    	for (int i = 0; i<charlist.length; i++){
    		if (distance(charlist[i].getXPos(), xPosition, charlist[i].getYPos(), yPosition)<200 && charlist[i]!=this){
    			charlist[i].kill();
    		}
    	}
    }
    private double distance(float x1, float y1, float x2, float y2){
    	return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }
}