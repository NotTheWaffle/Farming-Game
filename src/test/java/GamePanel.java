
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener, FocusListener{

	private final Game game;


	private final Window window;
	private final int width;
	private final int height;
	
	public GamePanel(int width, int height, Window window, Game game){
		this.width = width;
		this.height = height;
		this.game = game;
		this.window = window;
		
		this.setFocusTraversalKeysEnabled(false);
		this.setFocusable(true);
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		updateFrame(g2d);
	}
	private void updateFrame(Graphics2D g2d){
		if (game.turn < 0 || game.turn >= game.players.size()){
			return;
		}
		Player player = game.players.get(game.turn);
		renderPlayer(g2d, player);
	}
	private void renderPlayer(Graphics2D g2d, Player player){
		int offx = 0;
		int offy = 0;
		for (Card card : player.otbs){
			renderCard(g2d, card, offx, offy);
			offx+=4;
			offy+=180;
		}
	}
	private void renderCard(Graphics2D g2d, Card card, int x, int y){
		g2d.setColor(Color.blue);
		g2d.fillRect(x,y,300,200);
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(4));
		g2d.drawRect(x,y,300,200);
		renderString(g2d, card.getText(), x, y+20, 20, 300);
	}
	private void renderString(Graphics2D g2d, String str, int x, int y, int fontHeight, int width){
		g2d.setFont(new Font("Monospaced",Font.BOLD,fontHeight));
		List<String> lines = new ArrayList<>();
		lines.addAll(List.of(str.split("\n")));
		int fontWidth = (fontHeight*3/5);
		int maxLength = width/fontWidth;
		y+=fontHeight;
		for (int lineNum = 0; lineNum < lines.size(); lineNum++){
			String line = lines.get(lineNum);
			if (line.length() > maxLength) {
				for (int ch = maxLength; ch > 0; ch--){
					if (line.charAt(ch) == ' '){
						lines.add(lineNum+1,line.substring(ch+1));
						line = line.substring(0,ch);
					}
				}
			}
			g2d.drawString(line, x+(maxLength-line.length())*(fontWidth)/2, y);
			y+=20;
		}
	}

	@Override public void keyPressed	(KeyEvent e) {window.input.unhandled.add(e);}
	@Override public void keyReleased	(KeyEvent e) {window.input.unhandled.add(e);}
	@Override public void keyTyped		(KeyEvent e) {}

	@Override public void mouseReleased	(MouseEvent e) {window.input.unhandled.add(e);}
	@Override public void mousePressed	(MouseEvent e) {window.input.unhandled.add(e);}
	@Override public void mouseClicked	(MouseEvent e) {}

	@Override public void mouseEntered	(MouseEvent e) {window.input.unhandled.add(e);}
	@Override public void mouseExited	(MouseEvent e) {window.input.unhandled.add(e);}
	@Override public void mouseMoved	(MouseEvent e) {window.input.unhandled.add(e);}
	@Override public void mouseDragged	(MouseEvent e) {window.input.unhandled.add(e);}

	@Override public void mouseWheelMoved(MouseWheelEvent e){window.input.unhandled.add(e);}
	
	@Override public void focusGained(FocusEvent e) {window.input.unhandled.add(e);}
	@Override public void focusLost(FocusEvent e)   {window.input.unhandled.add(e);}
}