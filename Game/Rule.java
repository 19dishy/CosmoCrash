package Game;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rule implements ActionListener{

    JLabel label;
    ImageIcon icon;
    JButton backButton;

    Rule(){
        JFrame frame = new JFrame();
        frame.setTitle("Cosmo Crash");
        frame.setSize(570,640); // isse dimensions set hojayegnge
        frame.setLocationRelativeTo(null); // isse apna game center of screen pe display hoga
        frame.setResizable(true); // isse vo apna game ka tab maximize/bada chota nahi karpayega apne marzi se
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //window mein x button ajayega jisse game band hojaye

        icon = new ImageIcon("./assets/images/Rules.png");
        label = new JLabel();
        label.setBounds(0, 0, 570, 640); // or adjust to image size
        label.setIcon(icon);

        backButton = new JButton();
        backButton.setBounds(0,0,120,40);
        backButton.setText("←");
        backButton.setFont(new Font("Comic Sans",Font.BOLD,50));
        backButton.addActionListener( e -> frame.dispose() );
        backButton.setFocusable(false);

        frame.add(label);
        frame.add(backButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {}
}

class Main_Rule{
    public static void main(String[] args) {
        Rule rule = new Rule();
    }
}