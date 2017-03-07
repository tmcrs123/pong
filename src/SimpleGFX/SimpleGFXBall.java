package SimpleGFX;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public class SimpleGFXBall extends SimpleGFXMovableRepresentable {




    public SimpleGFXBall(int x, int y, int width, int height) {
        super(new Ellipse(x, y, width, height));
        this.width = width;
        this.heigth = height;
        this.setPosX(x);
        this.setPosY(y);
        ((Ellipse) getShape()).fill();
        ((Ellipse) getShape()).setColor(Color.WHITE);
    }


    @Override
    public void move(double dx, double dy) {
        ((Ellipse) this.getShape()).translate(dx, dy);
        this.setPosY(getY() + dy);
        this.setPosX(getX() + dx);
    }


}


