import java.util.HashMap;


public abstract class State {
    protected ControlScheme controls;
	protected HashMap<View.ViewableType, Object> viewables;
	
    public abstract void enter();
    public abstract void update(HashMap hm);
    public abstract void leave();
    
    public ControlScheme getControls(){
    	return this.controls;
    }
    
    public HashMap getViewables(){
    	return this.viewables;
    }
}
