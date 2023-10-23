import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements Runnable {
    private Graphics2D g2;
    private ButtonListener keyListener = new ButtonListener();
    Rect player;
    Rect ai;
    Rect ball;

    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(600, 300);
        this.addKeyListener(keyListener);
        g2 = (Graphics2D) this.getGraphics();
        player = new Rect(Constants.HZ_PADDING,40,Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT,Constants.PADDLE_COLOR);
        ai = new Rect(Constants.SCREEN_WIDTH-Constants.PADDLE_WIDTH-Constants.HZ_PADDING,40,Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT,Constants.PADDLE_COLOR);
        ball = new Rect(Constants.SCREEN_WIDTH/2,Constants.SCREEN_HEIGHT/2,Constants.BALL_SIZE,Constants.BALL_SIZE,Color.RED);
    }

    /**
     * Method updates frame per second
     *
     * @param dt is a update frequency frame
     */
    public void update(double dt) {
        g2.setColor(Color.GRAY);
        g2.fillRect(0,0,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
        player.draw(g2);
        ai.draw(g2);
        ball.draw(g2);
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
