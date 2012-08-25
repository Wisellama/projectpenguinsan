import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;


public class CharacterControls extends ControlScheme{

	private Character character;
	private Set<Integer> pressedKeys;
	private StateManager state;
	
	public CharacterControls(Character c){
		this.character = c;
		this.pressedKeys = new HashSet<Integer>();
	}
	
	public void keyPressed(KeyEvent event) {
		int keyCode = event.getKeyCode();
		pressedKeys.add(keyCode);
		
		// Pause button
		if(pressedKeys.contains(KeyEvent.VK_ESCAPE)){
			pressedKeys.clear();
			state.Pause();
		}
		
		// Movement Directions
		if(pressedKeys.contains(KeyEvent.VK_DOWN)){
		    if(pressedKeys.contains(KeyEvent.VK_LEFT)){
		        this.character.move(Character.Directions.SOUTHWEST);
		    }
		    else if(pressedKeys.contains(KeyEvent.VK_RIGHT)){
		        this.character.move(Character.Directions.SOUTHEAST);
		    }
			else{
			    this.character.move(Character.Directions.SOUTH);
		    }
		}
		if(pressedKeys.contains(KeyEvent.VK_UP)){
		    if(pressedKeys.contains(KeyEvent.VK_LEFT)){
		        this.character.move(Character.Directions.NORTHWEST);
		    }
		    else if(pressedKeys.contains(KeyEvent.VK_RIGHT)){
		        this.character.move(Character.Directions.NORTHEAST);
		    }
			else{
			    this.character.move(Character.Directions.NORTH);
		    }
		}
		else if(pressedKeys.contains(KeyEvent.VK_LEFT)){
			this.character.move(Character.Directions.WEST);
		}
		else if(pressedKeys.contains(KeyEvent.VK_RIGHT)){
			this.character.move(Character.Directions.EAST);
		}
		
		// Action buttons
		
		if(pressedKeys.contains(KeyEvent.VK_SPACE)){
			this.character.attack();
		}
		
		
		


		
		
	}

	public void keyReleased(KeyEvent event) {
		int keyCode = event.getKeyCode();
		pressedKeys.remove(keyCode);
	}

}
