

import java.awt.event.ComponentEvent;
import java.util.LinkedList;
import java.util.Queue;

public class InputHandler {
	public final Queue<ComponentEvent> unhandled;
	public final Game game;
	public int mouseX;
	public int mouseY;
	public int mouseDown;

	public InputHandler(Game game){
		this.game = game;
		this.unhandled = new LinkedList<>();
	}
	public void handle(){
		while (!unhandled.isEmpty()){
			ComponentEvent event = unhandled.remove();
			switch (event.getID()){
				case 401 -> {
					//key down
				}
				case 402 -> {
					//key up
				}
				case 501 -> {
					//mouse down
				}
				case 502 -> {
					//mouse up
				}
				case 503 -> {
					//mouse moved
				}
				case 504 -> {
					// mouse entered
				}
				case 505 -> {
					// mouse exited
				}
				case 506 -> {
					//mouse dragged
				}
				case 507 -> {
					//mouse scrolled
				}
				case 1004 -> {
					//gained focus
				}
				case 1005 -> {
					//lost focus
				}
			}
		}
	}
	
}