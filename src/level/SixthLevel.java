package level;

import game.*;
import status.Victory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SixthLevel {
    private JFrame levelsFrame;
    private JPanel levelsPanel;
    private JLabel selectLevel;
    private JButton level1;
    private JButton level2;
    private JButton level3;
    private JButton level4;
    private JButton level5;
    private JButton level6;

    private ImageIcon image_1, image_2, image_3, image_4, image_5, image_6;

    private final int FRAME_WIDTH = 700, FRAME_HEIGHT = 700;

    public SixthLevel() {
        createGamePrepScreen();
    }

    private void createGamePrepScreen() {
        this.image_1 = new ImageIcon("assets\\level\\level_1.png");
        this.image_2 = new ImageIcon("assets\\level\\level_2.png");
        this.image_3 = new ImageIcon("assets\\level\\level_3.png");
        this.image_4 = new ImageIcon("assets\\level\\level_4.png");
        this.image_5 = new ImageIcon("assets\\level\\level_5.png");
        this.image_6 = new ImageIcon("assets\\level\\level_6.png");

        this.selectLevel = new JLabel("SELECT LEVEL!");
        this.selectLevel.setFont(new Font("Arial",Font.BOLD, 60));
        this.selectLevel.setBounds(125,50,500,100);
        this.selectLevel.setForeground(Color.WHITE);

        this.level1 = new JButton(this.image_1);
        this.level1.setBounds(70,200,150,150);
        ActionListener levelClick_1 = new Level_1();
        this.level1.addActionListener(levelClick_1);

        this.level2 = new JButton(this.image_2);
        this.level2.setBounds(275,200,150,150);
        ActionListener levelClick_2 = new Level_2();
        this.level2.addActionListener(levelClick_2);

        this.level3 = new JButton(this.image_3);
        this.level3.setBounds(480,200,150,150);
        ActionListener levelClick_3 = new Level_3();
        this.level3.addActionListener(levelClick_3);

        this.level4 = new JButton(this.image_4);
        this.level4.setBounds(70,405,150,150);
        ActionListener levelClick_4 = new Level_4();
        this.level4.addActionListener(levelClick_4);

        this.level5 = new JButton(this.image_5);
        this.level5.setBounds(275,405,150,150);
        ActionListener levelClick_5 = new Level_5();
        this.level5.addActionListener(levelClick_5);

        this.level6 = new JButton(this.image_6);
        this.level6.setBounds(480,405,150,150);
        ActionListener levelClick_6 = new Level_6();
        this.level6.addActionListener(levelClick_6);

        this.levelsPanel = new JPanel();
        this.levelsPanel.setBounds(0,0,700,700);
        this.levelsPanel.setBackground(Color.BLACK);
        this.levelsPanel.setLayout(null);
        this.levelsPanel.add(this.selectLevel);
        this.levelsPanel.add(this.level1);
        this.levelsPanel.add(this.level2);
        this.levelsPanel.add(this.level3);
        this.levelsPanel.add(this.level4);
        this.levelsPanel.add(this.level5);
        this.levelsPanel.add(this.level6);

        this.levelsFrame = new JFrame();
        this.levelsFrame.setTitle("Main Menu");
        this.levelsFrame.setLayout(null);
        this.levelsFrame.add(this.levelsPanel);
        this.levelsFrame.setSize(this.FRAME_WIDTH,this.FRAME_HEIGHT);
        this.levelsFrame.setLocationRelativeTo(null);
        this.levelsFrame.setResizable(false);
        this.levelsFrame.setUndecorated(true);
        this.levelsFrame.setVisible(true);
    }

    class Level_1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new GameScene_1(GamePrep.selectedImage);
            levelsFrame.dispose();
            Victory.count--;
        }
    }

    class Level_2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new GameScene_2(GamePrep.selectedImage);
            levelsFrame.dispose();
            Victory.count--;
        }
    }

    class Level_3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new GameScene_3(GamePrep.selectedImage);
            levelsFrame.dispose();
            Victory.count--;
        }
    }

    class Level_4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new GameScene_4(GamePrep.selectedImage);
            levelsFrame.dispose();
            Victory.count--;
        }
    }

    class Level_5 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new GameScene_5(GamePrep.selectedImage);
            levelsFrame.dispose();
            Victory.count--;
        }
    }
    class Level_6 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new GameScene_6(GamePrep.selectedImage);
            levelsFrame.dispose();
        }
    }
}
