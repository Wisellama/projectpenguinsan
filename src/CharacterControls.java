

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

		// Action buttons (and actions that are not continuous, i.e when you press the button, holding it down does nothing)
		while(Keyboard.next()){
			// Pause button
			if(Keyboard.getEventKeyState() && Keyboard.getEventKey() == PAUSE_KEY){
				StateManager.Pause();
				return;
			}
			
			if(Keyboard.getEventKeyState() && Keyboard.getEventKey() == ATTACK_KEY){
				((GameplayState)StateManager.getCurrentState()).person.attack();
			}

		}
		
		// Movement Directions
		if(Keyboard.isKeyDown(DOWN_KEY)){
		    if(Keyboard.isKeyDown(LEFT_KEY)){
		        ((GameplayState)StateManager.getCurrentState()).person.move(Character.Directions.SOUTHWEST);
		    }
		    else if(Keyboard.isKeyDown(RIGHT_KEY)){
		        ((GameplayState)StateManager.getCurrentState()).person.move(Character.Directions.SOUTHEAST);
		    }
			else{
			    ((GameplayState)StateManager.getCurrentState()).person.move(Character.Directions.SOUTH);
		    }
		}
		else if(Keyboard.isKeyDown(UP_KEY)){
		    if(Keyboard.isKeyDown(LEFT_KEY)){
		        ((GameplayState)StateManager.getCurrentState()).person.move(Character.Directions.NORTHWEST);
		    }
		    else if(Keyboard.isKeyDown(RIGHT_KEY)){
		        ((GameplayState)StateManager.getCurrentState()).person.move(Character.Directions.NORTHEAST);
		    }
			else{
			    ((GameplayState)StateManager.getCurrentState()).person.move(Character.Directions.NORTH);
		    }
		}
		else if(Keyboard.isKeyDown(LEFT_KEY)){
			((GameplayState)StateManager.getCurrentState()).person.move(Character.Directions.WEST);
		}
		else if(Keyboard.isKeyDown(RIGHT_KEY)){
			((GameplayState)StateManager.getCurrentState()).person.move(Character.Directions.EAST);
		}
		

		
		


		
		
	}


}
