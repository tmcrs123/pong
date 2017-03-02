package SimpleGFX;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by tiagoRodrigues on 02/03/2017.
 */
public class SimpleGFXHumanPaddle extends SimpleGFXMovableRepresentable{

    private boolean movingUp;
    private boolean movingDown;

    public SimpleGFXHumanPaddle(int x, int y, int width, int height) {
        super(new Rectangle(x, y, width, height));
        ((Rectangle) this.getShape()).fill();
        ((Rectangle) this.getShape()).setColor(Color.WHITE);
        this.setPosX(x);
        this.setPosY(y);
        this.width = width;
        this.heigth = height;
    }

    @Override
    public void move(double dx, double dy) {

    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }
}
