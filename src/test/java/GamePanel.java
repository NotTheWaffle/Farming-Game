
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
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener, FocusListener{

	private final Game game;


	private final Window window;
	private final int width;
	private final int height;

	private final Map<Sprite, BufferedImage> spriteMap = new HashMap<>();

	public int selectedOTB = -1;
	
	public GamePanel(int width, int height, Window window, Game game){
		this.width = width;
		this.height = height;
		this.game = game;
		this.window = window;

		spriteMap.put(Sprite.board,loadImage("images/board.png"));
		
		this.setFocusTraversalKeysEnabled(false);
		this.setFocusable(true);
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		updateFrame(g2d);
		g.dispose();
	}
	private void updateFrame(Graphics2D g2d){
		if (game.turn < 0 || game.turn >= game.players.size()){
			return;
		}
		Player player = game.players.get(game.turn);
		renderPlayer(g2d, player);
		AffineTransform at = new AffineTransform();
		at.translate(700, 100);

		at.scale(.9,.9);
		g2d.drawImage(spriteMap.get(Sprite.board),at,null);
		g2d.drawRect(0, 0, 400, 400);
	}
	private void renderPlayer(Graphics2D g2d, Player player){
		renderString(g2d, "Options to Buy", 0, 750, 40, 500);
		g2d.setColor(Color.lightGray);
		g2d.drawRect(0, 800, 500, 200);
		int offx = 0;
		int offy = 800;
		for (int countnum = 0; countnum < player.otbs.size(); countnum++){
			Card card = player.otbs.get(countnum);
			if (countnum == selectedOTB){
				renderCard(g2d, card, offx, offy-80);
			} else if (selectedOTB != -1){
				renderCard(g2d, card, offx, offy+80);
			} else {
				renderCard(g2d, card, offx, offy);
			}
			offx+=100;
		}
	}
	private void renderCard(Graphics2D g2d, Card card, int x, int y){
		int cardWidth = 320;
		g2d.setColor(Color.cyan);
		g2d.fillRect(x,y,cardWidth,200);
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(4));
		g2d.drawRect(x,y,cardWidth,200);
		renderString(g2d, card.getText(), x, y+20, 20, cardWidth);
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
	public BufferedImage loadImage(String path) {
		BufferedImage image = null;
		System.out.println(path);
		try {image = ImageIO.read(getClass().getResource(path));} catch (Exception e) {System.out.println(e);}
		return image;
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