import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements Runnable {
    private Graphics2D g2;
    private ButtonListener keyListener = new ButtonListener();
    private Rect player;
    private Rect ai;
    private Rect ball;
    private PlayerController playerController;

    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(600, 300);
        this.addKeyListener(keyListener);
        g2 = (Graphics2D) this.getGraphics();

        player = new Rect(Constants.HZ_PADDING, 40, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        playerController = new PlayerController(player, keyListener);

        ai = new Rect(Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH - Constants.HZ_PADDING, 40, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        ball = new Rect(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2, Constants.BALL_SIZE, Constants.BALL_SIZE, Color.RED);
    }

    /**
     * This method is called to update the state and display the game on each frame.
     * The following happens inside the method:
     * 1. The image (doubleBufferImage) is created with the size equals to the width and height of the frame.
     * The doubleBufferImage image represents the memory into which the graphical elements of the game are drawn.
     * This is a hidden back buffer on which the components of the game
     * (such as the player, artificial intelligence, ball) are drawn.
     *
     * 2. The graphical context (doubleBufferGraphic) is received from the doubleBufferImage image. This is a "tool"
     * with which graphical elements are rendered on doubleBufferGraphic.
     *
     * 3. The draw() method with parameter (doubleBufferGraphic) is called. As a result of calling such a method
     * is:graphical elements of the game will be drawn on the doubleBufferImage, which will then be
     * used to display the image on the screen when calling the g2.drawImage(doubleBufferImage, 0, 0, this) method.
     *
     * 4. After all the components of the game have been rendered by doubleBufferGraphic,
     * the doubleBufferImage image contains the full game scene.
     *
     * 5.Then the g2.drawImage(doubleBufferImage, 0, 0, this) method is called,
     * which displays the contents of the doubleBufferImage image on the graphical context of g2.
     *
     * @param dt is a update frequency frame
     * This is necessary for smooth display without visible flickering.
     * Note: g2 represents the graphical context of the component on which the game is displayed.
     *
     */
    public void update(double dt) {
        Image doubleBufferImage = createImage(getWidth(), getHeight());
        Graphics doubleBufferGraphic = doubleBufferImage.getGraphics();
        this.draw(doubleBufferGraphic);
        g2.drawImage(doubleBufferImage, 0, 0, this);
        playerController.update(dt);
        Constants.TOOLBAR_HEIGHT=this.getInsets().top;//setting the height of the toolbar (toolbar)-> the paddle won`t get into the toolbar
        Constants.INSETS_BOTTOM=this.getInsets().bottom;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
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
