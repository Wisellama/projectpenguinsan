import java.util.ArrayList;
import java.util.HashMap;


public class GameplayState extends State{
    public Player person;
    public Character person2;
    private ArrayList characters;
    
	public GameplayState(){
		this.controls = new CharacterControls();
		this.characters = new ArrayList<Character>();
		this.person = new Player(400,300);
		//this.person2 = new Character();
		this.characters.add(this.person);
		//this.characters.add(this.person2);
		this.viewables = new HashMap<View.ViewableType, Object>();
		this.viewables.put(View.ViewableType.Characters, this.characters);
	}
	
	public void enter() {

	}

	public void update(HashMap viewables) {
	    for (Object viewable : viewables.keySet()){
		ArrayList al = ((ArrayList)viewables.get((View.ViewableType) viewable));
		for(int i = 0; i < al.size(); i++) {
		    ((Character)al.get(i)).move();
		}
	    }
	}

	public void leave() {
	
	}

    public ArrayList getCharacterList() {
	return characters;
    }

    public void addCharacter(Character thing) {
	characters.add(thing);
    }
    
    public Player getPlayer() {
    		return person;
    }

}
