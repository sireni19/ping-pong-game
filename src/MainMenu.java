import javax.swing.*;
import java.awt.*;


public class MainMenu extends JFrame implements Runnable {
    private Graphics2D g2;
    private ButtonListener keyListener = new ButtonListener();
    private Text startGame, exitGame, pong;
    private MListener mouseListener = new MListener();
    private boolean isRunning = true;


    public MainMenu() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(600, 300);
        this.addKeyListener(keyListener);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
        this.startGame = new Text("Start Game", new Font("Arial", Font.PLAIN, 40), Constants.SCREEN_WIDTH / 2.0 - 140.0, Constants.SCREEN_HEIGHT / 2.0, Color.YELLOW);
        this.exitGame = new Text("Exit", new Font("Arial", Font.PLAIN, 40), Constants.SCREEN_WIDTH / 2.0 - 80.0, Constants.SCREEN_HEIGHT / 2.0 + 80.0, Color.YELLOW);
        this.pong = new Text("PONG", new Font("Arial", Font.PLAIN, 100), Constants.SCREEN_WIDTH / 2.0 - 160, 120, Color.YELLOW);
        this.g2 = (Graphics2D) getGraphics();
    }

    public void update(double dt) {
        Image doubleBufferImage = createImage(getWidth(), getHeight());
        Graphics doubleBufferGraphic = doubleBufferImage.getGraphics();
        this.draw(doubleBufferGraphic);
        g2.drawImage(doubleBufferImage, 0, 0, this);

        if(mouseListener.isMousePressed()){
            Main.changeState(1);
        }
        if (mouseListener.getMouseX() > startGame.getX() && mouseListener.getMouseX()< startGame.getX()+ startGame.getWidth() &&
                mouseListener.getMouseY() > startGame.getY()-startGame.getHeight()/2.0 && mouseListener.getMouseY() < startGame.getY() + startGame.getHeight()/2.0) {
            startGame.setColor(new Color(255, 0, 0));
        }else {
            startGame.setColor(Color.YELLOW);
        }
        if (mouseListener.getMouseX() > exitGame.getX() && mouseListener.getMouseX()< exitGame.getX()+ exitGame.getWidth() &&
                mouseListener.getMouseY() > exitGame.getY()-exitGame.getHeight()/2.0 && mouseListener.getMouseY() < exitGame.getY() + exitGame.getHeight()/2.0) {

            exitGame.setColor(new Color(255, 0, 0));
        if(mouseListener.isMousePressed()){
            Main.changeState(2);
        }
        }else {
            exitGame.setColor(Color.YELLOW);
        }
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        startGame.draw(g2);
        exitGame.draw(g2);
        pong.draw(g2);
    }
    public void stop(){
        isRunning=false;
    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;
        while (isRunning) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;
            update(deltaTime);
        }
        this.dispose();
        return;
    }
}

