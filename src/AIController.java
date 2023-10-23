public class AIController extends Controller {
    private Rect rect;
    private Ball ball;

    public AIController(Rect rect, Ball ball) {
        this.rect = rect;
        this.ball = ball;
    }

    @Override
    public void update(double dt){
        if(ball.getBody().y<rect.y){
           moveUp(dt,this.rect);
        }else if (ball.getBody().y+ball.getBody().height>rect.height){
            moveDown(dt,this.rect);
        }
    }
}
