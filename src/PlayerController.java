import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.event.KeyEvent;

@Data

public class PlayerController {
    private Rect rect;
    private ButtonListener keyListener;

    public PlayerController(Rect rect, ButtonListener keyListener) {
        this.rect = rect;
        this.keyListener = keyListener;
    }

    public void update(double dt) {
        if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
            if (((rect.y + Constants.PADDLE_SPEED * dt) + rect.height)< Constants.SCREEN_HEIGHT-Constants.INSETS_BOTTOM)
                rect.y += Constants.PADDLE_SPEED * dt;
        } else if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
            if (rect.y - Constants.PADDLE_SPEED * dt > Constants.TOOLBAR_HEIGHT)
                rect.y -= Constants.PADDLE_SPEED * dt;
        }
    }
}
