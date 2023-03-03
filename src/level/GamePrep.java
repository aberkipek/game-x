package level;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePrep {
    private JFrame gamePrepFrame;
    private JPanel gamePrepPanel;
    private JButton hero_1;
    private JButton hero_2;
    private JButton hero_3;
    private ImageIcon heroImage_1;
    private ImageIcon heroImage_2;
    private ImageIcon heroImage_3;
    private ImageIcon heroAvatar_1;
    private ImageIcon heroAvatar_2;
    private ImageIcon heroAvatar_3;
    public static ImageIcon selectedImage;
    private JLabel selectHero;

    public static JTextField username;
    private JLabel enterUsername;
    private final int FRAME_WIDTH = 700;
    private final int FRAME_HEIGHT = 700;

    public GamePrep() {
        createGamePrepScreen();
    }
    private void createGamePrepScreen() {
        this.heroImage_1 = new ImageIcon("assets\\character\\hero_1.png");
        this.heroImage_2 = new ImageIcon("assets\\character\\hero_2.png");
        this.heroImage_3 = new ImageIcon("assets\\character\\hero_3.png");

        this.heroAvatar_1 = new ImageIcon("assets\\character\\avatar_1.png");
        this.heroAvatar_2 = new ImageIcon("assets\\character\\avatar_2.png");
        this.heroAvatar_3 = new ImageIcon("assets\\character\\avatar_3.png");

        this.enterUsername = new JLabel("FIRST ENTER A USERNAME!");
        this.enterUsername.setFont(new Font("Arial",Font.BOLD, 30));
        this.enterUsername.setBounds(125,100,450,100);
        this.enterUsername.setForeground(Color.WHITE);

        this.selectHero = new JLabel("THEN SELECT YOUR HERO!");
        this.selectHero.setFont(new Font("Arial",Font.BOLD, 30));
        this.selectHero.setBounds(125,350,450,100);
        this.selectHero.setForeground(Color.WHITE);

        this.hero_1 = new JButton(heroImage_1);
        this.hero_1.setBounds(100,500,100,100);
        ActionListener heroClick_1 = new Hero_1();
        this.hero_1.addActionListener(heroClick_1);

        this.hero_2 = new JButton(heroImage_2);
        this.hero_2.setBounds(300,500,100,100);
        ActionListener heroClick_2 = new Hero_2();
        this.hero_2.addActionListener(heroClick_2);

        this.hero_3 = new JButton(heroImage_3);
        this.hero_3.setBounds(500,500,100,100);
        ActionListener heroClick_3 = new Hero_3();
        this.hero_3.addActionListener(heroClick_3);

        this.username = new JTextField("  USERNAME",40);
        this.username.setBounds(200,250,300,50);
        this.username.setFont(new Font("Serif",Font.BOLD,22));
        this.username.setForeground(Color.WHITE);
        this.username.setBackground(Color.DARK_GRAY);
        this.username.setCaretColor(Color.WHITE);
        this.username.setCaretPosition(2);

        this.gamePrepPanel = new JPanel();
        this.gamePrepPanel.setBounds(0,0,700,700);
        this.gamePrepPanel.setBackground(Color.BLACK);
        this.gamePrepPanel.setLayout(null);
        this.gamePrepPanel.add(this.username);
        this.gamePrepPanel.add(this.enterUsername);
        this.gamePrepPanel.add(this.selectHero);
        this.gamePrepPanel.add(this.hero_1);
        this.gamePrepPanel.add(this.hero_2);
        this.gamePrepPanel.add(this.hero_3);

        this.gamePrepFrame = new JFrame();
        this.gamePrepFrame.setTitle("Game Prep");
        this.gamePrepFrame.setLayout(null);
        this.gamePrepFrame.add(this.gamePrepPanel);
        this.gamePrepFrame.setSize(this.FRAME_WIDTH,this.FRAME_HEIGHT);
        this.gamePrepFrame.setLocationRelativeTo(null);
        this.gamePrepFrame.setResizable(false);
        this.gamePrepFrame.setUndecorated(true);
        this.gamePrepFrame.setVisible(true);
    }

    class Hero_1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(true) {
                selectedImage = heroAvatar_1;
                new FirstLevel();
                gamePrepFrame.dispose();
            }

            else {
                // Generate an error screen
            }
        }
    }

    class Hero_2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(true) {
                selectedImage = heroAvatar_2;
                new FirstLevel();
                gamePrepFrame.dispose();
            }

            else {
                // Generate an error screen
            }
        }
    }

    class Hero_3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(true) {
                selectedImage = heroAvatar_3;
                new FirstLevel();
                gamePrepFrame.dispose();
            }

            else {
                // Generate an error screen
            }
        }
    }
}