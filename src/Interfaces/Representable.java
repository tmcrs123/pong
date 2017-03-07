package Interfaces;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public interface Representable {

    double getX();
    double getY();
    void setPosX(double posX);
    void setPosY(double posY);
    int getWidth();
    int getHeigth();

    //todo check for usage of getX and getY and see if I can replace by child cclass methods PositionXY methods



}
