package status;

import game.GameScene_6;
import level.MainMenu;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class End {
    private JFrame victoryScreen;
    private JPanel victory;
    private JLabel youWon;
    private JButton backToMenuButton;
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 300;

    public End() {
        createVictoryScreen();
        character.Hero.turn = 1;
    }

    private void createVictoryScreen() {
        this.victory = new JPanel();
        this.victory.setBounds(0,0,500,350);
        this.victory.setBackground(Color.BLACK);
        this.victory.setLayout(null);

        this.youWon = new JLabel("UNDEFEATED!");
        this.youWon.setFont(new Font("Arial",Font.BOLD, 55));
        this.youWon.setBounds(60,50,400,100);
        this.youWon.setForeground(Color.WHITE);

        this.backToMenuButton = new JButton("RETURN TO MAIN MENU");
        this.backToMenuButton.setBounds(100,180,300,40);
        this.backToMenuButton.setFont(new Font("Arial",Font.BOLD, 20));
        this.backToMenuButton.setBackground(Color.RED);
        this.backToMenuButton.setForeground(Color.WHITE);
        this.backToMenuButton.setFocusable(false);
        ActionListener backButtonClick = new BackToMenuButton();
        this.backToMenuButton.addActionListener(backButtonClick);

        this.victory.add(this.youWon);
        this.victory.add(this.backToMenuButton);

        this.victoryScreen = new JFrame();
        this.victoryScreen.setTitle("Congratulations!");
        this.victoryScreen.setLayout(null);
        this.victoryScreen.add(this.victory);
        this.victoryScreen.setSize(this.FRAME_WIDTH,this.FRAME_HEIGHT);
        this.victoryScreen.setLocationRelativeTo(null);
        this.victoryScreen.setResizable(false);
        this.victoryScreen.setUndecorated(true);
        this.victoryScreen.setVisible(true);
    }

    class BackToMenuButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            new MainMenu();
            GameScene_6.gameScene.dispose();
            victoryScreen.dispose();
            System.out.println(Victory.count);
            Victory.count = 1;
        }
    }
}