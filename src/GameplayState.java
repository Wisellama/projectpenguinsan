import java.util.ArrayList;
import java.util.HashMap;


public class GameplayState extends State{
    public Character person;
    private ArrayList characters;
	public GameplayState(){
		this.controls = new CharacterControls();
		this.characters = new ArrayList<Character>();
		this.person = person = new Character(400,300);
		this.characters.add(this.person);
		this.viewables = new HashMap<View.ViewableType, Object>();
		this.viewables.put(View.ViewableType.Characters, this.characters);
	}
	
	public void enter() {

	}

	public void update() {

	}

	public void leave() {
	
	}

}
