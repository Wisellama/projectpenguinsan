import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*; //don't have to type GL11.stuff just type stuff.
 
public class View {
 
	protected Random rand = new Random();
	
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
	glOrtho(0, 800, 0, 600, 1, -1);
	glMatrixMode(GL11.GL_MODELVIEW);
	
	// Clear the screen and depth buffer
    glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	
	for(int i = 0; i < 100; i++) {
    	for(int j = 0; j < 100; j++) {
    		glTranslatef(i*40, j*30, 0);
    		randomTile();
    		glLoadIdentity();
    	}
    }
 
    }
 
    public static void main(String[] argv) {
        View view = new View(); //make a new one of this class
        view.start(); //start it
    }
    
    protected void randomTile() {	
	    // set the color of the quad (R,G,B,A)
	    glColor3f(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
	    	
	    // draw quad
	    glBegin(GL_QUADS);
	    glVertex2f(0,0);
		glVertex2f(40,0);
		glVertex2f(40,30);
		glVertex2f(0,30);
	    glEnd();
    }

    public void draw(Character thing) {
    if(thing.isAlive() && !thing.isDrawn()) {
	glPushMatrix();
	glTranslatef(thing.getXPos(),thing.getYPos(), 5.0f);
	float[] color = thing.getColor();
	glColor3f(color[0],color[1],color[2]);
	Sphere sphere = new Sphere();
	sphere.draw(15,20,20);
	glPopMatrix();
    }
    }
}
