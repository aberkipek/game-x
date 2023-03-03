package character;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;

abstract class Character {
    public int health;
    public static int turn; // determines whose turn it is
    public static long currentTime;
    public JLabel healthStatus; // contains sHealth
    public JLabel profile; // hero and enemy profile for the game scene

    public JLabel username; // hero and enemy username for the game scene
    public ImageIcon heroAvatar; // hero avatar for the game scene
    public ImageIcon enemyAvatar; // enemy avatar for the game scene
    public String sHealth; // stores the remaining health
    public JPanel healthBarPanel; // contains healthPanel
    public JPanel healthPanel; // creates the health panel which is placed inside the healthBarPanel
    public JButton attackButton;
    protected final Color LIGHT_GREEN = new Color(102,255,102); // colors for Health Bar
    protected final Color LIGHT_YELLOW = new Color(255,255,153);
    protected final Color DARK_ORANGE = new Color(255,102,0);
    protected abstract void createHealthBar(); // shows health bar on the screen
    protected abstract void createHealthStatus(); // shows health status on the screen
    protected abstract void setHealthStatus(); // sets the health status

    //protected abstract void attackAnimation();
}