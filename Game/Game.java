/*
package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel implements KeyListener {

    int boardWidth = 750, boardHeight = 500;
    Image backgroundImg, mainshipImg;
    int shipx = 40, shipy = 400, shipwidth = 50, shipheight = 35;

    int health = 3;
    boolean gameOver = false;

    // Enemy class using your Block class idea
    class Enemy {
        int x, y, width = 40, height = 30, speed = 3;

        Enemy(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void move() {
            x -= speed;
            if (x < -width) {
                reset(); // respawn when off screen
            }
        }

        void reset() {
            x = boardWidth + new Random().nextInt(200);
            y = new Random().nextInt(boardHeight - height);
        }

        Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }

        void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(x, y, width, height); // Placeholder enemy as red box
        }
    }

    ArrayList<Enemy> enemies = new ArrayList<>();

    Game() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setFocusable(true);
        addKeyListener(this);

        // Load images
        backgroundImg = new ImageIcon(getClass().getResource("/assets/images/background.jpg")).getImage();
        mainshipImg = new ImageIcon(getClass().getResource("/assets/images/MainShip.jpg")).getImage();

        // Spawn 3 enemies at random positions
        for (int i = 0; i < 3; i++) {
            enemies.add(new Enemy(boardWidth + i * 200, new Random().nextInt(boardHeight - 30)));
        }

        Timer gameTimer = new Timer(30, e -> {
            if (!gameOver) {
                updateGame();
            }
            repaint();
        });
        gameTimer.start();
    }

    public void updateGame() {
        // Move enemies and check collision
        for (Enemy enemy : enemies) {
            enemy.move();
            if (enemy.getBounds().intersects(new Rectangle(shipx, shipy, shipwidth, shipheight))) {
                health--;
                enemy.reset();

                if (health <= 0) {
                    gameOver = true;
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // Background and ship
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, this);
        g.drawImage(mainshipImg, shipx, shipy, shipwidth, shipheight, this);

        // Draw enemies
        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }

        // Draw health
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Health: " + health, 20, 30);

        // Draw game over
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("GAME OVER", boardWidth / 2 - 150, boardHeight / 2);
        }

        // Show controls
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Move with Arrow Keys or W A S D", boardWidth - 260, boardHeight - 20);
    }

    // Handle movement input
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (!gameOver) {
            if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && shipx > 0)
                shipx -= 10;
            else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && shipx < boardWidth - shipwidth)
                shipx += 10;
            else if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && shipy > 0)
                shipy -= 10;
            else if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && shipy < boardHeight - shipheight)
                shipy += 10;
        }

        // Restart the game if user presses Enter after game over
        if (gameOver && key == KeyEvent.VK_ENTER) {
            resetGame();
        }
    }

    public void resetGame() {
        health = 3;
        shipx = 40;
        shipy = boardHeight - shipheight;
        gameOver = false;

        for (Enemy enemy : enemies) {
            enemy.reset();
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
*/
package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel implements KeyListener {

    int boardWidth = 750, boardHeight = 500;
    Image backgroundImg, mainshipImg;
    int shipx = 40, shipy = 400, shipwidth = 50, shipheight = 35;
    int health = 3;
    boolean gameOver = false;

    class Bullet {
        int x, y, width = 10, height = 4, speed = 8;

        Bullet(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void move() {
            x += speed;
        }

        boolean isOffScreen() {
            return x > boardWidth;
        }

        void draw(Graphics g) {
            g.setColor(Color.YELLOW);
            g.fillRect(x, y, width, height);
        }

        Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
    }

    class Enemy {
        int x, y, width = 40, height = 30, speed = 3;

        Enemy(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void move() {
            x -= speed;
            if (x < -width) reset();
        }

        void reset() {
            x = boardWidth + new Random().nextInt(200);
            y = new Random().nextInt(boardHeight - height);
        }

        Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }

        void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(x, y, width, height);
        }
    }

    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();

    public Game() {
        JFrame frame = new JFrame("Cosmocrash Game");

        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setFocusable(true);
        addKeyListener(this);

        backgroundImg = new ImageIcon(getClass().getResource("/assets/images/background.jpg")).getImage();
        mainshipImg = new ImageIcon(getClass().getResource("/assets/images/MainShip.jpg")).getImage();

        for (int i = 0; i < 3; i++)
            enemies.add(new Enemy(boardWidth + i * 200, new Random().nextInt(boardHeight - 30)));

        new Timer(30, e -> {
            if (!gameOver) updateGame();
            repaint();
        }).start();

        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    void updateGame() {
        for (Enemy enemy : enemies) {
            enemy.move();
            if (enemy.getBounds().intersects(new Rectangle(shipx, shipy, shipwidth, shipheight))) {
                health--;
                enemy.reset();
                if (health <= 0) gameOver = true;
            }
        }

        bullets.removeIf(bullet -> {
            bullet.move();
            if (bullet.isOffScreen()) return true;
            for (Enemy enemy : enemies) {
                if (bullet.getBounds().intersects(enemy.getBounds())) {
                    enemy.reset();
                    return true;
                }
            }
            return false;
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, this);
        g.drawImage(mainshipImg, shipx, shipy, shipwidth, shipheight, this);

        enemies.forEach(enemy -> enemy.draw(g));
        bullets.forEach(bullet -> bullet.draw(g));

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Health: " + health, 20, 30);

        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Use Arrow keys / WASD to move, SPACE to shoot", 20, boardHeight - 20);

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("GAME OVER", boardWidth / 2 - 150, boardHeight / 2);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press ENTER to restart", boardWidth / 2 - 100, boardHeight / 2 + 40);
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (!gameOver) {
            if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && shipx > 0)
                shipx -= 10;
            else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && shipx < boardWidth - shipwidth)
                shipx += 10;
            else if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && shipy > 0)
                shipy -= 10;
            else if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && shipy < boardHeight - shipheight)
                shipy += 10;
            else if (key == KeyEvent.VK_SPACE)
                bullets.add(new Bullet(shipx + shipwidth, shipy + shipheight / 2));
        }

        if (gameOver && key == KeyEvent.VK_ENTER) resetGame();
    }

    public void resetGame() {
        health = 3;
        shipx = 40;
        shipy = boardHeight - shipheight;
        gameOver = false;
        bullets.clear();
        enemies.forEach(Enemy::reset);
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}

class Main_Game {
    public static void main(String[] args) {
        new Game();
    }
}