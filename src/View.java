import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static org.lwjgl.opengl.GL11.*; //don't have to type 'GL11.stuff' just type 'stuff'.
 
public class View {
 
    protected Random rand = new Random();
    public static enum ViewableType {Characters};
	
    public void start() {
        try {
	    Display.setDisplayMode(new DisplayMode(800,600));
	    Display.create();
	} catch (LWJGLException e) {
	    e.printStackTrace();
	    System.exit(0);
	}
	 
	// init OpenGL
	glMatrixMode(GL11.GL_PROJECTION);
	glLoadIdentity();
	glOrtho(0, 800, 0, 600, 20, -20);
	glMatrixMode(GL11.GL_MODELVIEW);
		
	// Clear the screen and depth buffer
	glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
	drawBackground(); //initial setup
	 
    }
 
    
    protected void randomTile(float x, float y) {	
	drawTile(rand.nextFloat(),rand.nextFloat(),rand.nextFloat(),x,y);
    }

    protected void drawTile(float a, float b, float c, float x, float y) {
	//a,b,c set color. x,y set global position.
	//0 <= a,b,c <= 1.0     x,y are within window width/height (800x600)
	//x,y should also line up with a 20x20 grid:
	//x should be multiples of 40, y multiples of 30.
	
	// set the color of the quad (R,G,B)
	glColor3f(a,b,c);
		    	
	//move to position
	glLoadIdentity();
	glTranslatef(x,y,0f);
	
	// draw quad
	glBegin(GL_QUADS);
	glVertex2f(0,0);
	glVertex2f(40,0);
	glVertex2f(40,30);
	glVertex2f(0,30);
	glEnd();
    }

    public void drawCharacters(ArrayList<Character> characters){
    	for (Character character : characters){
	    character.updateList(characters);
	    drawCharacter(character);
    	}
    	
    }
    
    public void drawCharacter(Character thing) {
    	if(thing.isAlive()) {
    	    glPushMatrix();
    	    glLoadIdentity();
	    glRotatef(thing.getAngle(),0,0,1);
    	    glTranslatef(thing.getXPos(),thing.getYPos(), 0.0f);
    	    float[] color = thing.getColor();
    	    glColor3f(color[0],color[1],color[2]);

	    int size = thing.getSize();
    	    
	    switch(thing.getShape()) {
	    case TRIANGLE:
		glBegin(GL_TRIANGLES);
		glVertex3f(size*4f,0f,0f);
		glVertex3f(size*-2f,size*2f,0f);
		glVertex3f(size*-2f,size*-2f,0f);
		glEnd();
		break;
	    case SQUARE:
		glBegin(GL_QUADS);
		glVertex3f(size*3f,size*3f,0f);
		glVertex3f(size*3f,size*3f,0f);
		glVertex3f(size*3f,size*3f,0f);
		glVertex3f(size*3f,size*3f,0f);
		glEnd();
		break;
	    case CIRCLE:
		Sphere circle = new Sphere();
		circle.draw(size*3f,15,15);
		break;
	    case PLUS:
	    glVertex3f(size*3f,(float)size,0f);
	    glVertex3f(size*3f,-(float)size,0f);
	    glVertex3f(-size*3f,-(float)size,0f);
	    glVertex3f(-size*3f,(float)size,0f);
	    
	    glVertex3f((float)size,size*3f,0f);
	    glVertex3f(-(float)size,size*3f,0f);
	    glVertex3f(-(float)size,-size*3f,0f);
	    glVertex3f((float)size,-size*3f,0f);
		break;
	    }	
    	    glPopMatrix();
    	}
    }
    
    public void draw(ViewableType viewtype, Object viewable){
    	switch(viewtype){
    	case Characters:
	    drawCharacters((ArrayList<Character>) viewable);
	    break;
    	}
    }

    public void update(HashMap viewables) { //maybe give a list of the things
	//on the map to go through and reset the isDrawn thing 
	//and check if alive.
	//for now, just the one character...you
	drawBackground();
	for (Object viewable : viewables.keySet()){
	    draw((ViewableType) viewable, viewables.get((ViewableType) viewable));
	}
    }

    protected void drawTile(float[] color, float x, float y) {
    	drawTile(color[0], color[1], color[2], x, y);
    }


    

    public void drawBackground() {
    	glColor3f(0f,0f,0f);
    	
    	glBegin(GL_QUADS);
    	glVertex3f(800,600,-1);
    	glVertex3f(800,0,-1);
    	glVertex3f(0,0,-1);
    	glVertex3f(0,600,-1);
    	glEnd();
    	
    	
    	
	//will be used for better game, not for LD48

    //draw grey background arena
    	
	/*//Left end row
	for(int i = 0; i < 20; i++) {
	    drawTile(.5f,.5f,.5f,0f,i*30f);
	}
	
	//middle
	for(int i = 1; i <= 18; i++) {
	    drawTile(.5f,.5f,.5f,i*40,0);
	    for(int j = 1; j <= 18; j++) {
		drawTile(0f,0f,0f,i*40,j*30);
	    }
	    drawTile(.5f,.5f,.5f,i*40,570f);
	}
	
	//Right end row
	for(int i = 0; i < 20; i++) {
	    drawTile(.5f,.5f,.5f,760f,i*30);
	}*/
    }
}
