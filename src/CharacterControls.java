

import org.lwjgl.input.Keyboard;


public class CharacterControls extends ControlScheme{

	
	public CharacterControls(){
	}
	
	public static int DOWN_KEY = Keyboard.KEY_DOWN;
	public static int UP_KEY = Keyboard.KEY_UP;
	public static int LEFT_KEY = Keyboard.KEY_LEFT;
	public static int RIGHT_KEY = Keyboard.KEY_RIGHT;
	public static int ATTACK_KEY = Keyboard.KEY_SPACE;
	public static int PAUSE_KEY = Keyboard.KEY_ESCAPE;
	
	public void pollInput() {

		
		// Pause button
		if(Keyboard.isKeyDown(PAUSE_KEY)){
			
			StateManager.Pause();
			return;
		}
		
		// Movement Directions
		if(Keyboard.isKeyDown(DOWN_KEY)){
		    if(Keyboard.isKeyDown(LEFT_KEY)){
		        Controller.person.move(Character.Directions.SOUTHWEST);
		    }
		    else if(Keyboard.isKeyDown(RIGHT_KEY)){
		        Controller.person.move(Character.Directions.SOUTHEAST);
		    }
			else{
			    Controller.person.move(Character.Directions.SOUTH);
		    }
		}
		else if(Keyboard.isKeyDown(UP_KEY)){
		    if(Keyboard.isKeyDown(LEFT_KEY)){
		        Controller.person.move(Character.Directions.NORTHWEST);
		    }
		    else if(Keyboard.isKeyDown(RIGHT_KEY)){
		        Controller.person.move(Character.Directions.NORTHEAST);
		    }
			else{
			    Controller.person.move(Character.Directions.NORTH);
		    }
		}
		else if(Keyboard.isKeyDown(LEFT_KEY)){
			Controller.person.move(Character.Directions.WEST);
		}
		else if(Keyboard.isKeyDown(RIGHT_KEY)){
			Controller.person.move(Character.Directions.EAST);
		}
		
		// Action buttons
		
		if(Keyboard.isKeyDown(ATTACK_KEY)){
			Controller.person.attack();
		}
		
		
		


		
		
	}


}
