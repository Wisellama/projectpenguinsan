public class Cell {
    public final int pixel_length = 6;
    public final int pixel_width = 6;
    Object container = null;
    public Cell(){
    }

    public void place(Object object){
	container = object;
    }
    public Object get(){
	return container;
    }
}
	