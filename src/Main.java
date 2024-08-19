import models.TexturedModel;
import org.lwjgl.opengl.Display;
import renderEngine.Loader;
import models.RawModel;
import renderEngine.Renderer;
import renderEngine.displayManager;
import shaders.StaticShader;
import textures.ModelTexture;

public class Main {
    public static void main(String[] args) {

        displayManager.createDisplay();
        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();

        RawModel model = loader.loadToVAO(

            // Vertex Pos
            new float[] {
                    -0.5f, 0.5f, 0,
                    -0.5f, -0.5f, 0,
                    0.5f, -0.5f, 0,
                    0.5f, 0.5f, 0f
            },

            // Edge Connections
            new int[] {
                    0,1,3,
                    3,1,2
            },

            new float[]{
                    0,1,1
            }
        );

        ModelTexture texture = new ModelTexture(loader.loadTexture("test"));
        TexturedModel texturedModel = new TexturedModel(model, texture);

        while(!Display.isCloseRequested()){
            renderer.prepare();
            shader.start();
            renderer.render(texturedModel);
            shader.stop();
            displayManager.updateDisplay();
        }

        shader.cleanUp();
        loader.clearUp();
        displayManager.closeDisplay();
    }
}