import Interfaces.RepresentableFactory;
import Interfaces.VerticalRepresentable;
import KeyboardController.KeyboardController;
import gameObjects.*;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public class Pong {

    private GameObject field;
    private GameObject humanPaddle;
    private GameObject AIpaddle;
    private GameObject ball;
    private KeyboardController cenas;
    public static int fieldHeigth;
    double ballSpeedX;
    double ballSpeedY;
    int paddleSpeed;


    public void init(RepresentableFactory representableFactory){


        //create field
        field = new GameObjectFactory(representableFactory).createGameObject(GameObjectType.FIELD);
        fieldHeigth = field.getRepresentable().getHeigth();

        //create the human humanPaddle
        humanPaddle = new GameObjectFactory(representableFactory).createGameObject(GameObjectType.HUMANPADDLE);

        //create the AI humanPaddle and change its location
        AIpaddle = new GameObjectFactory(representableFactory).createGameObject(GameObjectType.AIPADDLE);


        ball = new GameObjectFactory(representableFactory).createGameObject(GameObjectType.BALL);


        cenas = new KeyboardController(((HumanPaddle) humanPaddle), ((Field) field));

        ballSpeedY = ((Ball)ball).getBallSpeed();
        ballSpeedX = ((Ball)ball).getBallSpeed();
        paddleSpeed = ((HumanPaddle) humanPaddle).getPaddleSpeed();

    }


    public void start(){



        checkCollisions(humanPaddle);
        checkCollisionsAIPaddle(AIpaddle);
        setBallY();
        ((MovableGameObject) ball).move(ballSpeedX,ballSpeedY);
        checkfieldLimits();
        moveAIPaddle();
        ((HumanPaddle)humanPaddle).move(0,paddleSpeed);



    }


    public void setBallY(){

        int fieldHeigth =  field.getRepresentable().getHeigth();


        double currentBallY = ball.getRepresentable().getY()+ball.getRepresentable().getHeigth()/2;




        //TODO don't need left and right limits, its the humanPaddle. Set ball speed to zero when it reaches them

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
             * basically this is the distance to the center of the humanPaddle, relative to the point where the humanPaddle
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
             * basically this is the distance to the center of the humanPaddle, relative to the point where the humanPaddle
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

//        System.out.println("Field heigth"+ field.getRepresentable().getHeigth());
//        System.out.println("Current ball Y" + ball.getRepresentable().getY());
//        System.out.println(ball.getRepresentable().getHeigth());
//        System.out.println(field.getRepresentable().getHeigth()-ball.getRepresentable().getHeigth());


        if (AIpaddleBottomY > fieldHeigth){
            ((MovableGameObject)AIpaddle).move(0, 0);
            return;
        }

        //If bottom field limit move up
        if (((int)ball.getRepresentable().getY() >= (field.getRepresentable().getHeigth()-ball.getRepresentable().getHeigth()))){
            ((MovableGameObject)AIpaddle).move(0, 0);
            return;
        }

       //if humanPaddle is in upper field limit down
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

    public void checkfieldLimits(){

        //System.out.println(humanPaddle.getPositionY());


        if (humanPaddle.getRepresentable().getY()<0){
            ((VerticalRepresentable)humanPaddle.getRepresentable()).setMovingUp(false);
        }

        if (humanPaddle.getRepresentable().getY()+humanPaddle.getRepresentable().getHeigth()>fieldHeigth){
            ((VerticalRepresentable)humanPaddle.getRepresentable()).setMovingDown(false);
        }

        ((HumanPaddle)humanPaddle).move(0,paddleSpeed);
    }

}






