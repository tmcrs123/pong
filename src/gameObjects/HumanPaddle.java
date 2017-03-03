package gameObjects;

import Interfaces.MovableRepresentable;

/**
 * Created by tiagoRodrigues on 02/03/2017.
 */
public class HumanPaddle extends MovableGameObject {

    private int paddleSpeed = 2;

    public HumanPaddle(MovableRepresentable representable) {
        super(representable);
    }

    public int getPaddleSpeed() {
        return paddleSpeed;
    }

    public void setPaddleSpeed(int paddleSpeed) {
        this.paddleSpeed = paddleSpeed;
    }




}
