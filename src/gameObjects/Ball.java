package gameObjects;

import Interfaces.MovableRepresentable;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public class Ball extends MovableGameObject  {

    private int ballSpeed = 1;

    public Ball(MovableRepresentable representable) {
        super(representable);
    }


    public int getBallSpeed() {
        return ballSpeed;
    }

    public void setBallSpeed(int ballSpeed) {
        this.ballSpeed = ballSpeed;
    }

    public int incrementBallSpeed(){
        ballSpeed++;
        return ballSpeed;
    }
}
