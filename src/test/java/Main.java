import java.nio.IntBuffer;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.Version;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.stb.STBImage.*;
import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.system.MemoryStack.stackPush;

public class Main {

    private long window;

    private void updateProjection(int width, int height) {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        float aspectRatio = (float) width / (float) height;
        glOrtho(-aspectRatio, aspectRatio, -1.0, 1.0, -1.0, 1.0);
        glMatrixMode(GL_MODELVIEW);
    }

    private int loadTexture(String path) {
        int width, height;
        java.nio.ByteBuffer image;

        try (MemoryStack stack = stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer comp = stack.mallocInt(1);

            stbi_set_flip_vertically_on_load(true);
            image = stbi_load(path, w, h, comp, 4);
            if (image == null) {
                throw new RuntimeException("Failed to load texture file: " + stbi_failure_reason());
            }
            width = w.get();
            height = h.get();
        }

        int textureID = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, textureID);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, image);
        stbi_image_free(image); 
        return textureID;
    }

    public void run() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
        init();
        loop();

        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");

        glfwWindowHint(GLFW_VISIBLE, GLFW_TRUE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        window = glfwCreateWindow(800, 600, "Farming Game", 0, 0);
        if (window == 0)
            throw new RuntimeException("Failed to create the GLFW window");

        // input
        Keyboard.setupCallbacks(window);
        Mouse.setupCallbacks(window);

        glfwSetFramebufferSizeCallback(window, (window, width, height) -> {
            glViewport(0, 0, width, height);
            updateProjection(width, height);
        });

        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);
            glfwGetWindowSize(window, pWidth, pHeight);
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
            glfwSetWindowPos(
                window,
                (vidmode.width() - pWidth.get(0)) / 2,
                (vidmode.height() - pHeight.get(0)) / 2
            );
        }

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);
    }

    private void loop() {
        GL.createCapabilities();

        try (MemoryStack stack = stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            glfwGetWindowSize(window, w, h);
            glViewport(0, 0, w.get(0), h.get(0));
            updateProjection(w.get(0), h.get(0));
        }

        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        int playerTexture = loadTexture("images/board.jpg"); 

        glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
        
        while (!glfwWindowShouldClose(window)) {
            if (Keyboard.isKeyDown(GLFW_KEY_W)) System.out.println("Moving Up");
            if (Keyboard.isKeyDown(GLFW_KEY_A)) System.out.println("Moving Left");
            if (Keyboard.isKeyDown(GLFW_KEY_S)) System.out.println("Moving Down");
            if (Keyboard.isKeyDown(GLFW_KEY_D)) System.out.println("Moving Right");
            
            if (Mouse.isButtonDown(GLFW_MOUSE_BUTTON_LEFT)) {
                System.out.println("Click at: " + Mouse.getX() + ", " + Mouse.getY());
            }

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            glBindTexture(GL_TEXTURE_2D, playerTexture);
            glBegin(GL_QUADS);
                glTexCoord2f(0, 0); glVertex2f(-1, -1f); // Bottom Left 
                glTexCoord2f(1, 0); glVertex2f(1f, -1f);  // Bottom Right
                glTexCoord2f(1, 1); glVertex2f(1f, 1f);   // Top Right
                glTexCoord2f(0, 1); glVertex2f(-1f, 1f);  // Top Left
            glEnd();

            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}