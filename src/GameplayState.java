import java.util.ArrayList;
import java.util.HashMap;


public class GameplayState extends State{
    public Character person;
    public Character person2;
    private ArrayList characters;
    
	public GameplayState(){
		this.controls = new CharacterControls();
		this.characters = new ArrayList<Character>();
		this.person = new Player(400,300);
		this.person2 = new Character();
		this.characters.add(this.person);
		this.characters.add(this.person2);
		this.viewables = new HashMap<View.ViewableType, Object>();
		this.viewables.put(View.ViewableType.Characters, this.characters);
	}
	
	public void enter() {

	}

	public void update() {

	}

	public void leave() {
	
	}

    public ArrayList getCharacterList() {
	return characters;
    }

    public void addCharacter(Character thing) {
	characters.add(thing);
    }

}
