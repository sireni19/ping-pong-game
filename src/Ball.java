public class Ball {

    private Rect body;
    private Rect leftPaddle;
    private Rect rightPaddle;
    //velocity x,y
    private double vy = 400.0;
    private double vx = -150.0;

    public Rect getBody() {
        return body;
    }


    public Ball(Rect rect, Rect leftPaddle, Rect rightPaddle) {
        this.body = rect;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    public void update(double dt) {
        if (vx < 0) {
            //case when ball(rect) touches left paddle
            if (this.body.x <= this.leftPaddle.x + this.leftPaddle.width && this.body.x + this.body.width >= this.leftPaddle.x &&
                    this.body.y >= this.leftPaddle.y && this.body.y <= this.leftPaddle.y + this.leftPaddle.height) {
                this.vx *= -1;
                this.vy *= -1;
            }else if(this.body.x+ this.body.width<this.leftPaddle.x){
                System.out.println("Player has lost");
            }
        } else if (vx > 0) {
            //case when ball(rect) touches right paddle
            if (this.body.x + this.body.width >= this.rightPaddle.x && this.body.x <= this.rightPaddle.x + this.rightPaddle.width &&
                    this.body.y >= this.rightPaddle.y && this.body.y <= this.rightPaddle.y + this.rightPaddle.height) {
                this.vx *= -1;
                this.vy *= -1;
            }else if(this.body.x+this.body.width>this.rightPaddle.x+this.rightPaddle.width){
                System.out.println("AI has lost");
            }
        }
        if (vy>0){
            //case when ball(rect) touches bottom border
            if(this.body.y+this.body.height>Constants.SCREEN_HEIGHT){
                this.vy*=-1;
            }
        }else if (vy<0) {
            //case when ball(rect) touches top border
            if(this.body.y<Constants.TOOLBAR_HEIGHT){
                this.vy*=-1;
            }
        }
        //position = position+ velocity
        //velocity = velocity + acceleration
        this.body.x += vx * dt;
        this.body.y += vy * dt;


    }
}
