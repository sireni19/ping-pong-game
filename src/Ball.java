public class Ball {

    private Rect body;
    private Rect leftPaddle;
    private Rect rightPaddle;
    //velocity x,y
    private double vy = 10.0;
    private double vx = -200.0;

    public Rect getBody() {
        return body;
    }


    public Ball(Rect rect, Rect leftPaddle, Rect rightPaddle) {
        this.body = rect;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    public double calculateNewVelocityAngle(Rect paddle) {
        double relativeIntersectY = (paddle.y + (paddle.height / 2.0)) - (this.body.y + (this.body.height) / 2.0);
        double normalIntersect = relativeIntersectY / (paddle.height / 2.0);
        double theta = normalIntersect * Constants.MAX_ANGLE;
        return theta;
    }

    public void update(double dt) {

        double dX = vx * dt;
        double dY = vy * dt;
        if (vy >= 0.0) {
            //case when ball(rect) touches bottom border
            if (this.body.y + this.body.height + dY > Constants.SCREEN_HEIGHT - Constants.INSETS_BOTTOM) {
                this.vy *= -1.0;
            }
        } else if (vy < 0.0) {
            //case when ball(rect) touches top border
            if (this.body.y + dY < Constants.TOOLBAR_HEIGHT) {
                this.vy *= -1.0;
            }
        }

        if (vx < 0.0) {
            //case when ball(rect) touches left paddle
            if (this.body.x + dX < leftPaddle.x + leftPaddle.width) {
                if (this.body.y + dY > leftPaddle.y &&
                        this.body.y + dY + this.body.height < leftPaddle.y + leftPaddle.height) {
                    double theta = calculateNewVelocityAngle(leftPaddle);
                    double newVx = Math.abs((Math.cos(theta)) * Constants.BALL_SPEED);
                    double newVy = (-Math.sin(theta)) * Constants.BALL_SPEED;

                    double oldSign = Math.signum(vx);
                    this.vx = newVx * (oldSign * -1.0);
                    this.vy = newVy;
                }
            }
        } else if (vx >= 0.0) {
            //case when ball(rect) touches right paddle
            if (this.body.x + dX + this.body.width >= this.rightPaddle.x) {
                if (this.body.y + dY > this.rightPaddle.y &&
                        this.body.y + dY + this.body.height < this.rightPaddle.y + this.rightPaddle.height) {
                    double theta = calculateNewVelocityAngle(rightPaddle);
                    double newVx = Math.abs((Math.cos(theta)) * Constants.BALL_SPEED);
                    double newVy = (-Math.sin(theta)) * Constants.BALL_SPEED;

                    double oldSign = Math.signum(vx);
                    this.vx = newVx * (oldSign * -1.0);
                    this.vy = newVy;
                }
            }
        }

        //position = position+ velocity
        //velocity = velocity + acceleration
        this.body.y += dY;
        this.body.x += dX;


    }
}
