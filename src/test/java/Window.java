

import javax.swing.JFrame;

public class Window {
	private final JFrame frame;

	private final GamePanel gamePanel;

	public final InputHandler input;


	public Window(Game game, int gameWidth, int gameHeight){
		this.input = new InputHandler(game);

		int width  = 8  + gameWidth  + 8;
		int height = 31 + gameHeight + 8;

		this.frame = new JFrame("Farming Game");
		this.frame.setBounds(0, 0, width, height);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true); 
		this.frame.setLayout(null);
		this.frame.setResizable(false);
		

		this.gamePanel = new GamePanel(gameWidth, gameHeight, this, game);
		this.gamePanel.setBounds(0, 0, gameWidth, gameHeight);
		this.frame.add(gamePanel);
		
		gamePanel.addMouseListener(gamePanel);
		gamePanel.addMouseMotionListener(gamePanel);
		gamePanel.addMouseWheelListener(gamePanel);
		gamePanel.addKeyListener(gamePanel);
	 	gamePanel.addFocusListener(gamePanel);

		gamePanel.requestFocus();
	}

	public void render(){
		gamePanel.repaint();
	}
}