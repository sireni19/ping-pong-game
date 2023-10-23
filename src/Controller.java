public abstract class Controller {

    void moveDown(double dt,Rect rect) {
        if (((rect.y + Constants.PADDLE_SPEED * dt) + rect.height)< Constants.SCREEN_HEIGHT-Constants.INSETS_BOTTOM)
            rect.y += Constants.PADDLE_SPEED * dt;
    }
    void moveUp(double dt,Rect rect) {
        if (rect.y - Constants.PADDLE_SPEED * dt > Constants.TOOLBAR_HEIGHT)
            rect.y -= Constants.PADDLE_SPEED * dt;
    }
    public  abstract void  update (double dt);
}
