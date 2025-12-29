import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener {

    private Timer timer;
    private BufferedImage boardImage;
    
    // --- Input Tracking --- //
    private static boolean[] keys = new boolean[256];
    private static int mouseX, mouseY;


    public Main() {
        // Load the image using standard Java ImageIO
        try {
            boardImage = ImageIO.read(new File("images/board.jpg"));
        } catch (IOException e) {
            System.err.println("Could not load image: " + e.getMessage());
        }

        // Setup Panel Settings
        this.setPreferredSize(new Dimension(800, 600));
        
        this.setBackground(new Color(25, 35, 35)); // Dark teal background
        this.setFocusable(true);

        // --- Keyboard Input ---
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() < keys.length) keys[e.getKeyCode()] = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() < keys.length) keys[e.getKeyCode()] = false;
            }
        });

        // --- Mouse Input --- //
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { 
                System.out.println("Click at: " + e.getX() + ", " + e.getY());
            }
            @Override
            public void mouseReleased(MouseEvent e) { }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        timer = new Timer(16, this); // ~16ms = 60fps
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Logic Updates //
        if (keys[KeyEvent.VK_W]) { /* something */ }
        
        // Redraw the screen
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable Antialiasing for smoother graphics
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the board image (centered)
        if (boardImage != null) {
            int imgW = 400; // Desired width
            int imgH = 400; // Desired height
            int x = (getWidth() - imgW) / 2;
            int y = (getHeight() - imgH) / 2;
            g2d.drawImage(boardImage, x, y, imgW, imgH, null);
        }

        // Draw UI or Player info
        g2d.setColor(Color.WHITE);
        g2d.drawString("Mouse: " + mouseX + ", " + mouseY, 10, 20);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Farming Game");
        Main gamePanel = new Main();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}