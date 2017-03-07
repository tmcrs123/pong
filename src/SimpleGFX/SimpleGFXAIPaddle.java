package SimpleGFX;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public class SimpleGFXAIPaddle extends SimpleGFXMovableRepresentable{




        public SimpleGFXAIPaddle(int x, int y, int width, int height) {
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
        ((Rectangle) this.getShape()).translate(0, dy);
        this.setPosY(getY()+dy);
        this.setPosX(getX()+dx);

    }


}

