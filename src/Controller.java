import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Controller {


	

    public Controller(){
    	
    }
    

    public void start() throws InterruptedException {
		//initialize OpenGL stuff in View class
		View view = new View();
		view.start();
	
		//make a character to move around with the keyboard
	
		while (!Display.isCloseRequested()) {
		    //eventually give view.update() a list of all the things
		    //on the map to update them.
			State currentState = StateManager.getCurrentState();
		    view.update(currentState.getViewables());
		    currentState.getControls().pollInput();
		    Display.update();
		    Thread.sleep(25);
		}
	
		Display.destroy();
    }


    public static void main(String[] argv) throws InterruptedException {
	    Controller controller = new Controller();
	    controller.start();
    }
}
