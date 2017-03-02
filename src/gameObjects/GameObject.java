package gameObjects;

import Interfaces.Representable;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public abstract class GameObject {

    double positionX;
    double positionY;

    public Representable representable;

    public GameObject(Representable representable) {
        this.representable = representable;
    }

    public Representable getRepresentable() {
        return representable;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }
}
