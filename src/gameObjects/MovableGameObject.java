package gameObjects;

import Interfaces.MovableRepresentable;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public abstract class MovableGameObject extends GameObject {


    public MovableGameObject(MovableRepresentable representable) {
        super(representable);
    }

    public void move(double dx , double dy){
        ((MovableRepresentable) getRepresentable()).move(dx , dy);

    }
}
