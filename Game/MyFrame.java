package Game;

import java.awt.*; //Colour,Font
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*; //ImageIcon,JFrame,JLabel,
import javax.swing.border.Border;



public class MyFrame implements ActionListener{
    JButton playButton,ruleButton;
    MyFrame(){

        //Making a frame jisme Game chalega
        JFrame frame = new JFrame();
        frame.setTitle("Cosmo Crash");
        frame.setSize(750,500); // isse dimensions set hojayegnge
        frame.setLocationRelativeTo(null); // isse apna game center of screen pe display hoga
        frame.setResizable(true); // isse vo apna game ka tab maximize/bada chota nahi karpayega apne marzi se
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //window mein x button ajayega jisse game band hojaye


        //Setting Game logo
        ImageIcon logo = new ImageIcon("./assets/images/logo.jpg");
        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(Color.black); //agar koi aur colour daalna hai then use "new Colour(0,0,0)" rgb or hexadecimal
        frame.setLayout(null);


        //Background Image
        JPanel bgPanel = new JPanel() {
            Image bg = new ImageIcon("lbl.png").getImage();
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        

        // "Main Menu" likhke ayega
        JLayeredPane lp = new JLayeredPane();

        lp.setBounds(0, 0, 200, 50);

        JLabel label = new JLabel();
        label.setText("Main Menu"); //writes text in the frame
        label.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setOpaque(true); //sets forebround opacity
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 0, 200, 50); //sets position(x,y) and size(width,height) of the label

        lp.add(label, Integer.valueOf(1));
        lp.add(bgPanel, Integer.valueOf(0));


        //Creating Main Menu buttons (play,quit)
        //PLay Button
        playButton = new JButton();
        playButton.setBounds(300, 80, 120, 50);
        playButton.addActionListener(this);
        playButton.setText("PLAY");
        playButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        playButton.setFocusable(false);

        //Display Rules Button
        ruleButton = new JButton();
        ruleButton.setBounds(300, 160, 120, 50);
        ruleButton.addActionListener(this);
        ruleButton.setText("RULES");
        ruleButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        ruleButton.setFocusable(false);

        //Quit Button
        JButton quitButton = new JButton();
        quitButton.setBounds(300, 240, 120, 50);
        quitButton.addActionListener( e -> System.exit(0) );
        quitButton.setText("QUIT");
        quitButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        //quitButton.setBackground(Color.LIGHT_GRAY);
        quitButton.setFocusable(false);
        // quitButton.setBorder(BorderFactory.createEtchedBorder());

        // frame.setContentPane(new JLabel(lbl));
        // frame.setContentPane(bgPanel);
        frame.add(lp);
        frame.add(label); //label gets added in the frame
        frame.add(playButton); //play button gets added in the frame
        frame.add(ruleButton); //rule button gets added in the frame
        frame.add(quitButton); //quit button gets added in the frame

        frame.setLayout(null);
        frame.setVisible(true); // isse apna game ka window visible hojayega
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            //System.out.println("Hello");
            Game game = new Game();
        }
        else if (e.getSource() == ruleButton) {
            Rule rule = new Rule();
        }
    }

}

class Main{
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
}