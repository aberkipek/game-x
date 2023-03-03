package level;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {
    private JFrame mainMenu;
    private JButton play;
    private JButton quit;
    private JLabel background;
    private ImageIcon backgroundImage;
    private final int FRAME_WIDTH = 700;
    private final int FRAME_HEIGHT = 700;
    public MainMenu() {
        createMainMenu();
    }
    private void createMainMenu() {
        this.backgroundImage = new ImageIcon("assets\\game\\gameX.png");
        this.background = new JLabel(backgroundImage);
        this.background.setBounds(0,0,700,700);

        this.play = new JButton("PLAY");
        this.play.setBounds(250,300,200,50);
        this.play.setFont(new Font("Monospaced",Font.BOLD, 40));
        this.play.setBackground(Color.ORANGE);
        this.play.setForeground(Color.BLACK);
        this.play.setFocusable(false);
        ActionListener playClick = new PlayButton();
        this.play.addActionListener(playClick);

        this.quit = new JButton("QUIT");
        this.quit.setBounds(250,370,200,50);
        this.quit.setFont(new Font("Monospaced",Font.BOLD, 40));
        this.quit.setBackground(Color.ORANGE);
        this.quit.setForeground(Color.BLACK);
        this.quit.setFocusable(false);
        ActionListener quitClick = new ExitButton();
        this.quit.addActionListener(quitClick);

        this.mainMenu = new JFrame();
        this.mainMenu.setTitle("Main Menu");
        this.mainMenu.setLayout(null);
        this.mainMenu.add(this.play);
        this.mainMenu.add(this.quit);
        this.mainMenu.add(this.background);
        this.mainMenu.setSize(this.FRAME_WIDTH,this.FRAME_HEIGHT);
        this.mainMenu.setLocationRelativeTo(null);
        this.mainMenu.setResizable(false);
        this.mainMenu.setUndecorated(true);
        this.mainMenu.setVisible(true);
    }
    class PlayButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            new GamePrep();
            mainMenu.dispose();
        }
    }
    class ExitButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }
}