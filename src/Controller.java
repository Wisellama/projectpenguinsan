import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Controller {

    static Character person = new Character(400,300);;

	
    public Controller(){
    	
    }
    
    
    public void start() {
	//initialize OpenGL stuff in View class
	View view = new View();
	view.start();

	//make a character to move around with the keyboard

	while (!Display.isCloseRequested()) {
	    //go through list of characters and draw them
	    //right now i'm cheating cause there's only one
	    view.draw(person);
	    StateManager.getCurrentState().getControls().pollInput();
	    Display.update();
	}

	Display.destroy();
    }


    public static void main(String[] argv) {
	Controller controller = new Controller();
	controller.start();
    }
}
