import static org.lwjgl.glfw.GLFW.*;

public class Keyboard {
    private static boolean[] keys = new boolean[65536];

    public static void setupCallbacks(long window) {
        glfwSetKeyCallback(window, (win, key, scancode, action, mods) -> {
            if (key >= 0 && key < keys.length) {
                keys[key] = (action != GLFW_RELEASE);
            }
        });
    }

    public static boolean isKeyDown(int keycode) {
        return keys[keycode];
    }
}