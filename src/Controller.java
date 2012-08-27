import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Controller {


    private Random rand = new Random();

    public Controller(){
    }
    

    public void start() throws InterruptedException {
	//initialize OpenGL stuff in View class
	View view = new View();
	view.start();

	int timer = 0;
	
	//make a character to move around with the keyboard
	
	while (!Display.isCloseRequested()) {
	    //eventually give view.update() a list of all the things
	    //on the map to update them.
	    State currentState = StateManager.getCurrentState();

	    if(timer >= 1000) {
		//make a new thing every second with a random position
		//outside the view of the map, also with a random velocity
		//shooting it toward the map within a certain interval

		float x = 0,y = 0;

		switch(rand.nextInt(3)) {
		case 0:
		    x = -50;
		    y = rand.nextInt(500) + 50;
		    break;
		case 1:
		    x = 850;
		    y = rand.nextInt(500) + 50;
		    break;
		case 2:
		    x = rand.nextInt(700) + 50;
		    y = -50;
		    break;
		case 3:
		    x = rand.nextInt(700) + 50;
		    y = 650;
		    break;
		}
		    
		float angle = (float) Math.atan((300-y)/(400-x));

		float[] color = {1f,1f,1f};
		Character newThing = new Character(x,y,color,((GameplayState)currentState).getCharacterList());
		newThing.setVelocity(angle,5);//(float) (rand.nextFloat()+.1)*5);

		((GameplayState) currentState).addCharacter(newThing);

		timer = 0;
	    }
	    
		view.update(currentState.getViewables());
		currentState.getControls().pollInput();
		currentState.update(currentState.getViewables());
		((GameplayState)currentState).getPlayer().checkIfHit();
		Display.update();
		Thread.sleep(25);
		timer += 25;
	    }
	
	    Display.destroy();
	}

	public static void main(String[] argv) throws InterruptedException {
	    Controller controller = new Controller();
	    controller.start();
	}
    }
