

import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Queue;

public class InputHandler {
	public final Queue<ComponentEvent> unhandled;
	public final Game game;
	public final GamePanel gamePanel;
	public int mouseX;
	public int mouseY;
	public int mouseDown;

	public InputHandler(Game game, GamePanel gamePanel){
		this.game = game;
		this.gamePanel = gamePanel;
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
					MouseEvent e = (MouseEvent) event;
					mouseX = e.getX();
					mouseY = e.getY();
					if (mouseY > 800 && mouseX < 500){
						gamePanel.selectedOTB = mouseX/100;
					} else {
						gamePanel.selectedOTB = -1;
					}
					gamePanel.repaint();
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