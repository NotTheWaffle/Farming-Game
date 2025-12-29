import static org.lwjgl.glfw.GLFW.*;

public class Mouse {
    private static double x, y;
    private static boolean[] buttons = new boolean[8];

    public static void setupCallbacks(long window) {
        // cursor position
        glfwSetCursorPosCallback(window, (win, xpos, ypos) -> {
            x = xpos;
            y = ypos;
        });

        // button click
        glfwSetMouseButtonCallback(window, (win, button, action, mods) -> {
            if (button >= 0 && button < buttons.length) {
                buttons[button] = (action != GLFW_RELEASE);
            }
        });
    }

    public static double getX() { return x; }
    public static double getY() { return y; }
    public static boolean isButtonDown(int button) { return buttons[button]; }
}