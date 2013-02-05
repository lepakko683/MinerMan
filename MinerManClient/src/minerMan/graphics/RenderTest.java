package minerMan.graphics;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

import net.java.games.input.Mouse;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.newdawn.slick.opengl.GLUtils;

import static org.lwjgl.opengl.GL11.*;


public class RenderTest {
	
	
	
	public final int ScWidth = 900;
	public final int ScHeight = 900;
	public final int fps = 120;
	
	//Image texture1 = 
	
	public RenderTest() throws LWJGLException {
		Random rand = new Random();
		for(int i=0;i<3;i++){
			int x = rand.nextInt(250)+250;
			int y = rand.nextInt(250)+250;
			int z = 0;
			
			
		}
		
		Display.setDisplayMode(new DisplayMode(ScWidth, ScHeight));
		Display.setTitle("LOL");
		Display.create();
		
		boolean exec = true;
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, ScWidth, ScHeight, 0, 200, -200);
		glMatrixMode(GL_MODELVIEW);
		
		
		float angle = 0.0f;
		boolean clock = true;
		//glTranslatef(ScWidth/2, ScHeight/2, 0f);
		
		//IntBuffer buf1 = ;
		//int tex1 = glGenTextures(buf1));
		
		
		while(exec){
			if(clock){
				angle += 0.5f;
			}
			else if(!clock){
				angle += -0.5f;
			}
			if(angle<0f){
				clock=true;
			}else if(angle>360f){
				clock=false;
			}
			//System.out.println(angle + "" + clock);

			glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			glPushMatrix();
			
			
			glColor3f(0.1f, 0.2f, 0.3f);
			
				
			
			
			//glRotatef(angle, 0f, 0f,1f);
			
			
			
			
			Display.update();
			Display.sync(fps);
				
			
			glPopMatrix();
			
			if(Display.isCloseRequested()){
				exec = false;
			}
		}
		
		cleanUP();
	}
	
	
	public void cleanUP(){
		Display.destroy();
		System.exit(0);
	}
}
