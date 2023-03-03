package status;

import character.Hero;
import level.GamePrep;
import level.MainMenu;
import game.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Defeat {
    private JFrame defeatScreen;
    private JPanel defeat;
    private JLabel youLost;
    private JButton backToMenuButton;
    private JButton tryAgainButton;
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 300;

    public Defeat() {
        createDefeatScreen();
        Hero.turn = 1; // Enemy.turn = 1;
    }

    private void createDefeatScreen() {
        this.youLost = new JLabel("DEFEAT!");
        this.youLost.setFont(new Font("Arial",Font.BOLD, 80));
        this.youLost.setBounds(75,25,400,100);
        this.youLost.setForeground(Color.WHITE);

        this.backToMenuButton = new JButton("RETURN TO MAIN MENU");
        this.backToMenuButton.setBounds(100,210,300,40);
        this.backToMenuButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.backToMenuButton.setBackground(Color.RED);
        this.backToMenuButton.setForeground(Color.WHITE);
        this.backToMenuButton.setFocusable(false);
        ActionListener backButtonClick = new BackToMenuButton();
        this.backToMenuButton.addActionListener(backButtonClick);

        this.tryAgainButton = new JButton("TRY AGAIN");
        this.tryAgainButton.setBounds(100,150,300,40);
        this.tryAgainButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.tryAgainButton.setBackground(Color.RED);
        this.tryAgainButton.setForeground(Color.WHITE);
        this.tryAgainButton.setFocusable(false);
        ActionListener tryAgainClick = new TryAgainButton();
        this.tryAgainButton.addActionListener(tryAgainClick);

        this.defeat = new JPanel();
        this.defeat.setBounds(0,0,500,350);
        this.defeat.setBackground(Color.BLACK);
        this.defeat.setLayout(null);
        this.defeat.add(this.backToMenuButton);
        this.defeat.add(this.tryAgainButton);
        this.defeat.add(this.youLost);

        this.defeatScreen = new JFrame();
        this.defeatScreen.setTitle("Game Over!");
        this.defeatScreen.setLayout(null);
        this.defeatScreen.add(this.defeat);
        this.defeatScreen.setSize(this.FRAME_WIDTH,this.FRAME_HEIGHT);
        this.defeatScreen.setLocationRelativeTo(null);
        this.defeatScreen.setResizable(false);
        this.defeatScreen.setUndecorated(true);
        this.defeatScreen.setVisible(true);
    }

    class TryAgainButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(Victory.count==1) {
                GameScene_1.gameScene.dispose();
                new GameScene_1(GamePrep.selectedImage);
                defeatScreen.dispose();
            }
            else if(Victory.count==2) {
                GameScene_2.gameScene.dispose();
                new GameScene_2(GamePrep.selectedImage);
                defeatScreen.dispose();
            }
            else if(Victory.count==3) {
                GameScene_3.gameScene.dispose();
                new GameScene_3(GamePrep.selectedImage);
                defeatScreen.dispose();
            }
            else if(Victory.count==4) {
                GameScene_4.gameScene.dispose();
                new GameScene_4(GamePrep.selectedImage);
                defeatScreen.dispose();
            }
            else if(Victory.count==5) {
                GameScene_5.gameScene.dispose();
                new GameScene_5(GamePrep.selectedImage);
                defeatScreen.dispose();
            }
            else if(Victory.count==6) {
                GameScene_6.gameScene.dispose();
                new GameScene_6(GamePrep.selectedImage);
                defeatScreen.dispose();
            }
        }
    }

    class BackToMenuButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            new MainMenu();
            defeatScreen.dispose();
            Victory.count = 1;
        }
    }
}