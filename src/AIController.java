public class AIController {
    private PlayerController playerController;
    private Rect ball;

    public AIController(PlayerController plrController, Rect ball) {
        this.playerController = plrController;
        this.ball = ball;
    }
    public void update(double dt){
//        playerController.update(dt);
        if(ball.y<playerController.getRect().y){
            playerController.moveUp(dt);
        }else if (ball.y+ball.height>playerController.getRect().height){
            playerController.moveDown(dt);
        }
    }
}
