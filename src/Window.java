import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements Runnable {
    private Graphics2D g2;
    private ButtonListener keyListener = new ButtonListener();

    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(600, 300);
        this.addKeyListener(keyListener);
        g2 = (Graphics2D) this.getGraphics();
    }

    /**
     * Method updates frame per second
     *
     * @param dt is a update frequency frame
     */
    public void update(double dt) {
        g2.setColor(Color.GRAY);
        g2.fillRect(0,0,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
        if (keyListener.isKeyPressed(KeyEvent.VK_UP)){

        }else if(keyListener.isKeyPressed(KeyEvent.VK_DOWN)){

        }
    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;
        while (true) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;
            update(deltaTime);

        }
    }
}
