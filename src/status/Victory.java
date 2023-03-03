package status;

import character.Enemy;
import game.GameScene_1;
import game.GameScene_2;
import game.GameScene_3;
import game.GameScene_4;
import game.GameScene_5;
import level.MainMenu;
import level.SecondLevel;
import level.ThirdLevel;
import level.FourthLevel;
import level.FifthLevel;
import level.SixthLevel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Victory {
    private JFrame victoryScreen;
    private JPanel victory;
    private JLabel youWon;
    private JButton nextButton;
    private JButton backToMenuButton;
    public static int count = 1;
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 300;

    public Victory() {
        createVictoryScreen();
        count++;
        Enemy.turn = 1; // Hero.turn = 1;
    }

    private void createVictoryScreen() {
        this.victory = new JPanel();
        this.victory.setBounds(0,0,500,350);
        this.victory.setBackground(Color.BLACK);
        this.victory.setLayout(null);

        this.youWon = new JLabel("VICTORY!");
        this.youWon.setFont(new Font("Arial",Font.BOLD, 80));
        this.youWon.setBounds(60,25,400,100);
        this.youWon.setForeground(Color.WHITE);

        this.nextButton = new JButton("CONTINUE");
        this.nextButton.setBounds(100,150,300,40);
        this.nextButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.nextButton.setBackground(Color.RED);
        this.nextButton.setForeground(Color.WHITE);
        this.nextButton.setFocusable(false);
        ActionListener nextClick = new ContinueButton();
        this.nextButton.addActionListener(nextClick);

        this.backToMenuButton = new JButton("RETURN TO MAIN MENU");
        this.backToMenuButton.setBounds(100,210,300,40);
        this.backToMenuButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.backToMenuButton.setBackground(Color.RED);
        this.backToMenuButton.setForeground(Color.WHITE);
        this.backToMenuButton.setFocusable(false);
        ActionListener backButtonClick = new BackToMenuButton();
        this.backToMenuButton.addActionListener(backButtonClick);

        this.victory.add(this.youWon);
        this.victory.add(this.nextButton);
        this.victory.add(this.backToMenuButton);

        this.victoryScreen = new JFrame();
        this.victoryScreen.setTitle("Victory!");
        this.victoryScreen.setLayout(null);
        this.victoryScreen.add(this.victory);
        this.victoryScreen.setSize(this.FRAME_WIDTH,this.FRAME_HEIGHT);
        this.victoryScreen.setLocationRelativeTo(null);
        this.victoryScreen.setResizable(false);
        this.victoryScreen.setUndecorated(true);
        this.victoryScreen.setVisible(true);
    }

    class ContinueButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(count==2) {
                new SecondLevel();
                GameScene_1.gameScene.dispose();
                victoryScreen.dispose();
                System.out.println(count);
            }
            else if(count==3) {
                new ThirdLevel();
                GameScene_1.gameScene.dispose();
                GameScene_2.gameScene.dispose();
                victoryScreen.dispose();
                System.out.println(count);
            }
            else if(count==4) {
                new FourthLevel();
                GameScene_1.gameScene.dispose();
                GameScene_2.gameScene.dispose();
                GameScene_3.gameScene.dispose();
                victoryScreen.dispose();
                System.out.println(count);
            }
            else if(count==5) {
                new FifthLevel();
                GameScene_1.gameScene.dispose();
                GameScene_2.gameScene.dispose();
                GameScene_3.gameScene.dispose();
                GameScene_4.gameScene.dispose();
                victoryScreen.dispose();
                System.out.println(count);
            }
            else if(count==6) {
                new SixthLevel();
                GameScene_1.gameScene.dispose();
                GameScene_2.gameScene.dispose();
                GameScene_3.gameScene.dispose();
                GameScene_4.gameScene.dispose();
                GameScene_5.gameScene.dispose();
                victoryScreen.dispose();
                System.out.println(count);
            }
        }
    }

    class BackToMenuButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            new MainMenu();
            victoryScreen.dispose();
            GameScene_1.gameScene.dispose();
            Victory.count = 1;
        }
    }
}