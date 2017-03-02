package SimpleGFX;

import Interfaces.Representable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public abstract class SimpleGFXRepresentable implements Representable {

    public double posX;
    public double posY;
    public int width;
    public int heigth;

    private Shape shape;

    public Shape getShape() {
        return shape;
    }


    public SimpleGFXRepresentable(Shape shape) {
        this.shape = shape;
        shape.draw();
    }

    public double getX() {
        return posX;
    }


    public double getY() {
        return posY;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }
}



