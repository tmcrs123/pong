package Interfaces;

/**
 * Created by tiagoRodrigues on 03/03/2017.
 */
public interface VerticalRepresentable extends MovableRepresentable {

    boolean isMovingUp();

    boolean isMovingDown();

    void setMovingUp(boolean up);

    void setMovingDown(boolean down);

}
