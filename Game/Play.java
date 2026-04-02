package Game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Play implements KeyListener {

    JLabel label;
    ImageIcon icon;

    Play(){
        JFrame frame = new JFrame();
        frame.setTitle("Cosmo Crash");
        frame.setSize(750,500); // isse dimensions set hojayegnge
        frame.setLocationRelativeTo(null); // isse apna game center of screen pe display hoga
        frame.setResizable(true); // isse vo apna game ka tab maximize/bada chota nahi karpayega apne marzi se
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //window mein x button ajayega jisse game band hojayega

        icon = new ImageIcon("./assets/images/MainShip.jpg");

        label = new JLabel();
        label.setBounds(200, 200, 200, 89);
        label.setIcon(icon);
        // label.setBackground(Color.BLACK);
        // label.setOpaque(true);


        frame.add(label);
        frame.addKeyListener(this);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                label.setLocation(label.getX()-10,label.getY());
                break;
            case 'w':
                label.setLocation(label.getX(),label.getY()-10);
                break;
            case 's':
                label.setLocation(label.getX(),label.getY()+10);
                break;
            case 'd':
                label.setLocation(label.getX()+10,label.getY());
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                label.setLocation(label.getX()-10,label.getY());
                break;
            case 38:
                label.setLocation(label.getX(),label.getY()-10);
                break;
            case 40:
                label.setLocation(label.getX(),label.getY()+10);
                break;
            case 39:
                label.setLocation(label.getX()+10,label.getY());
                break;
        }
    }

    public void keyReleased(KeyEvent e) {}

}

class Main_play{
    public static void main(String[] args) {
        Play play = new Play();
    }
}