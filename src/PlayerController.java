
import lombok.Data;

import java.awt.event.KeyEvent;

@Data
public class PlayerController  {
    private Rect rect;
    private ButtonListener keyListener;

    public PlayerController(Rect rect, ButtonListener keyListener) {
        this.rect = rect;
        this.keyListener = keyListener;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public ButtonListener getKeyListener() {
        return keyListener;
    }

    public void setKeyListener(ButtonListener keyListener) {
        this.keyListener = keyListener;
    }

    //AI does not need keyController, so program understands: if keylistener=null it means AI
    public PlayerController(Rect rect) {
        this.rect = rect;
        this.keyListener=null;
    }

    public void update(double dt) {
        if (keyListener!=null) {
            if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
                moveDown(dt);
            } else if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
                moveUp(dt);
            }
        }
    }
    void moveDown(double dt) {
        if (((rect.y + Constants.PADDLE_SPEED * dt) + rect.height)< Constants.SCREEN_HEIGHT-Constants.INSETS_BOTTOM)
            rect.y += Constants.PADDLE_SPEED * dt;
    }
    void moveUp(double dt) {
        if (rect.y - Constants.PADDLE_SPEED * dt > Constants.TOOLBAR_HEIGHT)
            rect.y -= Constants.PADDLE_SPEED * dt;
    }

}
