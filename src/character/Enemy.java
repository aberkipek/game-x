package character;

import level.GamePrep;
import status.Defeat;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Enemy extends Character {
    public Enemy(int health) {
        this.health = health;
        turn = 1;
        createHealthStatus();
    }

    public void createHealthBar() {
        this.healthPanel = new JPanel();
        this.healthPanel.setBounds(0,0,this.health,30);
        this.healthPanel.setBackground(Color.GREEN);

        this.healthBarPanel = new JPanel();
        this.healthBarPanel.setBounds(590- this.health,40,this.health,30);
        this.healthBarPanel.setBackground(Color.BLACK);
        this.healthBarPanel.setLayout(null);
        this.healthBarPanel.add(this.healthPanel);
    }

    public void createProfile(ImageIcon img) {
        this.enemyAvatar = img;
        this.profile = new JLabel(this.enemyAvatar);
        this.profile.setBounds(610,40,50,50);

        this.username = new JLabel("Enemy");
        this.username.setBounds(610,100,100,15);
        this.username.setFont(new Font("Arial",Font.BOLD, 15));
        this.username.setForeground(Color.RED);
    }

    public void createHealthStatus() {
        this.sHealth = "Health: ";
        this.sHealth += Integer.toString(this.health);

        this.healthStatus = new JLabel(this.sHealth);
        this.healthStatus.setFont(new Font("Arial",Font.BOLD, 15));
        this.healthStatus.setBounds(590-this.health,75,100,20);
        this.healthStatus.setForeground(Color.BLACK);
    }

    public void setHealthStatus() {
        this.sHealth = "Health: ";
        this.sHealth += Integer.toString(this.health);
        this.healthStatus.setText(this.sHealth);
    }

    // TODO implement attackAnimation() method
    // public void attackAnimation() {}

    public void attack(Hero h) {
        if(turn%2==0) {
            turn++;
            if(h.health > 0 && this.health != 0) {
                int n = (int)(Math.random()*3+1);

                if(n==1)
                    h.health -= 5;

                else if(n==2)
                    h.health -= 10;

                else if(n==3)
                    h.health -= 15;

                //h.health -= (int)(Math.random()*15+1);
                h.setHealthStatus();
                h.healthPanel.setBounds(0,0,h.health,30);

                if(h.health > 160 && h.health <= 200)
                    h.healthPanel.setBackground(Color.GREEN);

                else if(h.health > 120 && h.health <= 160)
                    h.healthPanel.setBackground(LIGHT_GREEN);

                else if(h.health > 80 && h.health <= 120)
                    h.healthPanel.setBackground(LIGHT_YELLOW);

                else if(h.health > 60 && h.health <= 80)
                    h.healthPanel.setBackground(Color.YELLOW);

                else if(h.health > 40 && h.health <= 60)
                    h.healthPanel.setBackground(Color.ORANGE);

                else if(h.health > 20 && h.health <= 40)
                    h.healthPanel.setBackground(DARK_ORANGE);

                else if(h.health > 0 && h.health <= 20)
                    h.healthPanel.setBackground(Color.RED);

                else if(h.health <= 0)
                    new Defeat();

            }
        }
    }
}