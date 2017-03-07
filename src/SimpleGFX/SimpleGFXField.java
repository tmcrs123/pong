package SimpleGFX;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public class SimpleGFXField extends SimpleGFXRepresentable {

    private static final double MARGIN_TOP = 10;
    private static final double MARGIN_LEFT = 10;


    public SimpleGFXField( int height, int width) { //need to downcast from superclass shape property

        super(new Rectangle(MARGIN_LEFT, MARGIN_TOP, width, height));
        ((Rectangle)this.getShape()).fill();
        this.width = width;
        this.heigth = height;
    }



}
