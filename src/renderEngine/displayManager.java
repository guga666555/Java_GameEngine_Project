package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

// This class handles the window display of the game engine
// You can set the window size ++ fps cap ++ JFrame logic

public class displayManager {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int FPS_CAP = 60;

    public static void createDisplay()
    {
        ContextAttribs attribs = new ContextAttribs(3,2);
        attribs.withForwardCompatible(true);
        attribs.withProfileCore(true);

        try{
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create(new PixelFormat(), attribs);
            Display.setTitle("Java Game First Display Label");
        }
        catch(LWJGLException e){
            e.printStackTrace();
        }

        GL11.glViewport(0,0,WIDTH,HEIGHT);
    }

    public static void updateDisplay(){
        Display.sync(FPS_CAP);
        Display.update();
    }

    public static void closeDisplay(){
        Display.destroy();
    }
}
