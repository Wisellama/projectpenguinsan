import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Controller {
    static Character person = new Character(400,300);;
    static Character person2 = new Character();;
    
	

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
		Character[] chars = {person, person2};
	    view.update(chars);
	    StateManager.getCurrentState().getControls().pollInput();
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
