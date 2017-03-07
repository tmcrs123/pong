package SimpleGFX;

import Interfaces.VerticalRepresentable;
import gameObjects.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by tiagoRodrigues on 02/03/2017.
 */
public class SimpleGFXHumanPaddle extends SimpleGFXMovableRepresentable implements VerticalRepresentable{

    private boolean movingUp = false;
    private boolean movingDown = false;
    private boolean canMoveup;
    private boolean canMovedown;


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

//        System.out.println("human paddle x" + this.getX());
//System.out.println("human paddle y" + this.getY());
        //System.out.println(this.posY);

        if (movingUp){
            ((Rectangle) this.getShape()).translate(0, -dy);
            this.setPosY(getY()-dy);
        } else if(movingDown){
            ((Rectangle) this.getShape()).translate(0, dy);
            this.setPosY(getY()+dy);
        }



    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingUp(boolean up) {
        this.movingUp = up;
    }

    public void setMovingDown(boolean down) {
            this.movingDown = down;
    }

}
