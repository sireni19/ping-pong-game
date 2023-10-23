import java.awt.*;

public class Rect {
    private int x, y, width, height;
    private Color color;


    public Rect(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Using this method a rectangle will draw himself
     * @param g2 is the instrument for drawing
     */
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x,y,width,height);
    }
}
