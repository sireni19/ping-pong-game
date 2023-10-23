
import lombok.Data;

import java.awt.event.KeyEvent;

@Data
public class PlayerController extends Controller {
    private Rect rect;
    private ButtonListener keyListener;

    public PlayerController(Rect rect, ButtonListener keyListener) {
        this.rect = rect;
        this.keyListener = keyListener;
    }

    @Override
    public void update(double dt) {
        if (keyListener != null) {
            if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
                moveDown(dt, this.rect);
            } else if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
                moveUp(dt, this.rect);
            }
        }
    }


}
