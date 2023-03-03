package character;

import level.GamePrep;
import status.Victory;
import status.End;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Hero extends Character {
    public Hero(int health) {
        this.health = health;
        turn = 1;
        createHealthStatus();
    }

    public void createHealthBar() {
        this.healthPanel = new JPanel();
        this.healthPanel.setBounds(0,0,this.health,30);
        this.healthPanel.setBackground(Color.GREEN);

        this.healthBarPanel = new JPanel();
        this.healthBarPanel.setBounds(110,40,this.health,30);
        this.healthBarPanel.setBackground(Color.BLACK);
        this.healthBarPanel.setLayout(null);
        this.healthBarPanel.add(this.healthPanel);
    }

    public void createProfile(ImageIcon img) {
        this.heroAvatar = img;
        this.profile = new JLabel(this.heroAvatar);
        this.profile.setBounds(40,40,50,50);

        this.username = new JLabel((GamePrep.username.getText()).trim());
        this.username.setBounds(40,100,100,15);
        this.username.setFont(new Font("Arial",Font.BOLD, 15));
        this.username.setForeground(Color.BLUE);
    }

    public void createHealthStatus() {
        this.sHealth = "Health: ";
        this.sHealth += Integer.toString(this.health);

        this.healthStatus = new JLabel(this.sHealth);
        this.healthStatus.setFont(new Font("Arial",Font.BOLD, 15));
        this.healthStatus.setBounds(110,75,100,20);
        this.healthStatus.setForeground(Color.BLACK);
    }

    public void setHealthStatus() {
        if(this.health > 0) {
            this.sHealth = "Health: ";
            this.sHealth += Integer.toString(this.health);
        }

        else {
            this.sHealth = "Health: ";
            this.sHealth += Integer.toString(0);
        }
        this.healthStatus.setText(this.sHealth);
    }

    // TODO implement attackAnimation() method
    // public void attackAnimation() {}

    public void attack(Enemy e) {
        if(turn%2==1) {
            turn++;
            if(e.health > 0 && this.health != 0) {
                e.health -= 10;
                e.setHealthStatus();
                e.healthPanel.setBounds(0,0,e.health, 30);

                if(e.health > 160 && e.health <= 200)
                    e.healthPanel.setBackground(Color.GREEN);

                else if(e.health > 120 && e.health <= 160)
                    e.healthPanel.setBackground(LIGHT_GREEN);

                else if(e.health > 80 && e.health <= 120)
                    e.healthPanel.setBackground(LIGHT_YELLOW);

                else if(e.health > 60 && e.health <= 80)
                    e.healthPanel.setBackground(Color.YELLOW);

                else if(e.health > 40 && e.health <= 60)
                    e.healthPanel.setBackground(Color.ORANGE);

                else if(e.health > 20 && e.health <= 40)
                    e.healthPanel.setBackground(DARK_ORANGE);

                else if(e.health > 0 && e.health <= 20)
                    e.healthPanel.setBackground(Color.RED);

                else if (e.health == 0) {
                    if(Victory.count < 6)
                        new Victory();

                    else
                        new End();
                }
            }
        }
    }
}

