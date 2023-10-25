import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.awt.*;

public class Text {
    private String text;
    private Font font;
    private double x,y;

    public Text(String text, Font font, double x, double y) {
        this.text = text;
        this.font = font;
        this.x = x;
        this.y = y;
    }
    public Text(int text, Font font, double x, double y) {
        this.text = text+"";
        this.font = font;
        this.x = x;
        this.y = y;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.YELLOW);
        g2.setFont(font);
        g2.drawString(text, (float) x, (float) y);
    }
}
