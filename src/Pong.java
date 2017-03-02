import Interfaces.MovableRepresentable;
import Interfaces.RepresentableFactory;
import KeyboardController.KeyboardController;
import gameObjects.*;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public class Pong {

    private GameObject test;
    private GameObject paddle;
    private GameObject AIpaddle;
    private GameObject ball;
    private KeyboardController cenas;
    double ballSpeedX;
    double ballSpeedY;
    int paddleSpeed;
    int counter;


    public void init(RepresentableFactory representableFactory){


        //create field
        test = new GameObjectFactory(representableFactory).createGameObject(GameObjectType.FIELD);

        //create the human paddle
        paddle = new GameObjectFactory(representableFactory).createGameObject(GameObjectType.PADDLE);

        //create the AI paddle and change its location
        AIpaddle = new GameObjectFactory(representableFactory).createGameObject(GameObjectType.AIPADDLE);


        ball = new GameObjectFactory(representableFactory).createGameObject(GameObjectType.BALL);


        cenas = new KeyboardController(((Paddle)paddle), ((Field) test));

        ballSpeedY = ((Ball)ball).getBallSpeed();
        ballSpeedX = ((Ball)ball).getBallSpeed();
        paddleSpeed = ((Paddle)paddle).getPaddleSpeed();

    }


    public void start(){


        checkCollisions(paddle);
        checkCollisionsAIPaddle(AIpaddle);
        setBallY();
        ((MovableGameObject) ball).move(ballSpeedX,ballSpeedY);
        moveAIPaddle();



    }


    public void setBallY(){

        int fieldWidth = test.getRepresentable().getWidth();
        int fieldHeigth =  test.getRepresentable().getHeigth();



        double currentBallX = ball.getRepresentable().getX()+ball.getRepresentable().getWidth();
        double currentBallY = ball.getRepresentable().getY()+ball.getRepresentable().getHeigth()/2;




        //System.out.println("ball true y: " + ball.getRepresentable().getY());
        //System.out.println("ball y : " + currentBallY);
        //System.out.println("ball x: " + currentBallX);


        //TODO don't need left and right limits, its the paddle. Set ball speed to zero when it reaches them

        if (currentBallY >= fieldHeigth || currentBallY < ball.getRepresentable().getHeigth()) { //field down limit
            ballSpeedY = -ballSpeedY;
            return;
        }

        //this needs to be removed, just here for testing
        /*if(currentBallX >= fieldWidth){ // right limit

            ballSpeedX = -ballSpeedX;
        }*/


    }

    public void checkCollisions(GameObject paddle){

        double currentBallX = ball.getRepresentable().getX()+ball.getRepresentable().getWidth()/2;

        double paddleX = paddle.getRepresentable().getX()+paddle.getRepresentable().getWidth();




        if (currentBallX <= paddleX){


            /**
             * basically this is the distance to the center of the paddle, relative to the point where the paddle
             * is hitting the ball
             */
            double currentBallY = ball.getRepresentable().getY()+ball.getRepresentable().getHeigth()/2;
            double relativeIntersect = (paddle.getRepresentable().getY()+(paddle.getRepresentable().getHeigth()/2))-currentBallY;

            double normalizedRelativeIntersect = (relativeIntersect/(paddle.getRepresentable().getHeigth()/2));

            int maxBounceAngle = 75;

            double bounceAngle = normalizedRelativeIntersect * maxBounceAngle;


            double MaxBounceAngleRads =  Math.toRadians(bounceAngle);


            ballSpeedX = 3*(Math.cos(MaxBounceAngleRads));
            ballSpeedY = 3* -(Math.sin(MaxBounceAngleRads));


        }

    }

    public void checkCollisionsAIPaddle(GameObject paddle) {

        double currentBallX = ball.getRepresentable().getX() + ball.getRepresentable().getWidth();

        double paddleX = paddle.getRepresentable().getX();



        if (currentBallX >= paddleX) {

            /**
             * basically this is the distance to the center of the paddle, relative to the point where the paddle
             * is hitting the ball
             */
            double currentBallY = ball.getRepresentable().getY() + ball.getRepresentable().getHeigth() / 2;
            double relativeIntersect = (paddle.getRepresentable().getY() + (paddle.getRepresentable().getHeigth() / 2)) - currentBallY;

            double normalizedRelativeIntersect = (relativeIntersect / (paddle.getRepresentable().getHeigth() / 2));

            int maxBounceAngle = 50;

            double bounceAngle = normalizedRelativeIntersect * maxBounceAngle;


            double MaxBounceAngleRads = Math.toRadians(bounceAngle);


            ballSpeedX = -(3 * (Math.cos(MaxBounceAngleRads)));
            ballSpeedY = 3 * -(Math.sin(MaxBounceAngleRads));


        }
    }

    public void moveAIPaddle(){

        double AIpaddleCenterY = (AIpaddle.getRepresentable().getY()+(AIpaddle.getRepresentable().getHeigth()/2));
        double AIpaddleBottomY = AIpaddle.getRepresentable().getY()+AIpaddle.getRepresentable().getHeigth();
        double AIpaddleTopY = AIpaddle.getRepresentable().getY();

        System.out.println("Field heigth"+test.getRepresentable().getHeigth());
        System.out.println("Current ball Y" + ball.getRepresentable().getY());
        System.out.println(ball.getRepresentable().getHeigth());
        System.out.println(test.getRepresentable().getHeigth()-ball.getRepresentable().getHeigth());


        //If bottom field limit move up
        if (((int)ball.getRepresentable().getY() >= (test.getRepresentable().getHeigth()-ball.getRepresentable().getHeigth()))){
            ((MovableGameObject)AIpaddle).move(0, 0);
            System.out.println("------HERE-------");
            return;
        }

       //if paddle is in upper field limit down
        if (AIpaddle.getRepresentable().getY() == 0){
            ((MovableGameObject)AIpaddle).move(0, 1);
            return;
        }


//        if (ball.getRepresentable().getY()+ball.getRepresentable().getHeigth()/2 < AIpaddleBottomY && ball.getRepresentable().getY()+ball.getRepresentable().getHeigth()/2 > AIpaddleTopY){
//            return;
//        }


        //        do not move if the center of the ball is not far enough from the center of the paddlea
        if (Math.abs(((int)ball.getRepresentable().getY()+ball.getRepresentable().getHeigth()/2) - AIpaddleCenterY) <=10){
            return;
        }

        //below center
        if (((int)ball.getRepresentable().getY()+ball.getRepresentable().getHeigth()/2) > AIpaddleCenterY){
            ((MovableGameObject)AIpaddle).move(0, 3);

        //above center
        } else{
            ((MovableGameObject)AIpaddle).move(0, -3);
        }


    }

}






