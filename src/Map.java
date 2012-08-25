import Cell;
public class Map{
    Cell[][] grid;
    public Map(int x, int y){
	int width = x;
	int height = y;
	grid = new Cell[x][y];
    }
    
    public int height(){
	return height;
    }

    public int width(){
	return width;
    }

    public Cell get(int x, int y){
	return grid[x][y];
    }
    public boolean on_side(int x, int y){
	if (x == height-1 || x == 0 || y == width-1 || y == 0){
	    return true;
	}
	return false;
    }
}