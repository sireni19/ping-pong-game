import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {

    public Window() {
        this.setSize(Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLocation(600,300);
    }

    @Override
    public void run() {
        while (true) {

        }
    }
}
