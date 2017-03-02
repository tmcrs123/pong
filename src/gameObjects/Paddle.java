package gameObjects;

import Interfaces.MovableRepresentable;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public class Paddle extends MovableGameObject{

    private int paddleSpeed = 20;

    public Paddle(MovableRepresentable representable) {
        super(representable);
    }

    public int getPaddleSpeed() {
        return paddleSpeed;
    }

    public void setPaddleSpeed(int paddleSpeed) {
        this.paddleSpeed = paddleSpeed;
    }
}
