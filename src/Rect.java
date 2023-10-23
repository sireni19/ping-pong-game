import lombok.Data;

import java.awt.*;
import java.awt.geom.Rectangle2D;

@Data

public class Rect {
    public double x, y, width, height;
    private Color color;


    public Rect(double x, double y, double width, double height, Color color) {
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
        g2.fill(new Rectangle2D.Double(x,y,width,height));
    }
}
