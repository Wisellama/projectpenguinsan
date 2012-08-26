import java.util.ArrayList;
import java.util.HashMap;


public class GameplayState extends State{
    public Character person;
    public Character person2;
    private ArrayList characters;
    
	public GameplayState(){
		this.controls = new CharacterControls();
		this.characters = new ArrayList<Character>();
		this.person = new Character(400,300);
	    this.person2 = new Character();
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
