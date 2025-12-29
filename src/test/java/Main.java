import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.stb.STBImage.*;
import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Main {

    private long window;

    private void updateProjection(int width, int height) {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        float aspectRatio = (float) width / (float) height;
        // Adjusted glOrtho to keep the board square regardless of window stretching
        glOrtho(-aspectRatio, aspectRatio, -1.0, 1.0, -1.0, 1.0);
        glMatrixMode(GL_MODELVIEW);
    }

    private int loadTexture(String path) {
        int textureID;
        int width, height;

        // Use MemoryStack for safe, auto-closing off-heap memory
        try (MemoryStack stack = stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer comp = stack.mallocInt(1);

            stbi_set_flip_vertically_on_load(true);
            ByteBuffer image = stbi_load(path, w, h, comp, 4);
            if (image == null) {
                throw new RuntimeException("Failed to load texture file: " + stbi_failure_reason());
            }

            width = w.get();
            height = h.get();

            textureID = glGenTextures();
            glBindTexture(GL_TEXTURE_2D, textureID);

            // Using GL_LINEAR for slightly smoother scaling if needed
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, image);
            
            stbi_image_free(image); 
        }
        return textureID;
    }

    // this is the first method called to run the program
    public void run() {
        init(); // simple initializaion steps
        loop(); // this is where most of the code will be executed
        // this is reached after the window is closed and the program is exiting
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        // create a stream to print out when there are errors
        GLFWErrorCallback.createPrint(System.err).set();

        // ensure that GLFW is able to be run
        if (!glfwInit()) throw new IllegalStateException("Unable to initialize GLFW");

        // initialize the window
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // Hidden until centered
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        // define the window size and title
        window = glfwCreateWindow(800, 600, "Farming Game", NULL, NULL);
        if (window == NULL) throw new RuntimeException("Failed to create the GLFW window"); // in case the window fails we want to report that information

        // see the keyboard and mouse classes to observe their setups
        Keyboard.setupCallbacks(window);
        Mouse.setupCallbacks(window);

        // code that runs when the window is resized
        glfwSetFramebufferSizeCallback(window, (win, w, h) -> {
            glViewport(0, 0, w, h);
            updateProjection(w, h); // we want to keep the picture of the board scaling the whole time
        });

        // Center window
        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);
            glfwGetWindowSize(window, pWidth, pHeight);
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
            glfwSetWindowPos(window, (vidmode.width() - pWidth.get(0)) / 2, (vidmode.height() - pHeight.get(0)) / 2);
        }

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1); // Enable V-Sync
        glfwShowWindow(window); // the window is finally ready to be shown
    }

    // the majority of the code will be here for each update
    private void loop() {
        GL.createCapabilities();

        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        int boardTexture = loadTexture("images/board.jpg");

        // Initial projection setup
        try (MemoryStack stack = stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            glfwGetFramebufferSize(window, w, h);
            updateProjection(w.get(0), h.get(0));
        }

        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glClearColor(0.1f, 0.1f, 0.1f, 1.0f);

            // to allow for the window to be closed
            if (Keyboard.isKeyDown(GLFW_KEY_ESCAPE)) glfwSetWindowShouldClose(window, true);

            glBindTexture(GL_TEXTURE_2D, boardTexture);
            glBegin(GL_QUADS);
                glTexCoord2f(0, 0); glVertex2f(-0.8f, -0.8f);
                glTexCoord2f(1, 0); glVertex2f(0.8f, -0.8f);
                glTexCoord2f(1, 1); glVertex2f(0.8f, 0.8f);
                glTexCoord2f(0, 1); glVertex2f(-0.8f, 0.8f);
            glEnd();

            glfwSwapBuffers(window);
            glfwPollEvents();
        }
        
        glDeleteTextures(boardTexture);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}