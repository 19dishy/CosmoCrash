package Game;

import java.awt.*;               // For JPanel, Graphics, Image, Dimension
import javax.swing.*;            // For ImageIcon, JPanel

public class Cosmocrash extends JPanel {

    int boardWidth = 750;
    int boardHeight = 500;

    // Images to be used
    Image backgroundImg;
    Image mainshipImg;
    Image ship2crashImg;
    Image ship3crashImg;
    Image ship4crashImg;
    Image ship5crashImg;

    // Block class for static elements (ships etc.)
    class Block {
        int x, y, width, height;
        Image img;

        Block(int x, int y, int width, int height, Image img) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.img = img;
        }
    }

    // Background dimensions and position
    int backgroundx = 0;
    int backgroundy = 0;

    // Spaceship position and size
    int shipwidth = 50;
    int shipheight = 35;
    int shipx = 40;
    int shipy = boardHeight - shipheight;

    public Cosmocrash() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));

        // Load images using relative paths
        backgroundImg = new ImageIcon(getClass().getResource("/Assets/images/background.jpg")).getImage();
        mainshipImg = new ImageIcon(getClass().getResource("/Assets/images/Mainship.png")).getImage();
        ship2crashImg = new ImageIcon(getClass().getResource("/Assets/images/shipblast2.gif")).getImage();
        ship3crashImg = new ImageIcon(getClass().getResource("/Assets/images/shipblast3.gif")).getImage();
        ship4crashImg = new ImageIcon(getClass().getResource("/Assets/images/shipblast4.gif")).getImage();
        ship5crashImg = new ImageIcon(getClass().getResource("/Assets/images/shipblast5.gif")).getImage();
    }

    // This method is automatically called when panel is redrawn
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // clears the previous frame
        draw(g);
    }

    // Draw everything here
    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, this); // use 'this' as ImageObserver
    }
}
