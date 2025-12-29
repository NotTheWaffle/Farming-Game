import java.nio.IntBuffer;

import org.lwjgl.Version;
import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwSetFramebufferSizeCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.stb.STBImage.stbi_failure_reason;
import static org.lwjgl.stb.STBImage.stbi_image_free;
import static org.lwjgl.stb.STBImage.stbi_load;
import static org.lwjgl.stb.STBImage.stbi_set_flip_vertically_on_load;
import org.lwjgl.system.MemoryStack;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Main {

    // The window handle
    private long window;

    private void updateProjection(int width, int height) {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        
        // This sets up a coordinate system where 0,0 is the center.
        // It adjusts the "aspect ratio" so the image doesn't stretch.
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

        // Load image using STB
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

    // Setup scaling filters
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

    // Send data to GPU
    glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, image);
    
    stbi_image_free(image);
    return textureID;
}

    public void run() {
        // simple debug
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        init();
        loop();

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();

        // ensure that glfw is init 
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        // set the config of glfw to be what we want
        glfwWindowHint(GLFW_VISIBLE, GLFW_TRUE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // basic window setup
        window = glfwCreateWindow(800, 600, "Farming Game", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        // key callback for all key presses and stuff   
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE ){
                glfwSetWindowShouldClose(window, true); // detected in rendering look
            }
            if (key == org.lwjgl.glfw.GLFW.GLFW_KEY_W && (action == org.lwjgl.glfw.GLFW.GLFW_PRESS || action == org.lwjgl.glfw.GLFW.GLFW_REPEAT)) {
                System.out.println("w");
            }
            if (key == org.lwjgl.glfw.GLFW.GLFW_KEY_A && (action == org.lwjgl.glfw.GLFW.GLFW_PRESS || action == org.lwjgl.glfw.GLFW.GLFW_REPEAT)) {
                System.out.println("a");
            }
            if (key == org.lwjgl.glfw.GLFW.GLFW_KEY_S && (action == org.lwjgl.glfw.GLFW.GLFW_PRESS || action == org.lwjgl.glfw.GLFW.GLFW_REPEAT)) {
                System.out.println("s");
            }
            if (key == org.lwjgl.glfw.GLFW.GLFW_KEY_D && (action == org.lwjgl.glfw.GLFW.GLFW_PRESS || action == org.lwjgl.glfw.GLFW.GLFW_REPEAT)) {
                System.out.println("d");
            }
        });

        glfwSetMouseButtonCallback(window, (window, scancode, action, mods) -> {
        });

        glfwSetFramebufferSizeCallback(window, (window, width, height) -> {
            glViewport(0, 0, width, height);
            updateProjection(width, height);
        });


        // Get the thread stack and push a new frame
        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // get resolution of monitor for display
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            glfwSetWindowPos( // window centering 
                window,
                (vidmode.width() - pWidth.get(0)) / 2,
                (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        glfwMakeContextCurrent(window); // opengl context
        
        glfwSwapInterval(1); // allows for v-sync

        // Make the window visible
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

        glClearColor(0f, 0f, 0f, 0f);
        
        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            glBindTexture(GL_TEXTURE_2D, playerTexture);
            glBegin(GL_QUADS);
                glTexCoord2f(0, 0); glVertex2f(-1f, -1f); // Bottom Left
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