
public abstract class State {
    public ControlScheme controls;
	
    public abstract void enter();
    public abstract void update();
    public abstract void leave();
    
    public ControlScheme getControls(){
    	return this.controls;
    }
}
