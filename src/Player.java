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
    	color[0] = 1;
    	color[1] = 1;
    	color[2] = 1;
	xVelocity = 0;
	yVelocity = 0;
    }
    
    public int getSize() {
    	return size;
    }

    public int getSpeed() {
	return speed;
    }

    public int getArmor() {
	return armor;
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

    public void changeAngle(float change) {
	angle += change;
	if(angle > 360) {
	    angle = 0;
	}
	if(angle < 0) {
	    angle = 360;
	}
    }

    public void move() {
	super.move();
	if(xPosition > 800) {
	    xPosition = 0;
	}
	else if(xPosition < 0) {
	    xPosition = 800;
	}

	if(yPosition > 600) {
	    yPosition = 0;
	}
	else if(yPosition < 0) {
	    yPosition = 600;
	}
    }

    public void checkIfHit() {
	Character thing;
	for (int i = 0; i<charlist.size(); i++){
	    thing = charlist.get(i);
	    if (distance(thing.getXPos(), xPosition, thing.getYPos(), yPosition)<(size*10) && thing!=this){
		thing.kill();
		switch (thing.shape) {
		case TRIANGLE:
		    if(thing.color[0] == 1) {
			//red = bad, subtract
			speed--;
		    }
		    else if(thing.color[2] == 1) {
			//blue = good, add
			speed++;
		    }
		    break;
		    
		case CIRCLE:
		    if(thing.color[0] == 1) {
			//red = bad, subtract
			size--;
		    }
		    else if(thing.color[2] == 1) {
			//blue = good, add
			size++;
		    }
		    break;

		case SQUARE:
		    if(thing.color[0] == 1) {
			//red = bad, subtract
			armor--;
		    }
		    else if(thing.color[2] == 1) {
			//blue = good, add
			armor++;
		    }
		    break;
		    
		}
		}
	    }
	    }

	    public void changeVelocity(float change) {
		xVelocity += change*Math.cos(angle*Math.PI/180);
		yVelocity += change*Math.sin(angle*Math.PI/180);

		/*if(xVelocity > 20) {
		  xVelocity = 20;
		  }
		  else if(xVelocity < 0) {
		  xVelocity = 0;
		  }

		  if(yVelocity > 20) {
		  yVelocity = 20;
		  }
		  else if(yVelocity < 0) {
		  yVelocity = 0;
		  }*/
	    }
	}

