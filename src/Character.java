public class Character {
    protected float xPosition, yPosition;
    protected boolean alive;
    
    public Character(float x, float y) {
	xPosition = x;
	yPosition = y;
	alive = true;
    }

    public Character() {
	xPosition = 100;
	yPosition = 100;
	alive = true;
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
    
    public int[] getPosition(){
	int[] result = [xPosition, yPosition];
	return result;
    }
}