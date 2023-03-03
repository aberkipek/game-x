package game;

import character.Hero;
import character.Enemy;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class GameScene_2 {
    private JFrame tempGameScene;
    public static JFrame gameScene;
    private JLabel background;
    private ImageIcon image;
    private ImageIcon heroAvatar;
    private ImageIcon enemyAvatar;
    private Hero h = new Hero(200);
    private Enemy e = new Enemy(210);
    private final int FRAME_WIDTH = 700;
    private final int FRAME_HEIGHT = 700;

    public GameScene_2(ImageIcon img) {
        this.heroAvatar = img;
        this.enemyAvatar = new ImageIcon("assets\\character\\enemy_1.png");
        createGameScene();
    }
    //public GameScene_2() {
        //createGameScene();
    //}
    private void createGameScene() {
        this.image = new ImageIcon("assets\\scene\\gameSceneBackground_2.png");
        this.background = new JLabel(this.image);
        this.background.setBounds(0,0,700,700);

        this.gameScene = new JFrame();

        this.tempGameScene = new JFrame();
        this.tempGameScene.setLayout(null);
        this.tempGameScene.setTitle("GameX");
        this.tempGameScene.setSize(this.FRAME_WIDTH, this.FRAME_HEIGHT);

        this.gameScene = this.tempGameScene;

        h.createHealthBar();
        this.gameScene.add(h.healthBarPanel);

        this.gameScene.add(h.healthStatus);

        createAttackButton(h);
        this.gameScene.add(h.attackButton);

        e.createHealthBar();
        this.gameScene.add(e.healthBarPanel);

        this.gameScene.add(e.healthStatus);

        createAttackButton(e);
        this.gameScene.add(e.attackButton);

        h.createProfile(this.heroAvatar);
        this.gameScene.add(h.profile);
        this.gameScene.add(h.username);

        e.createProfile(this.enemyAvatar);
        this.gameScene.add(e.profile);
        this.gameScene.add(e.username);

        this.gameScene.add(background);
        this.gameScene.setLocationRelativeTo(null);
        this.gameScene.setResizable(false);
        this.gameScene.setUndecorated(true);
        this.gameScene.setVisible(true);
    }

    private void createAttackButton(Enemy e) {
        e.attackButton = new JButton("ENEMY ATTACK");
        e.attackButton.setBounds(470,600,180,50);
        e.attackButton.setFont(new Font("Monospaced",Font.BOLD,20));
        e.attackButton.setBackground(Color.RED);
        e.attackButton.setForeground(Color.WHITE);
        e.attackButton.setFocusable(false);
        ActionListener enemyAttackClick = new EnemyAttackButton();
        e.attackButton.addActionListener(enemyAttackClick);
    }

    private void createAttackButton(Hero h) {
        h.attackButton = new JButton("HERO ATTACK");
        h.attackButton.setBounds(50,600,180,50);
        h.attackButton.setFont(new Font("Monospaced",Font.BOLD,20));
        h.attackButton.setBackground(Color.BLUE);
        h.attackButton.setForeground(Color.WHITE);
        h.attackButton.setFocusable(false);
        ActionListener heroAttackClick = new HeroAttackButton();
        h.attackButton.addActionListener(heroAttackClick);
    }

    class HeroAttackButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            h.attack(e);
        }
    }

    class EnemyAttackButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            e.attack(h);
        }
    }
}