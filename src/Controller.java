import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Controller {

    Character person;
	
    public void start() {
	//initialize OpenGL stuff in View class
	View view = new View();
	view.start();

	//make a character to move around with the keyboard
	person = new Character(400,300);

	while (!Display.isCloseRequested()) {
	    //go through list of characters and draw them
	    //right now i'm cheating cause there's only one
	    view.draw(person);
	    pollInput();
	    Display.update();
	}

	Display.destroy();
    }

    public void pollInput() {
		
	if (Mouse.isButtonDown(0)) {
	    int x = Mouse.getX();
	    int y = Mouse.getY();
			
	    System.out.println("MOUSE DOWN @ X: " + x + " Y: " + y);
	}
		
	if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
	    System.out.println("SPACE KEY IS DOWN");
	}
		
	while (Keyboard.next()) {
	    if (Keyboard.getEventKeyState()) {
		if (Keyboard.getEventKey() == Keyboard.KEY_A) {
		    System.out.println("A Key Pressed");
		    person.move(Character.Directions.WEST);
		}
		if (Keyboard.getEventKey() == Keyboard.KEY_S) {
		    System.out.println("S Key Pressed");
		    person.move(Character.Directions.SOUTH);
		}
		if (Keyboard.getEventKey() == Keyboard.KEY_D) {
		    System.out.println("D Key Pressed");
		    person.move(Character.Directions.EAST);
		}
		if (Keyboard.getEventKey() == Keyboard.KEY_W) {
		    System.out.println("W Key Pressed");
		    person.move(Character.Directions.NORTH);
		}
		System.out.println(person.getXPos() + " " + person.getYPos());
	    }
	}
    }

    public static void main(String[] argv) {
	Controller controller = new Controller();
	controller.start();
    }
}
